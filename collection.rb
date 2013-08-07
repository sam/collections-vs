require "benchmark"

ALPHABET = ('a'..'z').to_a

def iterate(count)
  count.times do
    letter_list = []
    100_000.times { letter_list << ALPHABET[rand(26)] }
    pick = letter_list.uniq[rand(26)]
    before, after = letter_list.partition { |n| n > pick }
  end
end

Benchmark::bmbm do |x|
  x.report("10000") do
    iterate(100)
  end

  x.report("100") do
    iterate(100)
  end
end