Given an input data and a substring to search within the data, return if the substring can be found in the data with atmost one error (1 insertion or 1 deletion), index where the substring starts and the matched substring from input. If multiple matches found, return all of their indexes.

For example:

Data: "helloworlditstimetoleetcodebyeworld"

substring: world -> return (True, (5, 30), (world, world)) -> exact match
substring: byewrld -> return (True, (28), (byeworld)) -> 1 deletion
substring: timetwoleetcode -> return (True, (13) ,(timetoleetcode)) -> 1 insertion
substring: wrld -> return (True, (5,30) (world,world))
substring: notinit -> return (False,(None),(None)