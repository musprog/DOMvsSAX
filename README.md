DOM VS. SAX
-------------------------------
SAX
Stands for Simple API for XML, it’s an event-driven, serial-access mechanism for accessing XML documents. 
The SAX is useful for applications that required not more than transmit or reading XML document. 
Using SAX make harder to visualize or modify the contents of your XML documents because its event-driven model, 
SAX like any I/O streams useful only for reading.

DOM
Stands for Domain Object Model (DOM) is useful to modify XML documents, due to its larger memory usage and structure , 
DOM allow application to access multiple data and not only serial access. 
DOM provides us a complete CRUD (Create, Read, Update, Delete) functions to modify your XML document.

Structure
SAX doesn’t use a tree structure to parse the XML documents, instead uses streams to read which make it impossible to 
go the previews node, in the other hand, DOM provides a complete hierarchy as tree structure which gives the advantage 
of accessing arbitrary nodes or elements.

Performance
SAX uses low memory during the parsing of the XML documents and doesn’t any store result, therefore SAX is faster to parse. 
DOM required more memory usage to parse XML documents which makes it slower than SAX.

Disadvantages
Obviously, the downside for SAX is the lack of functionalities for inserting, deleting or modifying of XML document nodes, 
it’s also can’t preserve comments.

DOM is slower than SAX and can get complicated to implement for large applications.
Usability Both SAX and DOM are used to parse the XML document. Both have benefits and can be used depending on the developer 
and application requirements. SAX is useful for state-independent applications, while DOM is suitable for applications to modify 
it interactively.

References 
http://docs.oracle.com/javase/tutorial/jaxp/sax/index.html 
http://docs.oracle.com/javase/tutorial/jaxp/dom/index.html