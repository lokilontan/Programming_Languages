myremoveduplicates :: (Eq a) => [a] -> [a]
myremoveduplicates list
    | null list                          = list
    | elem (head list) (tail list)       = myremoveduplicates (tail list)
    | otherwise                          = head list : myremoveduplicates (tail list)

myremoveduplicates_pm :: (Eq a) => [a] -> [a]
myremoveduplicates_pm [] = []
myremoveduplicates_pm (x:xs)
    | elem x xs                          = myremoveduplicates_pm xs
    | otherwise                          = x : myremoveduplicates_pm xs

myintersection :: (Eq a) => [a] -> [a] -> [a]
myintersection list1 list2
    | null list1 || null list2            = []
    | elem (head list1) list2             = head list1 : myintersection (tail list1) list2
    | otherwise                           = myintersection (tail list1) list2

myintersection_pm :: (Eq a) => [a] -> [a] -> [a]
myintersection_pm [] list = []
myintersection_pm list [] = []
myintersection_pm (x:xs) list2
    | elem x list2                        = x : myintersection_pm xs list2
    | otherwise                           = myintersection_pm xs list2

mynthtail :: Int -> [a] -> [a]
mynthtail n list
    | null list                     = []
    | n == 0                        = list
    | otherwise                     = mynthtail ( n - 1 ) ( tail list )

mynthtail_pm :: Int -> [a] -> [a]
mynthtail_pm n [] = []
mynthtail_pm 0 list = list
mynthtail_pm n (x:xs) = mynthtail_pm ( n - 1 ) xs

mylast :: [a] -> [a]
mylast list
    | null list                    = list
    | null (tail list)             = list
    | otherwise                    = mylast (tail list)    

mylast_pm :: [a] -> [a]
mylast_pm [] = []
mylast_pm (x:xs)
    | null xs                      = (x:xs)
mylast_pm (_:xs) = mylast_pm xs 

myreverse :: [a] -> [a]
myreverse list = myreverse_helper list []

myreverse_helper :: [a] -> [a] -> [a]
myreverse_helper list reverse 
    | null list         = reverse
    | otherwise         = myreverse_helper (tail list) ( (head list):reverse )

myreverse_pm :: [a] -> [a]
myreverse_pm (x:xs) = myreverse_helper_pm (x:xs) []

myreverse_helper_pm :: [a] -> [a] -> [a]
myreverse_helper_pm [] reverse = reverse 
myreverse_helper_pm (x:xs) reverse = myreverse_helper_pm xs (x:reverse)

myreplaceall :: (Eq a) => a -> a -> [a] -> [a]
myreplaceall to from list 
    | null list             = []
    | head list == from     = to:myreplaceall to from (tail list)
    | otherwise             = (head list):myreplaceall to from (tail list)

myreplaceall_pm :: (Eq a) => a -> a -> [a] -> [a]
myreplaceall_pm to from [] = []
myreplaceall_pm to from (x:xs) 
    | from == x                = to:myreplaceall_pm to from xs
myreplaceall_pm to from (x:xs) = x:myreplaceall_pm to from xs

myordered :: (Ord a) => [a] -> Bool
myordered list 
    | null list                            = True
    | (head list) > (head (tail list))     = False
    | otherwise                            = myordered (tail list)

myordered_pm :: (Ord a) => [a] -> Bool
myordered_pm [] = True
myordered_pm (x:(y:ys)) 
    | x > y                 = False
myordered_pm (_:xs) = myordered_pm xs