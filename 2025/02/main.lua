-- get input
-- local input = io.open("exampleInput02.txt", "r")
local input = io.open("input02.txt", "r")
local converted = input:read("*all")
input:close()

-- split by comma
local ranges = {}
for each in converted:gmatch("[^,]+") do
	table.insert(ranges, each)
end

-- result to print
local total = 0

-- compare the halves

function has_pattern(num)
	-- convert to string first
	local number_string = tostring(num)
	if #number_string % 2 ~= 0 then
		return 0
	end

	-- split if even
	local middle = #number_string / 2
	local first_half = number_string:sub(1, middle)
	local second_half = number_string:sub(middle + 1)

	if first_half == second_half then
		return num
	else
		return 0
	end
end

-- now iterate through each range
for i, range in ipairs(ranges) do
	local parts = {}
	for part in range:gmatch("[^-]+") do
		table.insert(parts, part)
	end

	local start_num = tonumber(parts[1])
	local end_num = tonumber(parts[2])
	for num = start_num, end_num do
		total = total + has_pattern(num)
	end
end

print(total)
