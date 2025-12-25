-- get input
local input = io.open("exampleInput02.txt", "r")
local converted = input:read("*all")
input:close()

-- split by comma
local ranges = {}
for each in converted:gmatch("[^,]+") do
	table.insert(ranges, each)
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
		print(num)
	end
end
