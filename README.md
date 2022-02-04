# quantcast coding assessment

The file need to be complied using the command "javac most_active_cookie.java" 

The file can be run using the command "java most_active_cookie (csv_path) -d (YYYY-MM-DD)". Note that csv file must be in the same folder as the executable or you can give the absolute path of the csv file. 

I implemented a CookiesLog object which stores information about cookies and dates. The CookiesLog object uses a hashmap* where the key represent the date and the value represents a list of cookies (organized as a linkedList, or CookiesList). The CookiesLog uses the method addInfomrationFromCSV to read a csv file and store the relavent information.

The CookiesList object is a LinkedList object! The nodes contain information about the cookie's name and frequency.

The Date object is used to process date string. Since the inputs are already in order, the hashmap implementation inherently stores information about the cookie's latest time (For a given day or chain, the cookies near the front occur the lastest).

You can use the CookiesLog's toString() method to see the table representation of the date and corresponding. Note: The printing may not be in order according to date because the keys aren't stored in sorted order.

If you want to run test_cookiesLog.java, you will need to change the path and download the files.  

*I used the hashmap libary because python has it built in. 
