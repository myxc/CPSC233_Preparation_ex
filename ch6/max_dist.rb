test_array = [1, 4, 7, 3, 3, 5]  
front_element = 0
back_element = test_array.size - 1
end_of_array = test_array.size - 1
def check_next_front_ele
	front_element ++ #increments to the next indice for the front of the array
	front_and_back_index_values = [test_array[front_element], test_array[back_element]].sort #get sorted values for front and back indices
	(0..front_element - 1).each do |front_index| #block to check values that are ahead of the "adjacent values" elements
		if test_array[front_index].between?(front_and_back_index_values[0]..front_and_back_index_values[1])
			return false#breaks out of method returning false which means that the values ahead of the "adjacent values" are not all outside of the range
		end
	end
	return true #if the entire block passes the test, only then will the method reach this line, returning true.
end
def check_next_back_ele
	back_element --
	front_and_back_index_values = [test_array[front_element], test_array[back_element]].sort
	(back_element + 1..end_of_array).each do |front_index|
		if test_array[front_index].between?(front_and_back_index_values[0]..front_and_back_index_values[1])
			return false#breaks out of method
		end
	end
	return true
end


while front_element != back_element and check_next_front_ele == false and check_next_back_ele == false
	if check_next_front_ele == false
		check_next_back_ele
	end
end