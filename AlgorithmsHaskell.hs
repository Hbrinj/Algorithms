--Insertion sort

ins 			:: [Int] -> [Int] -> [Int]
ins [x] ys		= plce ys x
ins (x:xs) ys	| length ys > 0 = ins xs (plce ys x)
				| otherwise 	= ins xs (x:ys)

plce			:: [Int] -> Int -> [Int]
plce [x] y 		| x >= y 	= y:[x]
				| otherwise = x:[y]
plce (x:xs) y	| x >= y 	= y:x:xs
				| otherwise = x:(plce xs y)
				
--bubble sort

bubble 			:: [Int] -> [Int]
bubble [x]		= [x]
bubble (x:y:xs) | x >= y 		= bubble (y:x:xs)
				| otherwise 	= x:(bubble (y:xs))


bubble1			:: [Int] -> [Int]
bubble1	xs		| xs == sorted 	= sorted
				| otherwise		= bubble1 (sorted)
				where
					sorted = bubble xs

-- merge sort

merge					:: [Int] -> [Int] -> [Int]
merge [x] [z]			= if x > z then z:[x] else x:[z]
merge [x] q@(z:zs)		| x > z 		= z:(merge [x] zs)
						| otherwise 	= x:q
merge r@(x:xs) [z]		| z > x 		= x:(merge [z] xs)
						| otherwise 	= z:r
merge r@(x:xs) q@(z:zs) | x > z 		= z:(merge r zs)
						| otherwise 	= x:(merge xs q)	

mergesort				:: [Int] -> [Int]
mergesort [x]			= [x]
mergesort xs			= merge (mergesort ls) (mergesort rs)
	where 
		(ls,rs) = splitAt middle xs
		middle = if odd len then div (len-1) 2 else div len 2
		len = length xs