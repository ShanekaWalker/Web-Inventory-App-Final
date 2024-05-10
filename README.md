Shaneka Walker
# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS

Task C - Customize HTML
Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

**NOTE** added style to mainscreen.html and about.html files at the end some line may have shifted downward. Also added comments to code throughout for better organization and communication. 

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

Task F - Add "Buy Now Button"
Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters: • The “Buy Now” button must be next to the buttons that update and delete products. • The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts. • Display a message that indicates the success or failure of a purchase.

FileName: Mainscreen.html
Line Number: 
*88 added Buy Now button //not currently working

FileName: AddProductController
Line Number:
*177-190- added decrement code and to return confirmation or error pages
-added purchase confirmation and purchase error pages
-added purchasecontroller 


Task G - Track Min/Max of Inventory
Modify the parts to track maximum and minimum inventory by doing the following: • Add additional fields to the part entity for maximum and minimum inventory. • Modify the sample inventory to include the maximum and minimum fields. • Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values. • Rename the file the persistent storage is saved to. • Modify the code to enforce that the inventory is between or at the minimum and maximum value.

FileName: Part.java
Line Number:
*32-35 added min and max inventory
*58-65 - added overload constructor for min/max inventory
*100-103 - added getters and setters for min/max inventory

FileName: boostrapdata.java
Line Number:
*72-109 - added min/max inventory to all parts

FileName: mainscreen.html
Line Number:
*49-51 -added min max to mainscreen
*38-39 - added min/max table heading to page


FileName: Inhousepartform.html
Line Number:
*24-25 - added min max to page

FileName: OutsourcePartForm.html
Line Number:
*25-26 - added min max to page

-Created files minmaxvalidator.java and validminmax.java under validators
Renamed persistent storage from spring-boot-h2-db102 to SkateSocietyDB


Task H - Validation Test of Min/Max of Inventory
Add validation for between or at the maximum and minimum fields. 
The validation must include the following: • Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts. • Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum. • Display error messages when adding and updating parts if the inventory is greater than the maximum.

5/9/2024 - 

fixed min/max validation code in part.java
lines 36-39 should display error message if min is below 0 and max is above 100
updated error code in inhousepartform.html
lines 34-36
16-25 added display

addpartcontroller.java
added validation against min/max inventory
lines 73-91

minmaxvalidator.java
updated all code in this file for validation logic

part.java
fixed code when adding min/max inventory to parts
lines 35-39

addproductcontroller.java
fixed code for buy now button to properly buy and subtract from product inventory
lines 180-192

mainscreen.html
fixed buynow button code to properly align with controller


---------------------------------------------------------------------------
FileName: OutsourcePartForm.html
LineNumber:
*31-32 added error message if inventory is below minimum or above max

FileName: InhousePartForm.html
LineNumber:
*30-32 - added error message if inventory is below minimum or above max


FileName: EnufPartsValidtor.java
LineNumber:
*37 added check if adding more products lowers part inventory below minimum


Task I - Add at least 2 unit tests for the max and min fields of the PartTest class in the test package

FileName: Parttest.java
Line Number:
*160-176 - added 2 tests(min/max inventory)


Task J - Remove the class files for any unused validators in order to clean up your code
- deleted part validator never used, so deleted it. 


