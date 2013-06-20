(ns heuristomancer.core-test
  (:use [clojure.test]
        [heuristomancer.core]
        [heuristomancer.loader :only [resource-reader]]))

(defn- parse-test-file
  "Parses a test file and returns the result."
  [path]
  (with-open [r (resource-reader path)]
    (identify r)))

(defn- test-file-type-identification
  "Verifies that a file type is identified correctly."
  [[path expected]]
  (testing (str path " identified as " expected)
    (is (= expected (parse-test-file path)))))

(def ^:private tests
  [["foo.csh"                 :csh]
   ["foo.tcsh"                :tcsh]
   ["foo.sh"                  :sh]
   ["foo.bash"                :bash]
   ["foo.pl"                  :perl]
   ["foo.py"                  :python]
   ["dna-quote.ace"           :ace]
   ["dna-colon.ace"           :ace]
   ["peptide-quote.ace"       :ace]
   ["peptide-colon.ace"       :ace]
   ["protein-quote.ace"       :ace]
   ["protein-colon.ace"       :ace]
   ["sequence-quote.ace"      :ace]
   ["sequence-colon.ace"      :ace]
   ["test.ace"                :ace]
   ["blastp2215.blast"        :blast]
   ["bug2246.blast"           :blast]
   ["frac_problems.blast"     :blast]
   ["frac_problems2.blast"    :blast]
   ["frac_problems3.blast"    :blast]
   ["foo.bowtie"              :bowtie]
   ["test.bowtie"             :bowtie]
   ["foo.clustalw"            :clustalw]
   ["T7.aln"                  :clustalw]
   ["hs_owlmonkey.aln"        :clustalw]
   ["longnames.aln"           :clustalw]
   ["mini-align.aln"          :clustalw]
   ["pep-266.aln"             :clustalw]
   ["testaln.aln"             :clustalw]
   ["foo.codata"              :codata]
   ["foo.embl"                :embl]
   ["test.embl"               :embl]
   ["test.embl2sq"            :embl]
   ["alnfile.fasta"           :fasta]
   ["genomic-seq.fasta"       :fasta]
   ["hs_owlmonkey.fasta"      :fasta]
   ["test.fasta"              :fasta]
   ["testaln.fasta"           :fasta]
   ["testaln2.fasta"          :fasta]
   ["test.cns.fastq"          :fastq]
   ["test.fastq"              :fastq]
   ["test_clear_range.fastq"  :fastq]
   ["test_singlets.cns.fastq" :fastq]
   ["testaln.fastq"           :fastq]
   ["foo-xy.fastxy"           :fastxy]
   ["foo-a.fastxy"            :fastxy]
   ["test.game"               :game]
   ["test.gcg"                :gcg]])

(deftest file-type-identification
  (dorun (map test-file-type-identification tests)))
