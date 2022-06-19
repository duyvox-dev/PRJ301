# ** LaptopsGo **

## Convinience marketplace to trade laptop from new to used for everybody.

LaptopsGo aims to provides an online marketplace with basic UI for user to quickly and easily buy and sell their product(laptop only), building a brigde to connect retail store that are looking for a platform to sell their product and buyer who want to buy a high quality product.

## Team

-   Phan Văn Tiếp Em (SE150335)
-   Võ Văn Bảo Duy (SE160175)
-   Lê Văn Hà (SE140685)

## User

-   Student, Officer, Online shop, and who want to buy and sell laptop

## Features

-   Create accounts.
-   Login, Logout.
-   View, sort, search product.
-   View and edit account.

#### Admin

-   Ban user.
-   Search, Remove seller's product.
-   Manage categories.
-   Review, Approve, Ignore reports.

#### Buyer:

-   Add products to cart.
-   View, change quantity, Remove cart items.
-   Checkout.
-   Report products.

#### Seller:

-   Submit products to sell.
-   View , Edit, Remove products.

## Sitemap

![LaptopsGo SiteMap](./assets/sitemap.png)

## Wireframe

#### Home page:

![LaptopsGo HomePage](./assets/wireframes/LaptopsGo_Home.png)

#### Product detail page:

![LaptopsGo DetailPage](./assets/wireframes/LaptopsGo_Details.png)

#### Cart page:

![LaptopsGo CartPage](./assets/wireframes/LaptopsGo_Cart.png)

#### CheckOut page:

![LaptopsGo CheckOutPage](./assets/wireframes/LaptopsGo_CheckOut.png)

#### SellerDashboard page: (only for seller role)

![LaptopsGo SellerDashboard](./assets/wireframes/LaptopsGo_SellerDashBoardPage.png)

#### Submit product page: (only for seller role)

![LaptopsGo Submit](./assets/wireframes/LaptopsGo_SubmitProduct.png)

#### Review report page: (only for admin role)

![LaptopsGo Report page](./assets/wireframes/LaptopsGo_ReviewReport.png)

#### Account list page: (only for admin role)

![LaptopsGo accountList page](./assets/wireframes/LaptopsGo_AccountList.png)

#### Login page:

![LaptopsGo accountList page](./assets/wireframes/LaptopsGo_Login.png)

#### Register page:

![LaptopsGo accountList page](./assets/wireframes/LaptopsGo_Register.png)

#### Account page:

![LaptopsGo accountList page](./assets/wireframes/LaptopsGo_AccountManager.png)

## Database Design

#### Logical design (buyer, seller and admin role are splitted to present seperately from Users entity)

![LaptopsGo Logical Database Design](./assets/database-design/logical-database-design-split-role.png)

#### Physical design

The database diagram bellow shows how the system's logical design is implemented in the database. Three roles Buyer, Seller and Admin entities in logical design are grouped into only one entity User in physical design.

![LaptopsGo Physical Database Design](./assets/database-design/physical-design.png)
