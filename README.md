# quantcast coding assessment

The file need to be complied using the command "javac most_active_cookie.java" 

The file can be run using the command "java most_active_cookie (csv_path) -d (YYYY-MM-DD)". Note that csv file must be in the same folder as the executable. 

I used the hashMap library because python have a built in dictionary so I figured I can use a hashMap. (I can build a hashMap from scratch).

The CookiesLog stores the data of the csv file into a hashmap implemented using seperate chaining (LinkedList). The key for the hashmap represent that the date and the chain contain information about cookies found on those date and their frequency. 

The dateTime object is used to process timestamps. However, we can also get away without saving information about the time. Since the hashmap implementation inherently stores information about the time (For a given day or chain, the cookies near the front occur the lastest).

You can use the CookiesLog's toString() method to see the table representation of the date and corresponding. Note: The printing may not be in order according to date because the keys aren't stored in sorted order. I would have to use a treeSet, but I didn't even know if I was allowed to use a hashSet. 

If you want to run test_cookiesLog.java, you will need to change the path and download the files.  
