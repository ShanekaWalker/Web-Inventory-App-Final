# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS

# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS

Task C - Customize HTML
Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

File Name: Mainscreen.html
Line Numbers:
14- Changed title to Skate Society
19- Changed 'Shop' to Skate Society
21- Changed 'Parts' to Skateboard Parts
53- Changed 'Products' to Complete Skateboards

Task D - "About" Page
Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

Added File about.html
Line Number:
6-10- added style to the page
 13-18 - Changed the title, added information about Skate Society, added link back to mainscreen.

File: mainscreen.html
Line Number:
17-19 - added navigation to about.html from mainscreen
- Added AboutPageController.java to help with linking from about to main page. 



Task E - Sample Inventory
Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database. Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.

File Name: BootStrap Data
Line Number:
*33 - added private final inhousePartRepo
*35 - added inhousePartRepo a one of the parameters 
*38 - added this.inhousepartrepopository
*67-102- added 5 parts to part repo
*104-115- added 5 products to product repo

