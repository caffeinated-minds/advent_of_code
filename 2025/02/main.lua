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

-- result to print/return in the end
local total = 0

-- compare the halves

function has_pattern(num)
	-- convert to string first
	local number_string = tostring(num)

	-- check through possible pattern lengths
	for pattern_length = 1, (#number_string / 2) do
		local pattern = number_string:sub(1, pattern_length)

		-- does the pattern divide our string evenly?
		if #number_string % pattern_length == 0 then
			-- how many times would it repeat
			local times = #number_string / pattern_length
			local repeated = pattern:rep(times)

			if repeated == number_string then
				return num
			end
		end
	end
	return 0
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
