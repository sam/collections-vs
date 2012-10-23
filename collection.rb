start = Time.now
100.times do
  letter_list = []
  alphabet = ('a'..'z').to_a
  100_000.times{ letter_list << alphabet[rand(26)] }
  pick = letter_list.uniq[rand(26)]
  before, after = letter_list.partition{|n| n > pick}
end
p (Time.now - start) * 1000