package file.util;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Local_admin on 5/25/2017.
 */
public class ChangeLines {
    static int c = 0;

    public static void main(String[] args) {
        //info total
        int i1 = css1.split("\n").length;
        int i2 = css2.split("\n").length;
        int i21 = css21.split("\n").length;
        int i3 = css3.split("\n").length;
        int i4 = css4.split("\n").length;
        int total = i1 + i2 + i21 + i3 + i4;
        System.out.println("Total de lineas " + total);
        //add font size
        //int pixels = 4;
        int pixels = 6;
        String unit = "px";

        String oRes1 = addFontSize(res1, pixels, unit);
        String oRes2 = addFontSize(res2, pixels, unit);
        System.out.println("total font sizes modificados: " + c);//294
        System.out.println(oRes1);
        System.out.println(oRes2);

        System.out.println("***************************************************************");

        String o1 = addFontSize(css1, pixels, unit);
        String o2 = addFontSize(css2, pixels, unit);
        String o21 = addFontSize(css21, pixels, unit);
        String o3 = addFontSize(css3, pixels, unit);
        String o4 = addFontSize(css4, pixels, unit);
        //print results
        System.out.println("total font sizes modificados: " + c);//294
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o21);
        System.out.println(o3);
        System.out.println(o4);
    }

    private static String addFontSize(String input, int pixels, String unit) {
        List<String> list = Arrays.asList(input.split("\n"));
        for (int i = 0; i < list.size(); i++) {
            String curr = list.get(i);
            if(curr.contains("font-size") && curr.contains("px")) {
                //System.out.println("old " + curr);
                int indexPX= curr.indexOf("px");
                String currSize;
                if(curr.charAt(indexPX - 2) != ' ')
                    currSize = curr.substring(indexPX-2, indexPX);
                else
                    currSize = curr.substring(indexPX-1, indexPX);
                if(currSize.equals("0"))
                    continue;
                c++;
                int newSize = Integer.parseInt(currSize) + 2;
                String newCurr = curr.substring(0, indexPX - 2) + newSize + curr.substring(indexPX);
                //System.out.println("new " + newCurr);
                list.set(i, newCurr);
            }
        }
        return list.stream().reduce("", (a, b) -> a + "\n" + b);
    }

    static String css1 = ".Clear\n" +
            "{\n" +
            "    clear: both;\n" +
            "    height: 0px;\n" +
            "    line-height: 0px;\n" +
            "    font-size: 0px;\n" +
            "    margin: 0 !important;\n" +
            "    padding: 0 !important;\n" +
            "}\n" +
            "\n" +
            "@font-face { /*armando*/\n" +
            "    font-family: Phenomena;\n" +
            "    src: url(Fonts/phenomenaWOFF/PHENOMENA-REGULAR.WOFF);\n" +
            "}\n" +
            "* {\n" +
            "    font-family: phenomena !important;\n" +
            "    letter-spacing: 0.5pt;\n" +
            "} \n" +
            "/* -------------------------------------------------- \n" +
            "   Base Masterpage Style\n" +
            "-----------------------------------------------------*/\n" +
            "/*FrontMaster Begin*/\n" +
            ".FrontMaster\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    background-color: #FFF;\n" +
            "    margin: 0px;\n" +
            "    padding: 0px;\n" +
            "}\n" +
            ".FrontMasterTop\n" +
            "{\n" +
            "    width: inherit;\n" +
            "}\n" +
            ".FrontMasterMiddle\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    margin: 20px auto;\n" +
            "}\n" +
            ".FrontMasterBottom\n" +
            "{\n" +
            "    clear: both;\n" +
            "    width: inherit;\n" +
            "}\n" +
            ".MainDiv, .ProductMainDiv, .ContentMainDiv\n" +
            "{\n" +
            "    background-color: #FFF;\n" +
            "    padding: 20px 0;\n" +
            "    position: relative;\n" +
            "}\n" +
            ".AccountMainDiv\n" +
            "{\n" +
            "    background-color: #FFF;\n" +
            "    padding: 0;\n" +
            "    position: relative;\n" +
            "}\n" +
            ".ProductDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "}\n" +
            ".NoMargin\n" +
            "{\n" +
            "    margin: 0 auto;\n" +
            "}\n" +
            ".NoPadding\n" +
            "{\n" +
            "    padding: 0 auto;\n" +
            "}\n" +
            "/*FrontMaster End*/\n" +
            "/*Layout->Header Begin*/\n" +
            ".header-container1\n" +
            "{\n" +
            "    background-color: #eff2f9;\n" +
            "    border-bottom: solid 1px #ececec;\n" +
            "    height: 40px;\n" +
            "    position: absolute;\n" +
            "    width: 100%;\n" +
            "    z-index: 0;\n" +
            "}\n" +
            ".header-container2\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    min-height: 110px;\n" +
            "    margin: 0;\n" +
            "    padding: 0;\n" +
            "    background-color: #fff;\n" +
            "}\n" +
            ".header-container3 {\n" +
            "    width: inherit;\n" +
            "    min-height: 42px;\n" +
            "    margin: 0;\n" +
            "    /*background-color: rgb(155, 10,222); armando*/\n" +
            "    background: rgb(128, 0, 255); /* For browsers that do not support gradients */\n" +
            "    background: -webkit-linear-gradient(left, #939, #099); /* For Safari 5.1 to 6.0 */\n" +
            "    background: -o-linear-gradient(right, #939, #099); /* For Opera 11.1 to 12.0 */\n" +
            "    background: -moz-linear-gradient(right, #939, #099); /* For Firefox 3.6 to 15 */\n" +
            "    background: linear-gradient(to right, #939, #099); /* Standard syntax (must be last) */\n" +
            "    color: #fff;\n" +
            "}\n" +
            ".header-container4\n" +
            "{\n" +
            "    width: inherit;\n" +
            "    min-height: 40px;\n" +
            "    margin: 0;\n" +
            "    position: absolute;\n" +
            "    top: 0;\n" +
            "    right: 0;\n" +
            "    width: 50%;\n" +
            "}\n" +
            ".WebsiteTitle\n" +
            "{\n" +
            "    float: left;\n" +
            "    font-weight: normal;\n" +
            "    background: url(Images/Icon/icon-message.gif) no-repeat left center;\n" +
            "    padding-left: 25px;\n" +
            "    line-height: 35px;\n" +
            "}\n" +
            "/*Layout->Header End*/\n" +
            "/*Layout->Footer Begin*/\n" +
            "/* ---- ContentFooter ---- */\n" +
            ".LayoutFooter\n" +
            "{\n" +
            "    width: inherit;\n" +
            "    background-color: #2a353c;\n" +
            "    color: #fff;\n" +
            "    padding: 20px 0;\n" +
            "}\n" +
            ".LayoutFooter .MenuItemTitleOuter, .LayoutFooter a.MenuItemTitleOuter, .LayoutFooter .MenuItemTitle\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    text-transform: uppercase;\n" +
            "    line-height: 22px;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".LayoutFooter ul.MenuItem\n" +
            "{\n" +
            "    clear: left;\n" +
            "    list-style: none;\n" +
            "    margin: 0;\n" +
            "    padding: 10px 0 0;\n" +
            "}\n" +
            ".LayoutFooter ul.MenuItem li\n" +
            "{\n" +
            "}\n" +
            ".LayoutFooter ul.MenuItem li a.HyperLink\n" +
            "{\n" +
            "    height: 22px;\n" +
            "    line-height: 22px;\n" +
            "    padding: 0px;\n" +
            "    color: #fff;\n" +
            "    text-decoration: none;\n" +
            "    font-size: 12px;\n" +
            "}\n" +
            ".LayoutFooter ul.MenuItem li a.HyperLink:hover\n" +
            "{\n" +
            "    text-decoration: underline;\n" +
            "}\n" +
            ".MenuFooter.VendorMenu\n" +
            "{\n" +
            "    margin-bottom: 25px;\n" +
            "}\n" +
            "/* ---- license---- */\n" +
            ".LayoutFooterLicense\n" +
            "{\n" +
            "    background-color: #0e1215;\n" +
            "    line-height: 42px;\n" +
            "    width: inherit;\n" +
            "    color: #a2a2a2;\n" +
            "}\n" +
            ".LayoutFooterLicense a, .LayoutFooterLicense a:hover\n" +
            "{\n" +
            "    color: #a2a2a2;\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            ".LayoutFooterLicense div\n" +
            "{\n" +
            "    font-size: 11px !important;\n" +
            "}\n" +
            ".SocialLink\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 20px 0 0;\n" +
            "    display: block;\n" +
            "    text-align: left;\n" +
            "}\n" +
            ".SocialLink a\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-bottom: 5px;\n" +
            "    width: 30px;\n" +
            "    height: 30px;\n" +
            "    font-weight: normal;\n" +
            "    vertical-align: middle;\n" +
            "    line-height: 30px;\n" +
            "    color: #fff;\n" +
            "    text-decoration: none;\n" +
            "    margin-right: 10px;\n" +
            "    font-size: 0;\n" +
            "}\n" +
            ".SocialLink a:hover\n" +
            "{\n" +
            "    color: #000;\n" +
            "}\n" +
            ".FaceBookIcon\n" +
            "{\n" +
            "    background: url(Images/Icon/icon-facebook.png)no-repeat left center;\n" +
            "}\n" +
            ".GoogleIcon\n" +
            "{\n" +
            "    background: url(Images/Icon/icon-google.png)no-repeat left center;\n" +
            "}\n" +
            ".EmailIcon\n" +
            "{\n" +
            "    background: url(Images/Icon/icon-mail.png)no-repeat left center;\n" +
            "}\n" +
            ".BlogIcon\n" +
            "{\n" +
            "    background: url(Images/Icon/icon-blog.png)no-repeat left center;\n" +
            "}\n" +
            ".copyright-footer\n" +
            "{\n" +
            "    position: relative;\n" +
            "}\n" +
            ".poweredby-footer\n" +
            "{\n" +
            "    position: absolute;\n" +
            "    right: 20px;\n" +
            "    top: 0;\n" +
            "}\n" +
            "/*Layout->Footer End*/\n" +
            "/*[Common Page]-[Common Login]-[Content Layout] Page Begin*/\n" +
            ".CommonPage, .CommonLoginPage, .ContentLayout\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    margin: 0 auto 10px;\n" +
            "}\n" +
            ".CommonPageTop, .CommonLoginPageTop, .ContentLayoutTop\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    min-height: 45px;\n" +
            "    line-height: 38px;\n" +
            "    vertical-align: middle;\n" +
            "    text-align: left;\n" +
            "    padding-bottom: 2px;\n" +
            "    border-bottom: 3px dotted rgb(184, 184, 184);\n" +
            "}\n" +
            ".CommonPageTopTitle, .CommonLoginPageTitle, .ContentLayoutTopTitle\n" +
            "{\n" +
            "    color: #000;\n" +
            "    font-size: 19px;\n" +
            "    padding: 8px 0;\n" +
            "    text-transform: uppercase;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".CommonPageRight, .CommonLoginPageRight, .ContentLayoutRight\n" +
            "{\n" +
            "    padding: 30px 0;\n" +
            "}\n" +
            ".CommonPageTopImgLeft, .CommonPageTop .CommonPageImgLeft, .CommonPageTopImgRight, .CommonPageTop .CommonPageImgRight, .CommonPageBottom, .CommonLoginPageTopImgLeft, .CommonLoginPageTop .CommonLoginPageImgLeft, .CommonLoginPageTopImgRight, .CommonLoginPageTop .CommonLoginPageImgRight .CommonLoginPageBottom, .ContentLayoutTopImgLeft, .ContentLayoutTop .ContentLayoutImgLeft, .ContentLayoutTopImgRight, .ContentLayoutTop .ContentLayoutImgRight, .ContentLayoutBottom\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "/*[Common Page]-[Common Login]-[Content Layout] Page End*/\n" +
            "/*CommonGridView Begin*/\n" +
            ".CommonGridView\n" +
            "{\n" +
            "    border: solid 1px #f0f0f0;\n" +
            "    width: 100%;\n" +
            "    clear: both;\n" +
            "    margin-top: 10px;\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            ".CommonGridViewHeaderStyle\n" +
            "{\n" +
            "    background-color: #fbfcfe;\n" +
            "    border-top: solid 1px #f0f0f0;\n" +
            "    height: 32px;\n" +
            "    color: #000;\n" +
            "    padding: 3px;\n" +
            "}\n" +
            ".CommonGridViewHeaderStyle th\n" +
            "{\n" +
            "    border: solid 1px #f0f0f0;\n" +
            "    border-top: 0;\n" +
            "    padding: 3px 1%;\n" +
            "}\n" +
            ".CommonGridViewHeaderStyle a\n" +
            "{\n" +
            "    color: #000;\n" +
            "}\n" +
            ".CommonGridViewHeaderStyle a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".CommonGridViewRowStyle\n" +
            "{\n" +
            "    height: 32px;\n" +
            "    color: #000;\n" +
            "    border-bottom: solid 1px #f0f0f0;\n" +
            "}\n" +
            ".CommonGridViewAlternatingRowStyle\n" +
            "{\n" +
            "    background-color: white;\n" +
            "    border-bottom: solid 1px #f0f0f0;\n" +
            "    height: 32px;\n" +
            "    color: #000;\n" +
            "}\n" +
            ".CommonGridViewRowStyle > td, .CommonGridViewAlternatingRowStyle > td\n" +
            "{\n" +
            "    padding: 3px 1%;\n" +
            "    border-right: solid 1px #f0f0f0;\n" +
            "}\n" +
            ".CommonGridViewFooterStyle\n" +
            "{\n" +
            "    background-color: #fbfcfe;\n" +
            "}\n" +
            ".CommonGridViewEmptyRowStyle > td, div.CommonGridViewEmptyRowStyle\n" +
            "{\n" +
            "    background-color: #fbfcfe;\n" +
            "    color: #000;\n" +
            "    font-weight: normal;\n" +
            "    text-align: center;\n" +
            "    clear: left;\n" +
            "    width: 100%;\n" +
            "    line-height: 35px;\n" +
            "    height: 35px;\n" +
            "    padding: 3px 0;\n" +
            "    display: table;\n" +
            "}\n" +
            ".OrderHistoryGridviewDiv .CommonGridViewEmptyRowStyle\n" +
            "{\n" +
            "    display: table;\n" +
            "    margin: auto;\n" +
            "}\n" +
            ".OrderHistoryGridviewDiv .CommonGridView\n" +
            "{\n" +
            "    background-color: #fbfcfe;\n" +
            "}\n" +
            ".CommonGridViewPageItemDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    line-height: 24px;\n" +
            "    color: #2a353c;\n" +
            "    margin-top: 8px;\n" +
            "    margin-bottom: 10px;\n" +
            "    letter-spacing: 0.2px;\n" +
            "}\n" +
            ".CommonGridViewItemsPerPageDiv\n" +
            "{\n" +
            "    float: left;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".CommonGridViewPagingDiv\n" +
            "{\n" +
            "    float: right;\n" +
            "}\n" +
            ".CommonGridViewPageItemDiv .ItemsPerPageDrop\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin: 3px 10px;\n" +
            "    background-color: #f4f4f4;\n" +
            "    border: solid 1px #d7d7d7;\n" +
            "    padding: 0;\n" +
            "}\n" +
            ".CommonGridViewHeaderStyle .ImageHeader\n" +
            "{\n" +
            "    border: 0;\n" +
            "    background-color: #fff;\n" +
            "}\n" +
            "/*Common Gridview End*/\n" +
            "/*CommonForm Begin*/\n" +
            ".CommonFormLabel\n" +
            "{\n" +
            "    width: 35%;\n" +
            "    float: left;\n" +
            "    padding: 2px 0px;\n" +
            "    margin-right: 2%;\n" +
            "    color: #000;\n" +
            "    clear: left;\n" +
            "    font-size: 12px;\n" +
            "    line-height: 25px;\n" +
            "}\n" +
            ".CommonFormData\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 60%;\n" +
            "    padding-top: 2px;\n" +
            "    padding-bottom: 2px;\n" +
            "}\n" +
            ".CommonFormDataSample\n" +
            "{\n" +
            "    font-size: 12px;\n" +
            "    color: #333;\n" +
            "}\n" +
            "/*CommonForm End*/\n" +
            "\n" +
            "/* CommonTopDynamicDropdown [Language,Currency]  Begin*/\n" +
            ".CurrencySwitch table, .LanguageSwitch table\n" +
            "{\n" +
            "    margin: 0;\n" +
            "}\n" +
            ".CommonTopDynamicDropdownList\n" +
            "{\n" +
            "    border: solid 1px #f0f0f0;\n" +
            "}\n" +
            "table.CommonTopDynamicDropdownListStaticMenuItem\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    z-index: 0;\n" +
            "    padding: 0;\n" +
            "    border: solid 1px #f0f0f0;\n" +
            "    background-color: #f9fafb;\n" +
            "    border: 0;\n" +
            "    margin: 0;\n" +
            "}\n" +
            "table.CommonTopDynamicDropdownListStaticMenuStyle td, table.CommonTopDynamicDropdownListStaticMenuItem td\n" +
            "{\n" +
            "    padding: 0;\n" +
            "    border: 0;\n" +
            "    margin: 0;\n" +
            "}\n" +
            ".CommonTopDynamicDropdownListStaticMenuItem td a\n" +
            "{\n" +
            "    color: #313131;\n" +
            "    font-size: 11px !important;\n" +
            "    display: block;\n" +
            "    margin: 0;\n" +
            "    text-decoration: none;\n" +
            "    vertical-align: middle;\n" +
            "    white-space: normal;\n" +
            "    padding: 0px 35px 0px 10px;\n" +
            "    background: url(Images/Bullet/SwitchDown.gif) no-repeat right center;\n" +
            "    line-height: 22px;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".CommonTopDynamicDropdownListDynamicMenuStyle table\n" +
            "{\n" +
            "    border: solid 1px #f0f0f0;\n" +
            "    margin: 0;\n" +
            "    padding: 0;\n" +
            "    border-radius: 0;\n" +
            "}\n" +
            "\n" +
            "table.CommonTopDynamicDropdownListDynamicMenuItem, .CommonTopDynamicDropdownListDynamicMenuStyle table tr td, table.CommonTopDynamicDropdownListDynamicMenuItem tr td\n" +
            "{\n" +
            "    margin: 0;\n" +
            "    padding: 0;\n" +
            "    border: 0;\n" +
            "}\n" +
            "\n" +
            ".CommonTopDynamicDropdownListDynamicMenuStyle\n" +
            "{\n" +
            "    z-index: 1001 !important;\n" +
            "    margin: 1px 0 0;\n" +
            "    padding: 0;\n" +
            "}\n" +
            "a.CommonTopDynamicDropdownListDynamicMenuItem\n" +
            "{\n" +
            "    z-index: 0;\n" +
            "    display: block;\n" +
            "    vertical-align: middle;\n" +
            "    color: #313131;\n" +
            "    padding: 4px 10px;\n" +
            "    font-size: 11px !important;\n" +
            "    min-width: 120px;\n" +
            "}\n" +
            "a.CommonTopDynamicDropdownListDynamicMenuItem:hover\n" +
            "{\n" +
            "    background-color: rgb(155, 10 ,222);\n" +
            "    color: #fff;\n" +
            "}\n" +
            "\n" +
            "/* CommonTopDynamicDropdown [Language,Currency]  End*/\n" +
            "/* Common SideBox Style Begin */\n" +
            ".CategoryNavList, .DepartmentNavList, .ManufacturerNavList, .NewsNavList, .FeaturedMerchants, .FindGiftRegistry, .JoinAffiliate, .NewArrivalCategory, .FacetedNavList, .MiniShoppingCart, .ProductSpecial, .VerifyCoupon, .RecentlyViewedBoxList, .MyAccountMenuList, .CompareProductBoxList, .OrderSummaryRightMenu, .GiftCouponDetailBox, .VendorSearchBox\n" +
            "{\n" +
            "    margin-bottom: 1px;\n" +
            "    display: block;\n" +
            "}\n" +
            "/* Common SideBox Style  End*/\n" +
            "/* Common SideBanner Box Style Begin*/\n" +
            ".SecureShoppingAd, .SpecialOfferAd, .FreeShippingAd, .LivePersonWidget, .LikeBoxWidget\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "    display: block;\n" +
            "}\n" +
            "/* Common SideBanner Box Style End*/\n" +
            "/*Common Sidebar Begin*/\n" +
            ".SidebarTop\n" +
            "{\n" +
            "    min-height: 35px;\n" +
            "    padding-bottom: 12px;\n" +
            "    padding-top: 10px;\n" +
            "    border-bottom: 3px dotted rgb(184, 184, 184);\n" +
            "}\n" +
            ".SidebarTopTitle\n" +
            "{\n" +
            "    color: #000000;\n" +
            "    font-size: 19px;\n" +
            "    font-weight: normal;\n" +
            "    line-height: 25px;\n" +
            "    padding: 5px 0;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".SidebarRight\n" +
            "{\n" +
            "    padding: 15px;\n" +
            "    border-top: 0;\n" +
            "}\n" +
            ".SidebarTopImgLeft, .SidebarTopImgRight, .SidebarBottom\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "/*Common Sidebar End*/\n" +
            "/*Common SideBanner Begin*/\n" +
            ".SideBannerTop, .SideBannerBottom\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".SideBannerRight\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".SideBannerRight table\n" +
            "{\n" +
            "    margin: auto;\n" +
            "}\n" +
            ".SideBannerRight img\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            "/*Common SideBanner End*/\n" +
            "/*Common CenterBlock Begin*/\n" +
            ".CenterBlockTop\n" +
            "{\n" +
            "    min-height: 35px;\n" +
            "    border-bottom: dotted 3px #b8b8b8;\n" +
            "}\n" +
            ".CenterBlockTopImgLeft, .CenterBlockTopImgRight\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".CenterBlockTopTitle\n" +
            "{\n" +
            "    color: #000;\n" +
            "    font-size: 19px;\n" +
            "    font-weight: normal;\n" +
            "    text-transform: uppercase;\n" +
            "    line-height: 25px;\n" +
            "    padding: 5px 0;\n" +
            "}\n" +
            "/*Common CenterBlock End*/\n" +
            "/* General Button Style Begin*/\n" +
            ".BtnStyle1, .BtnStyle2, .BtnStyle3, .BtnStyle4, .BtnLink, .AddToCartContinue, .AddCart, .ViewDetail\n" +
            "{\n" +
            "    display: block;\n" +
            "    float: left;\n" +
            "    font-size: 12px;\n" +
            "    line-height: 24px;\n" +
            "    margin: 0px 5px 2px 0;\n" +
            "    padding: 0 15px;\n" +
            "    text-decoration: none;\n" +
            "    vertical-align: middle;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ShippingButtonDiv .BtnStyle1\n" +
            "{\n" +
            "    float: right;\n" +
            "}\n" +
            ".BtnStyle1, .AddCart\n" +
            "{\n" +
            "    color: #fff;\n" +
            "    background-color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".ShoppingCartCheckoutLink, .ShoppingCartGiftRegistryLink, .BtnStyle2, .BtnStyle3\n" +
            "{\n" +
            "    color: #fff;\n" +
            "    background-color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".BtnStyle4\n" +
            "{\n" +
            "    color: #fff;\n" +
            "    background-color: #fa7405;\n" +
            "}\n" +
            ".AddToCartContinue, .ViewDetail\n" +
            "{\n" +
            "    color: #555;\n" +
            "    border: solid 1px #eee;\n" +
            "}\n" +
            ".BtnStyle5\n" +
            "{\n" +
            "    border: 0;\n" +
            "    font-weight: normal;\n" +
            "    font-size: 11px;\n" +
            "    line-height: 14px;\n" +
            "    margin-top: 5px;\n" +
            "    border: solid 1px #ddd;\n" +
            "}\n" +
            ".ButtonDelete\n" +
            "{\n" +
            "    color: #ff7900;\n" +
            "    text-decoration: none;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".BtnLink\n" +
            "{\n" +
            "    border: solid 1px #ccc;\n" +
            "    background-color: #eee;\n" +
            "    color: #999;\n" +
            "    text-transform: none;\n" +
            "}\n" +
            "\n" +
            ".BtnStyle1:hover\n" +
            "{\n" +
            "    color: #fff;\n" +
            "    background-color: #000;\n" +
            "}\n" +
            ".BtnStyle2:hover\n" +
            "{\n" +
            "    color: #fff;\n" +
            "    background-color: #000;\n" +
            "}\n" +
            ".BtnStyle3:hover, .BtnLink:hover\n" +
            "{\n" +
            "    color: #fff;\n" +
            "    background-color: #000;\n" +
            "}\n" +
            ".BtnStyle4:hover\n" +
            "{\n" +
            "    color: #fff;\n" +
            "    background-color: #000;\n" +
            "}\n" +
            ".BtnStyle5:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".ButtonDelete:hover\n" +
            "{\n" +
            "    color: #FF0000;\n" +
            "}\n" +
            ".CommonProductButton .BtnStyle1\n" +
            "{\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            "/*General Button Style End*/\n" +
            "/* Common AjaxTab Style Begin */\n" +
            ".ajax__tab_header\n" +
            "{\n" +
            "    height: 37px;\n" +
            "    z-index: 1;\n" +
            "    font-weight: normal;\n" +
            "    color: #999;\n" +
            "    border-bottom: solid 1px #ddd;\n" +
            "}\n" +
            "\n" +
            ".ajax__tab_header .ajax__tab_outer\n" +
            "{\n" +
            "    display: inline-block;\n" +
            "    color: #000;\n" +
            "    width: 140px;\n" +
            "    height: 37px;\n" +
            "    line-height: 37px;\n" +
            "    vertical-align: middle;\n" +
            "    margin-right: 4px;\n" +
            "    border: solid 1px #ddd;\n" +
            "    background: #f9fbfd;\n" +
            "    font-size: 16px;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".ajax__tab_header .ajax__tab_outer .ajax__tab_inner .ajax__tab_tab\n" +
            "{\n" +
            "    cursor: pointer;\n" +
            "}\n" +
            "\n" +
            ".ajax__tab_header .ajax__tab_outer .ajax__tab_inner .ajax__tab_tab div\n" +
            "{\n" +
            "    border: 0;\n" +
            "    width: 140px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            ".ajax__tab_header .ajax__tab_active .ajax__tab_outer\n" +
            "{\n" +
            "    width: 140px;\n" +
            "    height: 37px;\n" +
            "    line-height: 37px;\n" +
            "    vertical-align: middle;\n" +
            "    margin-right: 4px;\n" +
            "    filter: none;\n" +
            "    background: #fff;\n" +
            "    border: solid 1px #ddd;\n" +
            "    border-bottom: solid 1px #fff;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    position: relative;\n" +
            "    z-index: 1;\n" +
            "    font-size: 16px;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".ajax__tab_body\n" +
            "{\n" +
            "    border: 1px solid #ddd;\n" +
            "    padding: 15px;\n" +
            "    background-color: #fff;\n" +
            "    position: relative;\n" +
            "    z-index: 0;\n" +
            "    border-top: none;\n" +
            "}\n" +
            "/* Common AjaxTab Style End */\n" +
            "/* validator style begin */\n" +
            "\n" +
            ".CommonTextBox\n" +
            "{\n" +
            "    border: solid 1px #f0f0f0;\n" +
            "}\n" +
            ".CommonPageInnerTitle\n" +
            "{\n" +
            "    clear: left;\n" +
            "    color: #000000;\n" +
            "    float: left;\n" +
            "    font-size: 16px;\n" +
            "    font-weight: normal;\n" +
            "    line-height: 30px;\n" +
            "    margin: 10px 0 5px;\n" +
            "    padding: 5px 0;\n" +
            "    text-transform: uppercase;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".CommonPageInner\n" +
            "{\n" +
            "    padding-bottom: 10px;\n" +
            "    padding-left: 20px;\n" +
            "}\n" +
            ".CommonHyperLink\n" +
            "{\n" +
            "}\n" +
            ".CommonHyperLink:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            ".CommonTextEditorPanel\n" +
            "{\n" +
            "    margin-top: 20px;\n" +
            "}\n" +
            ".ajax__calendar_container\n" +
            "{\n" +
            "    background-color: #fff;\n" +
            "    border: solid 1px #ccc;\n" +
            "}\n" +
            "/* Validation style*/\n" +
            ".CommonOptionItemValidator\n" +
            "{\n" +
            "    font-size: 10px;\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            ".TextOptionItemValidator\n" +
            "{\n" +
            "    padding-left: 20px;\n" +
            "    font-size: 10px;\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            "\n" +
            ".CommonValidateText\n" +
            "{\n" +
            "    color: Red;\n" +
            "}\n" +
            ".CommonValidateDiv\n" +
            "{\n" +
            "    width: 90%;\n" +
            "    border-top: dotted;\n" +
            "    border-width: 1px;\n" +
            "    color: #FF0000;\n" +
            "    margin-bottom: 3px;\n" +
            "    margin-top: 1px;\n" +
            "}\n" +
            ".ShippingDiv .CommonValidateDiv\n" +
            "{\n" +
            "    width: 22%;\n" +
            "}\n" +
            ".PaymentDiv .CommonValidateDiv\n" +
            "{\n" +
            "    width: 72%;\n" +
            "}\n" +
            "\n" +
            ".CommonValidateCalendarDiv\n" +
            "{\n" +
            "    width: 90%;\n" +
            "    border-top: dotted;\n" +
            "    border-width: 1px;\n" +
            "    color: #FF0000;\n" +
            "    margin-bottom: 3px;\n" +
            "    margin-top: 1px;\n" +
            "}\n" +
            ".CommonValidateLong\n" +
            "{\n" +
            "    width: 90%;\n" +
            "}\n" +
            ".OptionValidateDiv\n" +
            "{\n" +
            "    width: 76px;\n" +
            "    border-bottom: dotted;\n" +
            "    border-width: 1px;\n" +
            "    color: #FF0000;\n" +
            "    margin-bottom: 2px;\n" +
            "}\n" +
            ".ProductKitValidateDiv\n" +
            "{\n" +
            "    width: 66px;\n" +
            "    border-bottom: dotted;\n" +
            "    border-width: 1px;\n" +
            "    color: #FF0000;\n" +
            "    margin-bottom: 2px;\n" +
            "}\n" +
            ".UploadValidateDiv\n" +
            "{\n" +
            "    width: 156px;\n" +
            "    border-bottom: dotted;\n" +
            "    border-width: 1px;\n" +
            "    color: #FF0000;\n" +
            "    margin-bottom: 2px;\n" +
            "}\n" +
            ".TextOptionValidateDiv\n" +
            "{\n" +
            "    padding-left: 20px;\n" +
            "    width: 86px;\n" +
            "    border-bottom: dotted;\n" +
            "    border-width: 1px;\n" +
            "    color: #FF0000;\n" +
            "    margin-bottom: 2px;\n" +
            "}\n" +
            "span.CommonAsterisk\n" +
            "{\n" +
            "    color: Red;\n" +
            "    font-weight: normal;\n" +
            "    padding-left: 2px;\n" +
            "}\n" +
            ".CommonValidatorText\n" +
            "{\n" +
            "    color: Red;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".CommonValidatorText img\n" +
            "{\n" +
            "    margin-bottom: 2px;\n" +
            "}\n" +
            ".CommonDisplayMessageDiv\n" +
            "{\n" +
            "    background-color: #F8F8F8;\n" +
            "    border: 1px dashed #FFDDDD;\n" +
            "    color: Blue;\n" +
            "    padding: 10px;\n" +
            "    text-align: left;\n" +
            "    margin-bottom: 13px;\n" +
            "    padding-left: 23px;\n" +
            "    font-size: 12px;\n" +
            "}\n" +
            ".CommonErrorMessageDiv\n" +
            "{\n" +
            "    background-color: #F8F8F8;\n" +
            "    border: 1px dashed #FFDDDD;\n" +
            "    color: Red;\n" +
            "    padding: 10px;\n" +
            "    text-align: left;\n" +
            "    margin-bottom: 13px;\n" +
            "    padding-left: 23px;\n" +
            "    font-size: 12px;\n" +
            "}\n" +
            ".CommonCreditCardValidateDiv\n" +
            "{\n" +
            "    width: 110px;\n" +
            "    border-top: dotted;\n" +
            "    border-width: 1px;\n" +
            "    color: #FF0000;\n" +
            "    margin-bottom: 3px;\n" +
            "    margin-top: 1px;\n" +
            "}\n" +
            ".CommonDropDown\n" +
            "{\n" +
            "    margin-right: 5px;\n" +
            "}\n" +
            ".CaptchaValidation\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 5px 0;\n" +
            "}\n" +
            ".CaptchaValidation ul\n" +
            "{\n" +
            "    padding: 0 0 0 15px;\n" +
            "    margin: 0;\n" +
            "    list-style-image: url(../../Images/Bullet/RequiredFillBullet_Up.gif);\n" +
            "    border-top: dotted 1px #ff0000;\n" +
            "}\n" +
            ".ajaxProgress\n" +
            "{\n" +
            "    position: fixed;\n" +
            "    text-align: center;\n" +
            "    z-index: 9999999 !important;\n" +
            "    top: 45%;\n" +
            "    left: 50%;\n" +
            "    width: 32px;\n" +
            "    height: 32px;\n" +
            "}\n" +
            "#ctl01_ctl00_uxWebsitePlaceHolder_uxUpdateProgress\n" +
            "{\n" +
            "    position: inherit !important;\n" +
            "}\n" +
            "\n" +
            "/* validator style end */\n" +
            "/*-- Common Product List Item Style :  Random, Best Selling, ProductList etc. Begin--*/\n" +
            ".CommonProductDataList\n" +
            "{\n" +
            "    width: 102%;\n" +
            "}\n" +
            ".CommonProductItemStyle {\n" +
            "    width: 23.125%;\n" +
            "    margin: 20px 1.5% 20px 0;\n" +
            "    display: inline-block;\n" +
            "    /*padding: 10px 0;armando*/\n" +
            "    vertical-align: top;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".DummyCommonProductItemStyle\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    display: table;\n" +
            "}\n" +
            "div.CommonProductImage\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    max-height: 200px;\n" +
            "    padding: 0;\n" +
            "    margin-bottom: 0px;\n" +
            "    z-index: 0;\n" +
            "    position: relative;\n" +
            "}\n" +
            "table.CommonProductImage\n" +
            "{\n" +
            "    width: inherit;\n" +
            "    height: 200px;\n" +
            "    text-align: center;\n" +
            "    padding: 0;\n" +
            "}\n" +
            ".CommonProductImage tr td\n" +
            "{\n" +
            "    vertical-align: top;\n" +
            "}\n" +
            ".CommonProductImage a\n" +
            "{\n" +
            "    display: block;\n" +
            "    margin: auto;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".CommonProductImage img {\n" +
            "    /*max-height: 190px; Armando*/\n" +
            "    /*max-width: 190px Armando;*/\n" +
            "    max-height: 220px;\n" +
            "    max-width: 220px;\n" +
            "    width: auto;\n" +
            "    height: auto;\n" +
            "    text-align: center; \n" +
            "}\n" +
            ".CommonProductImagePanel\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    height: 190px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".CommonProductName {\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 90%;\n" +
            "    margin: 10px 10px;\n" +
            "    line-height: normal;\n" +
            "    height: 30px;\n" +
            "    overflow: hidden;\n" +
            "    /*background: url(Images/Background/dot-line.jpg) repeat-x left bottom;armando*/\n" +
            "}\n" +
            ".CommonProductNameLink\n" +
            "{\n" +
            "    color: #000;\n" +
            "    text-decoration: none;\n" +
            "    font-size: 15px;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".CommonProductDescription\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin-bottom: 10px;\n" +
            "    line-height: 18px;\n" +
            "    font-size: 14px;\n" +
            "    color: #000;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".CommonProductRating\n" +
            "{\n" +
            "    clear: left;\n" +
            "    color: #777;\n" +
            "    font-size: 11px;\n" +
            "    font-style: italic;\n" +
            "    display: table;\n" +
            "    line-height: 30px;\n" +
            "    margin: 5px auto;\n" +
            "}\n" +
            ".CommonProductRating img {\n" +
            "    display:none;\n" +
            "}\n" +
            ".CommonProductRating .RatingCustomerMessageDiv\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".CommonProductQuantityDiscountPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 5px 0;\n" +
            "    display: none;\n" +
            "}\n" +
            ".CommonProductRecurringPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 5px 0;\n" +
            "    display: none;\n" +
            "}\n" +
            ".CommonProductFreeShippingPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 5px 0;\n" +
            "    display: none;\n" +
            "}\n" +
            ".CommonProductRecurringImage, .CommonProductQuantityDiscountPanel img, .CommonProductFreeShippingPanel img\n" +
            "{\n" +
            "    border: 0;\n" +
            "}\n" +
            ".CommonProductPriceDetails\n" +
            "{\n" +
            "    clear: left;\n" +
            "    display: table;\n" +
            "    line-height: 25px;\n" +
            "    margin: 4px auto;\n" +
            "}\n" +
            ".CommonProductSpecialLabel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "}\n" +
            ".CommonProductButton\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 90%;\n" +
            "    padding: 0px 0;\n" +
            "    margin: 0 5%;\n" +
            "    z-index: 0;\n" +
            "    position: relative;\n" +
            "    margin-bottom: 5px;\n" +
            "}\n" +
            ".CommonProductButton .BtnStyle1\n" +
            "{\n" +
            "    float: none;\n" +
            "    display: table;\n" +
            "    margin: auto;\n" +
            "    text-transform: uppercase;\n" +
            "    font-size: 11px;\n" +
            "    letter-spacing: 0.2px;\n" +
            "}\n" +
            ".OurPriceValue\n" +
            "{\n" +
            "    color: #000;\n" +
            "    font-weight: normal;\n" +
            "    line-height: 25px;\n" +
            "    font-size: 14px;\n" +
            "}\n" +
            ".CallForPrice\n" +
            "{\n" +
            "    color: #000;\n" +
            "    font-weight: normal;\n" +
            "    line-height: 25px;\n" +
            "    font-size: 16px;\n" +
            "}\n" +
            ".RetailPricePanel\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin: 0 2px;\n" +
            "    text-align: center;\n" +
            "    color: #66767b;\n" +
            "    text-decoration: line-through;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".OurPricePanel\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin: 0 2px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".RetailPriceValue\n" +
            "{\n" +
            "    color: #66767b;\n" +
            "    text-decoration: line-through;\n" +
            "    float: left;\n" +
            "}\n" +
            ".OurPriceLabel, .RetailPriceLabel, .CommonProductAddCartImage, .CommonProductTellFriendImage\n" +
            "{\n" +
            "}\n" +
            ".OptionGroupPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    display: table;\n" +
            "    line-height: 25px;\n" +
            "    margin: 10px auto;\n" +
            "}\n" +
            ".DiscountPercent\n" +
            "{\n" +
            "    text-decoration: none;\n" +
            "    float: left;\n" +
            "    color: #5DA423;\n" +
            "    font-size: 12px;\n" +
            "}\n" +
            ".DiscountLabel\n" +
            "{\n" +
            "    color: #1e1e1e;\n" +
            "    font-size: 11px;\n" +
            "    margin-right: 5px;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    text-align: left;\n" +
            "    background: url(Images/Icon/icon-quantity.gif) no-repeat left center;\n" +
            "    padding-left: 22px;\n" +
            "    line-height: 22px;\n" +
            "}\n" +
            ".FreeShippingLabel\n" +
            "{\n" +
            "    color: #1e1e1e;\n" +
            "    font-size: 11px;\n" +
            "    margin-right: 5px;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    text-align: left;\n" +
            "    background: url(Images/Icon/icon-free-shipping.gif) no-repeat left center;\n" +
            "    padding-left: 25px;\n" +
            "    line-height: 22px;\n" +
            "}\n" +
            ".PercentLabel\n" +
            "{\n" +
            "    color: #ff3737;\n" +
            "    margin-left: 10px;\n" +
            "}\n" +
            ".PercentValue\n" +
            "{\n" +
            "    color: #ff3737;\n" +
            "    font-size: 14px;\n" +
            "}\n" +
            "\n" +
            ".PriceDiscountLabel\n" +
            "{\n" +
            "    background-color: #ff7301;\n" +
            "    border-radius: 30px 30px 30px 30px;\n" +
            "    color: #FFFFFF;\n" +
            "    height: 45px;\n" +
            "    left: 10px;\n" +
            "    line-height: 16px;\n" +
            "    padding: 8px 5px 5px;\n" +
            "    position: absolute;\n" +
            "    text-align: center;\n" +
            "    top: 10px;\n" +
            "    width: 45px;\n" +
            "    z-index: 1;\n" +
            "}\n" +
            ".Default .DiscountPercent\n" +
            "{\n" +
            "    float: none;\n" +
            "}\n" +
            ".Default .PercentLabel, .Default .PercentValue\n" +
            "{\n" +
            "    color: #fff;\n" +
            "    margin: 0;\n" +
            "    font-style: italic;\n" +
            "    font-weight: bold;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".QuickViewPanel .PercentLabel, .QuickViewPanel .PercentValue\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    margin: 0;\n" +
            "    font-style: italic;\n" +
            "    font-weight: bold;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".Default .PercentLabel\n" +
            "{\n" +
            "    font-size: 85%;\n" +
            "}\n" +
            "/*-- Common Product List Item Style End --*/\n" +
            "/*-- Common Category List Item Style Begin --*/\n" +
            ".CommonCategoryDataList\n" +
            "{\n" +
            "    width: 102%;\n" +
            "}\n" +
            ".CommonCategoryItemStyle\n" +
            "{\n" +
            "    width: 14.18%;\n" +
            "    margin: 10px 2% 10px 0;\n" +
            "    display: inline-block;\n" +
            "    vertical-align: top;\n" +
            "}\n" +
            "div.CommonCategoryImage\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    max-height: 95px;\n" +
            "    padding: 0;\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            "table.CommonCategoryImage\n" +
            "{\n" +
            "    width: inherit;\n" +
            "    height: 95px;\n" +
            "    text-align: center;\n" +
            "    padding: 0;\n" +
            "}\n" +
            ".CommonCategoryImage tr td {\n" +
            "    vertical-align: middle;\n" +
            "    /*border-bottom: solid 1px #e7e7e7; armando*/\n" +
            "}\n" +
            ".CommonCategoryImage a\n" +
            "{\n" +
            "    display: block;\n" +
            "    margin: auto;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".CommonCategoryImage img\n" +
            "{\n" +
            "    max-height: 90px;\n" +
            "    height: auto !important;\n" +
            "    height: auto;\n" +
            "    max-width: 90px;\n" +
            "    width: auto !important;\n" +
            "}\n" +
            ".CommonCategoryImagePanel\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    height: 90px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".CommonCategoryName\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 5px 0 10px;\n" +
            "    line-height: 18px;\n" +
            "    min-height: 36px;\n" +
            "    height: 36px;\n" +
            "    text-align: center;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".CommonCategoryNameLink\n" +
            "{\n" +
            "    color: #000;\n" +
            "    text-decoration: none;\n" +
            "    font-size: 13px;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".CommonCategoryDescription\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin-bottom: 10px;\n" +
            "    line-height: 18px;\n" +
            "    font-size: 11px;\n" +
            "    color: #777;\n" +
            "    display: none;\n" +
            "}\n" +
            "\n" +
            "/*-- Common Category List Item Style End --*/\n" +
            "/* -----------------------------------------\n" +
            "   Specific Styles\n" +
            "----------------------------------------- */\n" +
            "/*Layout->Header->header-container1 Begin*/\n" +
            "/*HeaderLogin Begin*/\n" +
            ".HeaderLogin\n" +
            "{\n" +
            "    color: #000;\n" +
            "    float: left;\n" +
            "    font-weight: normal;\n" +
            "    line-height: 16px;\n" +
            "    margin: 12px 0;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".HeaderLogin a {\n" +
            "    text-decoration: none;\n" +
            "    color: #000;\n" +
            "    border-bottom: solid 1px rgb(155, 10,222);\n" +
            "}\n" +
            ".HeaderLogin a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".HeaderLoginLoginName1\n" +
            "{\n" +
            "    padding: 0 2px;\n" +
            "    float: left;\n" +
            "}\n" +
            ".HeaderLoginLoginName2\n" +
            "{\n" +
            "    padding: 0 10px;\n" +
            "    float: left;\n" +
            "}\n" +
            ".HeaderLoginLoginName1Regis\n" +
            "{\n" +
            "    padding: 0 2px;\n" +
            "    float: left;\n" +
            "}\n" +
            ".HeaderLoginLoginName\n" +
            "{\n" +
            "    float: left;\n" +
            "}\n" +
            ".HeaderLogin .NameLabel\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    padding: 0 5px;\n" +
            "}\n" +
            "\n" +
            "/*HeaderLogin End*/\n" +
            "/*HeaderLogin - Wishlist and MyAccount Begin*/\n" +
            ".HeaderLoginWishlist, .HeaderLoginAccount\n" +
            "{\n" +
            "    float: right;\n" +
            "    margin: 0 0 0 20px;\n" +
            "}\n" +
            ".HeaderLoginWishlist a, .HeaderLoginAccount a\n" +
            "{\n" +
            "    color: #000;\n" +
            "    float: left;\n" +
            "    font-weight: normal;\n" +
            "    line-height: 16px;\n" +
            "    margin: 12px 0;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".HeaderLoginWishlist .WishlistLink\n" +
            "{\n" +
            "    background: url(Images/Icon/icon-wishlist.png) no-repeat left center;\n" +
            "    padding-left: 20px;\n" +
            "}\n" +
            ".HeaderLoginAccount .MyAccountLink\n" +
            "{\n" +
            "    background: url(Images/Icon/icon-user.png) no-repeat left center;\n" +
            "    padding-left: 20px;\n" +
            "}\n" +
            "/*HeaderLogin - Wishlist and MyAccount End*/\n" +
            "/*SwitchLanguage Begin*/\n" +
            ".SwitchLanguage\n" +
            "{\n" +
            "    font-size: 11px;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    float: right;\n" +
            "    margin-left: 15px;\n" +
            "    margin-top: 2px;\n" +
            "}\n" +
            ".SwitchLanguageTop, .SwitchLanguageBottom\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".SwitchLanguageRight .Label\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    margin-right: 5px;\n" +
            "    float: left;\n" +
            "    line-height: 40px;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".SwitchLanguageRight .LanguageSwitch\n" +
            "{\n" +
            "    float: left;\n" +
            "    padding: 2px 0;\n" +
            "    margin-top: 5px;\n" +
            "}\n" +
            ".SwitchLanguageMenuPanel\n" +
            "{\n" +
            "    padding: 0 5px 0 10px;\n" +
            "    float: left;\n" +
            "}\n" +
            ".SwitchLanguageMenuPanel a\n" +
            "{\n" +
            "    color: #999;\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            ".SwitchLanguageMenuPanel a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".SwitchLanguageDropPanel\n" +
            "{\n" +
            "    padding: 0;\n" +
            "    float: left;\n" +
            "}\n" +
            "/*SwitchLanguage End*/\n" +
            "/*CurrencyControl Begin*/\n" +
            ".CurrencyControl\n" +
            "{\n" +
            "    font-size: 11px;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    float: right;\n" +
            "    margin-left: 15px;\n" +
            "    margin-top: 2px;\n" +
            "}\n" +
            ".CurrencyControlTop, .CurrencyControlBottom\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".CurrencyControlRight .Label\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    margin-right: 5px;\n" +
            "    float: left;\n" +
            "    line-height: 40px;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".CurrencyControlRight .CurrencySwitch\n" +
            "{\n" +
            "    color: #999;\n" +
            "    float: left;\n" +
            "    padding: 2px 0;\n" +
            "    margin-top: 5px;\n" +
            "}\n" +
            "/*CurrencyControl End*/\n" +
            "\n" +
            "/*Layout->Header->header-container1 End*/\n" +
            "/*Layout->Header->header-container2 Begin*/\n" +
            "/*Search Begin*/\n" +
            ".Search\n" +
            "{\n" +
            "    width: 70%;\n" +
            "    margin: 20px 0 0;\n" +
            "    font-size: 11px;\n" +
            "    position: relative;\n" +
            "    clear: right;\n" +
            "    float: right;\n" +
            "}\n" +
            ".SearchTop\n" +
            "{\n" +
            "    line-height: 25px;\n" +
            "    float: left;\n" +
            "    width: 15%;\n" +
            "    font-size: 12px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".SearchBottom\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".SearchLeft\n" +
            "{\n" +
            "    float: right;\n" +
            "    width: 84%;\n" +
            "    border: solid 1px #f0f0f0;\n" +
            "    background-color: White;\n" +
            "}\n" +
            ".SearchRight .SearchAdvancedLink\n" +
            "{\n" +
            "    top: 8px;\n" +
            "    color: #454545;\n" +
            "    right: 3%;\n" +
            "    position: absolute;\n" +
            "    text-decoration: underline;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            "/*Search End*/\n" +
            "/*QuickSearch Begin*/\n" +
            ".QuickSearch\n" +
            "{\n" +
            "    display: block;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".QuickSearchDiv\n" +
            "{\n" +
            "    border: solid 1px #f0f0f0;\n" +
            "    float: right;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".QuickSearch input[type=\"text\"].QuickSearchText\n" +
            "{\n" +
            "    border: 0;\n" +
            "    padding: 0 0% 0 2%;\n" +
            "    width: 45%;\n" +
            "    color: #000;\n" +
            "    float: left;\n" +
            "    margin-bottom: 0;\n" +
            "}\n" +
            ".QuickSearch input[type=\"text\"].QuickSearchSelectedText\n" +
            "{\n" +
            "    border: 0;\n" +
            "    padding: 0 0% 0 2%;\n" +
            "    width: 38%;\n" +
            "    color: #000;\n" +
            "    float: left;\n" +
            "    margin-bottom: 0;\n" +
            "}\n" +
            ".QuickSearchLabel\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".QuickSearchLinkButton\n" +
            "{\n" +
            "    display: none;\n" +
            "    position: relative;\n" +
            "    left: 80px;\n" +
            "    bottom: 3px;\n" +
            "}\n" +
            "\n" +
            ".QuickSearchDropDownDiv\n" +
            "{\n" +
            "    float: left;\n" +
            "    border: 1px solid #FFFFFF;\n" +
            "    width: 15%;\n" +
            "    background: rgb(155, 10 ,222) url(Images/Icon/category-narrow-drop.png) no-repeat 85% center;\n" +
            "}\n" +
            "\n" +
            ".QuickSearchSelectedDropDownDiv\n" +
            "{\n" +
            "    float: left;\n" +
            "    border: 1px solid #FFFFFF;\n" +
            "    width: 30%;\n" +
            "    background: rgb(155, 10 ,222) url(Images/Icon/category-narrow-drop.png) no-repeat 95% center;\n" +
            "}\n" +
            "\n" +
            ".QuickSearchDropDown\n" +
            "{\n" +
            "    background: none;\n" +
            "    line-height: 1;\n" +
            "    border: 0;\n" +
            "    -webkit-appearance: none;\n" +
            "    -moz-appearance: none;\n" +
            "    float: left;\n" +
            "    vertical-align: middle;\n" +
            "    color: #fff;\n" +
            "    height: 23px;\n" +
            "    padding: 4px 0 4px 5px;\n" +
            "    overflow: hidden;\n" +
            "    font-size: 12px;\n" +
            "}\n" +
            ".QuickSearchDropDown option\n" +
            "{\n" +
            "    width: auto;\n" +
            "    background: rgb(155, 10 ,222);\n" +
            "    padding: 2px 10px;\n" +
            "}\n" +
            "/*QuickSearch End*/\n" +
            "/*HeaderLogo Begin*/\n" +
            ".HeaderLogo\n" +
            "{\n" +
            "    display: block;\n" +
            "    margin: 20px 0;\n" +
            "    float: left;\n" +
            "    clear: left;\n" +
            "}\n" +
            ".HeaderLogo a\n" +
            "{\n" +
            "    height: 80px;\n" +
            "}\n" +
            ".HeaderLogo img {\n" +
            "    /*max-height: 80px;Armando*/\n" +
            "    height: auto !important;\n" +
            "    height: 80px;\n" +
            "}\n" +
            "/*HeaderLogo End*/\n" +
            "/*Layout->Header->header-container2 End*/\n" +
            "\n" +
            "/*Layout->Header->header-container3 Begin*/\n" +
            "/*HeaderMenu -> HeaderMenuNormalStyle Begin*/\n" +
            ".HeaderMenu\n" +
            "{\n" +
            "    margin: 0;\n" +
            "    height: 42px;\n" +
            "    padding: 0;\n" +
            "    position: relative;\n" +
            "}\n" +
            ".HeaderMenu ul\n" +
            "{\n" +
            "    list-style: none;\n" +
            "    margin: 0px;\n" +
            "    padding: 0px;\n" +
            "    /*border-left: solid 1px white;/*rgb(87, 17, 119);armando*/\n" +
            "    /*border-right: solid 1px white;/*rgb(189, 0, 222);*/\n" +
            "    float: left;\n" +
            "}\n" +
            ".HeaderMenu ul li\n" +
            "{\n" +
            "    display: inline-block;\n" +
            "    border-left: solid 1px white;/*rgb(189, 0, 222);*/\n" +
            "    border-right: solid 1px white;/*rgb(87, 17, 119);*/\n" +
            "    border-bottom: solid 1px white;/*armando*/\n" +
            "}\n" +
            ".HeaderMenu ul li a.HyperLink\n" +
            "{\n" +
            "    padding: 2px 13px;\n" +
            "    height: 42px;\n" +
            "    line-height: 38px;\n" +
            "    color: #fff;\n" +
            "    text-align: center;\n" +
            "    text-transform: uppercase;\n" +
            "    font-size: 13px;\n" +
            "    vertical-align: middle;\n" +
            "    display: block;\n" +
            "    text-decoration: none;\n" +
            "    float: left;\n" +
            "}\n" +
            ".HeaderMenu ul li a.HyperLink:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    background: #EFF2F9;\n" +
            "}\n" +
            "/*HeaderMenu -> HeaderMenuNormalStyle End*/\n" +
            "/*HeaderMenu -> Product & Content [Top] Begin*/\n" +
            ".HeaderMenu .ContentMenuNavList a\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".HeaderMenu .ContentMenuNavList table\n" +
            "{\n" +
            "    border: 0;\n" +
            "}\n" +
            ".HeaderMenu .ContentMenuNavList table tr td\n" +
            "{\n" +
            "    padding: 0;\n" +
            "}\n" +
            ".HeaderMenu .ContentMenuNavMenuList td:hover\n" +
            "{\n" +
            "    background-color: Transparent;\n" +
            "}\n" +
            ".HeaderMenu .ContentMenuNavList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    border: 0 none;\n" +
            "    margin-top: 0px;\n" +
            "    display: block;\n" +
            "    float: left;\n" +
            "}\n" +
            ".HeaderMenu .ContentMenuNavList .SidebarTop, .HeaderMenu .ContentMenuNavList .SidebarBottom\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".HeaderMenu .ContentMenuNavList .SidebarRight\n" +
            "{\n" +
            "    padding: 0;\n" +
            "    border: 0;\n" +
            "    background: none;\n" +
            "}\n" +
            ".HeaderMenu table.ContentMenuNavListStaticMenuItem, .HeaderMenu table.ContentMenuNavMenuListStaticMenuStyle\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".HeaderMenu ul li a.ContentMenuNavListStaticMenuItem\n" +
            "{\n" +
            "    padding: 2px 13px;\n" +
            "    height: 42px;\n" +
            "    line-height: 38px;\n" +
            "    color: #fff;\n" +
            "    text-align: center;\n" +
            "    text-transform: uppercase;\n" +
            "    font-size: 13px !important;\n" +
            "    vertical-align: middle;\n" +
            "    display: block;\n" +
            "    text-decoration: none;\n" +
            "    float: left;\n" +
            "}\n" +
            ".HeaderMenu a.ContentMenuNavListStaticMenuItem:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    background-color: #EFF2F9;\n" +
            "}\n" +
            "\n" +
            ".HeaderMenu .ContentMenuNavMenuListDynamicMenuItem\n" +
            "{\n" +
            "    z-index: 0;\n" +
            "    background-color: #fff;\n" +
            "    border: 0;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".HeaderMenu .ContentMenuNavMenuListDynamicMenuItem a\n" +
            "{\n" +
            "    z-index: 0;\n" +
            "    display: block;\n" +
            "    vertical-align: middle;\n" +
            "    color: #000;\n" +
            "    background: none;\n" +
            "    padding: 6px 15px;\n" +
            "    width: 160px;\n" +
            "    white-space: normal;\n" +
            "    font-size: 12px !important;\n" +
            "}\n" +
            ".HeaderMenu .ContentMenuNavMenuListDynamicMenuItem:hover\n" +
            "{\n" +
            "    background-color: rgb(155, 10 ,222);\n" +
            "    color: #fff;\n" +
            "}\n" +
            ".HeaderMenu .ContentMenuNavMenuListDynamicMenuStyle\n" +
            "{\n" +
            "    z-index: 1001 !important;\n" +
            "    margin: 0;\n" +
            "    border: solid 1px #f0f0f0;\n" +
            "    border-top: 0;\n" +
            "    margin-left: -1px;\n" +
            "}\n" +
            "\n" +
            ".DynamicMenuFirstLevel\n" +
            "{\n" +
            "    top: 42px !important;\n" +
            "}\n" +
            ".HeaderMenu .ContentMenuNavMenuListDynamicMenuItem:hover img\n" +
            "{\n" +
            "    width: 0;\n" +
            "    height: 0;\n" +
            "    background: url(Images/Icon/arrow-left-hover.png) no-repeat center center;\n" +
            "    padding: 10px;\n" +
            "}\n" +
            "\n" +
            "/* HeaderMenu -> Product & Content [Top] End*/\n" +
            "/* HeaderMenu -> HeaderMenuCategoryRootStyle Begin*/\n" +
            "table.ContentMenuNavMenuList, table.ContentMenuNavMenuListStaticMenuStyle, table.ContentMenuNavListStaticMenuItem, .ContentMenuNavMenuListDynamicMenuStyle table, .ContentMenuNavMenuListDynamicMenuStyle table tr td\n" +
            "{\n" +
            "    border: 0;\n" +
            "    margin: 0;\n" +
            "    background-color: transparent;\n" +
            "    vertical-align: middle;\n" +
            "    width: inherit;\n" +
            "}\n" +
            "\n" +
            ".ContentMenuNavMenuListDynamicMenuStyle table\n" +
            "{\n" +
            "    border: 0;\n" +
            "    border-radius: 0;\n" +
            "}\n" +
            "/* HeaderMenu -> HeaderMenuCategoryRootStyle End*/\n" +
            "/* HeaderMenu -> HeaderMenuCategoryTabStyle Begin */\n" +
            ".CategoryNavTabMenu\n" +
            "{\n" +
            "    margin: 0;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".nav-container\n" +
            "{\n" +
            "    position: relative;\n" +
            "    z-index: 1500;\n" +
            "}\n" +
            ".nav-container table\n" +
            "{\n" +
            "    border: 0;\n" +
            "}\n" +
            ".nav-container ul\n" +
            "{\n" +
            "    padding: 0px;\n" +
            "    margin: 0px;\n" +
            "}\n" +
            ".nav-container ul.menu li\n" +
            "{\n" +
            "    float: left;\n" +
            "    display: inline;\n" +
            "    position: static !important;\n" +
            "    margin: 0;\n" +
            "}\n" +
            ".nav-container .menu li a.HyperLink\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    font-size: 13px;\n" +
            "    text-decoration: none;\n" +
            "    text-align: center;\n" +
            "    padding: 2px 22px 2px 13px;\n" +
            "    height: 42px;\n" +
            "    line-height: 38px;\n" +
            "    color: #fff;\n" +
            "    display: block;\n" +
            "    background: url(Images/Icon/category-narrow-drop.png) no-repeat 95% center;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".nav-container .menu li a.HyperLink img\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".nav-container .menu li a.HyperLink:hover\n" +
            "{\n" +
            "    position: relative;\n" +
            "    z-index: 999;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    background: #EFF2F9 url(Images/Icon/category-narrow-drop-hover.png)no-repeat 95% center;\n" +
            "}\n" +
            ".nav-container .menu li .HeaderMenuNavItemLeft, .nav-container .menu li .HeaderMenuNavItemRight\n" +
            "{\n" +
            "    float: left;\n" +
            "}\n" +
            ".nav-container ul.menu li .CategoryPanel\n" +
            "{\n" +
            "    float: left;\n" +
            "    position: absolute;\n" +
            "    left: 0;\n" +
            "    top: 22px;\n" +
            "    display: none;\n" +
            "}\n" +
            ".nav-container ul.menu li a.HyperLink:hover .CategoryPanel\n" +
            "{\n" +
            "    display: block;\n" +
            "    z-index: 998;\n" +
            "    margin-top: 20px;\n" +
            "    background-color: #EFF2F9;\n" +
            "    text-transform: none;\n" +
            "    padding: 10px;\n" +
            "    width: auto;\n" +
            "}\n" +
            ".SubCategoryDataList\n" +
            "{\n" +
            "}\n" +
            ".SubCategoryDataList td\n" +
            "{\n" +
            "    vertical-align: top;\n" +
            "    background-color: #fff;\n" +
            "}\n" +
            ".SubCategoryDataList .SubParentLinkDiv\n" +
            "{\n" +
            "    text-align: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    padding-bottom: 5px;\n" +
            "    border-bottom: solid 1px rgb(155, 10 ,222);\n" +
            "    margin-bottom: 5px;\n" +
            "}\n" +
            ".SubCategoryDataList .SubParentLink\n" +
            "{\n" +
            "    font-weight: bold;\n" +
            "    color: #000;\n" +
            "    font-size: 11px;\n" +
            "    text-decoration: none;\n" +
            "    line-height: 24px !important;\n" +
            "    white-space: -moz-pre-wrap !important; /* Mozilla, since 1999 */\n" +
            "    white-space: -pre-wrap; /* Opera 4-6 */\n" +
            "    white-space: -o-pre-wrap; /* Opera 7 */\n" +
            "    white-space: pre-wrap; /* css-3 */\n" +
            "    word-wrap: break-word; /* Internet Explorer 5.5+ */\n" +
            "}\n" +
            ".LeafSubCategoryDataList td\n" +
            "{\n" +
            "    vertical-align: top;\n" +
            "}\n" +
            ".LeafSubCategoryDataList .SubParentLinkDiv\n" +
            "{\n" +
            "    text-align: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    background-color: #fff;\n" +
            "}\n" +
            ".LeafSubCategoryDataList .SubParentLink\n" +
            "{\n" +
            "    color: #000;\n" +
            "    text-decoration: none;\n" +
            "    line-height: 22px !important;\n" +
            "    font-weight: normal;\n" +
            "    display: block;\n" +
            "    padding: 4px 0px 4px 16px;\n" +
            "    white-space: normal;\n" +
            "    background: url(images/bullet/bullet3.gif) no-repeat 4px 10px;\n" +
            "    font-size: 12px;\n" +
            "}\n" +
            ".SubCategoryListStyle\n" +
            "{\n" +
            "    height: 100%;\n" +
            "    width: 160px;\n" +
            "}\n" +
            ".SubParentLink:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    text-decoration: underline;\n" +
            "}\n" +
            ".SubCategoryPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "}\n" +
            ".SubCategoryName\n" +
            "{\n" +
            "    float: left;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".LeafCategoryLink\n" +
            "{\n" +
            "    background: url(images/bullet/bullet3.gif) no-repeat 0 6px;\n" +
            "    padding: 2px 0px 2px 12px;\n" +
            "    width: 100%;\n" +
            "    vertical-align: middle;\n" +
            "    display: block;\n" +
            "    color: #000;\n" +
            "    text-decoration: none;\n" +
            "    white-space: normal;\n" +
            "    text-align: left;\n" +
            "    line-height: 20px !important;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".LeafCategoryLink:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    text-decoration: underline;\n" +
            "}\n" +
            ".ViewMorePanel\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-top: 5px;\n" +
            "}\n" +
            ".ViewMorePanel a\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    color: #999;\n" +
            "    text-decoration: none;\n" +
            "    line-height: normal;\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            ".ViewMorePanel a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    text-decoration: underline;\n" +
            "}\n" +
            ".SubCategoryDataList .SubCategoryItemData\n" +
            "{\n" +
            "    padding: 10px;\n" +
            "    background-color: #fff;\n" +
            "    width: 165px;\n" +
            "    min-height: 150px;\n" +
            "}\n" +
            ".LeafSubCategoryDataList .SubCategoryItemData\n" +
            "{\n" +
            "    padding-bottom: 0px;\n" +
            "}\n" +
            "/* HeaderMenu -> HeaderMenuCategoryTabStyle End */\n" +
            "/*Layout->Header->header-container3 End*/\n" +
            "\n" +
            "/*Layout->Header->header-container4 Begin*/\n" +
            "/* CurrentShoppingCart Begin */\n" +
            ".HeaderShoppingCart\n" +
            "{\n" +
            "    clear: right;\n" +
            "    float: right;\n" +
            "    line-height: 30px;\n" +
            "    margin-top: 20px;\n" +
            "    font-size: 12px;\n" +
            "}\n" +
            ".HeaderShoppingCartViewCart\n" +
            "{\n" +
            "    float: left;\n" +
            "    text-decoration: none;\n" +
            "    color: #454545;\n" +
            "    margin-left: 5px;\n" +
            "    background: url(Images/Icon/icon-cart.png) no-repeat right 1px;\n" +
            "    font-size: 0;\n" +
            "    border: 0;\n" +
            "    width: 20px;\n" +
            "    height: 28px;\n" +
            "}\n" +
            ".HeaderShoppingCartViewCart:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".HeaderShoppingCartDiv\n" +
            "{\n" +
            "    float: left;\n" +
            "    background-color: #f9fafb;\n" +
            "    line-height: 25px;\n" +
            "    height: 28px;\n" +
            "    padding: 0 10px;\n" +
            "    border: solid 1px #f0f0f0;\n" +
            "}\n" +
            ".QuantityDiv\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-left: 5px;\n" +
            "}\n" +
            ".QuantityValue\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".DiscountDiv\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-left: 5px;\n" +
            "}\n" +
            ".DiscountValue\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".AmountDiv\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin: 0 5px;\n" +
            "}\n" +
            ".AmountValue\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".HeaderShoppingCartCheckout\n" +
            "{\n" +
            "    float: left;\n" +
            "    background: #f9fafb url(Images/Icon/icon-checkout.png) no-repeat 95% 2px;\n" +
            "    line-height: 27px;\n" +
            "    height: 28px;\n" +
            "    padding: 0 30px 0 10px;\n" +
            "    border: solid 1px #f0f0f0;\n" +
            "    margin-left: 20px;\n" +
            "    color: #454545;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".HeaderShoppingCartBraclet\n" +
            "{\n" +
            "    float: left;\n" +
            "}\n" +
            "/*Layout->Header->header-container4 End*/\n" +
            "/* -----------------------------------------\n" +
            "   Default Section\n" +
            "----------------------------------------- */\n" +
            "/* StoreBanner Begin*/\n" +
            ".StoreBanner\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    padding-bottom: 40px;\n" +
            "    display: inline-block;\n" +
            "}\n" +
            ".StoreBanner .camera_caption > div > span\n" +
            "{\n" +
            "    font-size: 18px;\n" +
            "}\n" +
            ".StoreBanner .camera_wrap .camera_fakehover .camera_pag .camera_pag_ul li.cameracurrent > span\n" +
            "{\n" +
            "}\n" +
            ".StoreBanner .camera_wrap .camera_fakehover .camera_pag\n" +
            "{\n" +
            "    bottom: -35px;\n" +
            "}\n" +
            ".StoreBanner .camera_wrap .camera_fakehover .camera_pag .camera_pag_ul\n" +
            "{\n" +
            "    text-align: left;\n" +
            "}\n" +
            ".StoreBanner .camera_wrap .camera_fakehover .camera_pag .camera_pag_ul li\n" +
            "{\n" +
            "    background-color: #2a353c;\n" +
            "    width: 10px;\n" +
            "    height: 10px;\n" +
            "}\n" +
            ".StoreBanner .camera_wrap .camera_fakehover .camera_pag .camera_pag_ul li > span, .StoreBanner .camera_wrap .camera_fakehover .camera_pag .camera_pag_ul li.cameracurrent > span\n" +
            "{\n" +
            "    background: none;\n" +
            "    left: 0;\n" +
            "    top: 0;\n" +
            "    width: 10px;\n" +
            "    height: 10px;\n" +
            "}\n" +
            ".StoreBanner .camera_wrap .camera_fakehover .camera_pag .camera_pag_ul li.cameracurrent\n" +
            "{\n" +
            "    background-color: rgb(155, 10 ,222);\n" +
            "}\n" +
            "/*StoreBanner End*/\n" +
            "/*ProductSpecial Begin*/\n" +
            ".ProductSpecial .SidebarTop, .ProductSpecial .SidebarBottom\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".ProductSpecial .SidebarRight\n" +
            "{\n" +
            "    padding: 0;\n" +
            "    border: solid 1px #ddd;\n" +
            "    background-color: #fff;\n" +
            "}\n" +
            ".ProductSpecialLabelPanel\n" +
            "{\n" +
            "    width: 60px;\n" +
            "    height: 60px;\n" +
            "    background: url(Images/Icon/icon-special.png) no-repeat left top;\n" +
            "    position: absolute;\n" +
            "    z-index: 10;\n" +
            "}\n" +
            ".ProductSpecial .ProductSpecialImage\n" +
            "{\n" +
            "    margin: auto;\n" +
            "}\n" +
            "\n" +
            ".ProductSpecial .ProductSpecialImage a\n" +
            "{\n" +
            "    height: 260px;\n" +
            "    width: 170px;\n" +
            "}\n" +
            "\n" +
            ".ProductSpecial .ProductSpecialImage a img\n" +
            "{\n" +
            "    margin-top: 5px;\n" +
            "    display: block;\n" +
            "    max-width: 170px;\n" +
            "    width: auto !important;\n" +
            "    width: 170px;\n" +
            "}\n" +
            "\n" +
            "/*ProductSpecial End*/\n" +
            "/*NewsEvent Begin*/\n" +
            ".NewsEvent .CenterBlockTop\n" +
            "{\n" +
            "    position: relative;\n" +
            "}\n" +
            ".NewsEventList\n" +
            "{\n" +
            "    width: 103%;\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            ".NewsEventItemStyle\n" +
            "{\n" +
            "    width: 30.875%;\n" +
            "    margin: 20px 2% 10px 0;\n" +
            "    display: inline-block;\n" +
            "    color: #2a353c;\n" +
            "    vertical-align: top;\n" +
            "}\n" +
            ".NewsEventContent\n" +
            "{\n" +
            "    border: solid 1px #ddd;\n" +
            "    padding: 5px 5px 35px;\n" +
            "    position: relative;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".NewsEventImage\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    margin-bottom: 10px;\n" +
            "    min-height: 120px;\n" +
            "    max-height: 120px;\n" +
            "}\n" +
            ".NewsDate\n" +
            "{\n" +
            "    position: absolute;\n" +
            "    bottom: 10px;\n" +
            "    right: 10px;\n" +
            "    width: 30%;\n" +
            "    text-align: right;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".NewsTopic\n" +
            "{\n" +
            "    position: absolute;\n" +
            "    bottom: 10px;\n" +
            "    left: 10px;\n" +
            "    width: 65%;\n" +
            "    font-size: 11px;\n" +
            "    text-transform: uppercase;\n" +
            "    font-weight: bold;\n" +
            "    text-align: left;\n" +
            "}\n" +
            ".NewsEventContent a\n" +
            "{\n" +
            "    color: #2a353c;\n" +
            "}\n" +
            ".NewsEventContent a img\n" +
            "{\n" +
            "    max-height: 120px;\n" +
            "}\n" +
            ".NewsDescription\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    margin: 20px 0;\n" +
            "    line-height: 20px;\n" +
            "    font-size: 12px;\n" +
            "    height: 40px;\n" +
            "    overflow: hidden;\n" +
            "}\n" +
            ".NewsEventMore\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: right;\n" +
            "    text-align: right;\n" +
            "    background: url(Images/Bullet/more.gif) no-repeat right center;\n" +
            "    line-height: 20px;\n" +
            "}\n" +
            ".NewsEventMoreLink\n" +
            "{\n" +
            "    padding-right: 20px;\n" +
            "    line-height: 20px;\n" +
            "    color: #2a353c;\n" +
            "    text-decoration: underline;\n" +
            "    font-size: 80%;\n" +
            "}\n" +
            ".NewsEventViewAll\n" +
            "{\n" +
            "    position: absolute;\n" +
            "    right: 0;\n" +
            "    top: 0;\n" +
            "}\n" +
            "\n" +
            ".common-rightside-col .NewsEventMore\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    height: 30px;\n" +
            "    margin-top: 5px;\n" +
            "    background: url(Images/Background/dot-line.jpg) repeat-x left top;\n" +
            "    width: 100%;\n" +
            "    padding-top: 8px;\n" +
            "    text-align: right;\n" +
            "}\n" +
            ".common-rightside-col .NewsEventMore a\n" +
            "{\n" +
            "    background: url(Images/Bullet/more.gif) no-repeat right center;\n" +
            "    font-size: 11px;\n" +
            "    line-height: 18px;\n" +
            "    margin: 0;\n" +
            "    padding: 0;\n" +
            "    padding-right: 22px;\n" +
            "    vertical-align: middle;\n" +
            "    text-decoration: none;\n" +
            "    width: auto;\n" +
            "    float: right;\n" +
            "}\n" +
            ".common-rightside-col .NewsEventMore a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            "/*NewsEvent End*/\n" +
            "/*[Category, Deparment, Manufacturer] NavNormalList Style Begin*/\n" +
            ".CategoryNavNormalList, .DepartmentNavNormalList, .ManufacturerNavNormalList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".CategoryNavNormalList a, .DepartmentNavNormalList a, .ManufacturerNavNormalList a\n" +
            "{\n" +
            "    padding: 8px 0px 8px 8%;\n" +
            "    width: 100%;\n" +
            "    vertical-align: middle;\n" +
            "    display: block;\n" +
            "    color: #000;\n" +
            "    text-decoration: none;\n" +
            "    white-space: normal;\n" +
            "    text-align: left;\n" +
            "    font-size: 13px;\n" +
            "    background: url(images/bullet/bullet3.gif) no-repeat 0 11px;\n" +
            "}\n" +
            "\n" +
            ".CategoryNavNormalList a:hover, .DepartmentNavNormalList a:hover, .ManufacturerNavNormalList a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            "/*[Category, Deparment, Manufacturer] NavNormalList Style End*/\n" +
            "/*[Category, Deparment] NavMenuList Style Begin*/\n" +
            ".CategoryNavMenuList, .DepartmentNavMenuList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".CategoryNavMenuListStaticMenuItem td a, .DepartmentNavMenuListStaticMenuItem td a\n" +
            "{\n" +
            "    padding: 3px 0px;\n" +
            "    width: inherit;\n" +
            "    vertical-align: middle;\n" +
            "    display: block;\n" +
            "    color: #000;\n" +
            "    text-decoration: none;\n" +
            "    white-space: normal;\n" +
            "    font-size: 13px !important;\n" +
            "}\n" +
            "\n" +
            ".CategoryNavMenuListStaticMenuItem:hover, .DepartmentNavMenuListStaticMenuItem:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".CategoryNavMenuListDynamicMenuItem, .DepartmentNavMenuListDynamicMenuItem\n" +
            "{\n" +
            "    z-index: 0;\n" +
            "}\n" +
            "table.CategoryNavMenuListDynamicMenuItem tr td, table.DepartmentNavMenuListDynamicMenuItem tr td\n" +
            "{\n" +
            "}\n" +
            ".CategoryNavMenuListDynamicMenuItem a, .DepartmentNavMenuListDynamicMenuItem a\n" +
            "{\n" +
            "    z-index: 0;\n" +
            "    display: block;\n" +
            "    vertical-align: middle;\n" +
            "    color: #000;\n" +
            "    background: none;\n" +
            "    padding: 4px 15px;\n" +
            "    width: 160px;\n" +
            "    white-space: normal;\n" +
            "    font-size: 13px !important;\n" +
            "}\n" +
            ".CategoryNavMenuListDynamicMenuItem:hover, .DepartmentNavMenuListDynamicMenuItem:hover\n" +
            "{\n" +
            "    background-color: #f2f2f2;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".CategoryNavMenuListDynamicMenuStyle, .DepartmentNavMenuListDynamicMenuStyle\n" +
            "{\n" +
            "    z-index: 100 !important;\n" +
            "    margin: 0;\n" +
            "    border: solid 1px #ddd;\n" +
            "}\n" +
            ".CategoryNavMenuListStaticMenuItem img, .CategoryNavMenuListDynamicMenuItem img, .DepartmentNavMenuListStaticMenuItem img, .DepartmentNavMenuListDynamicMenuItem img\n" +
            "{\n" +
            "    width: 0;\n" +
            "    height: 0;\n" +
            "    background: url(Images/Icon/arrow-left.png) no-repeat center center;\n" +
            "    padding: 10px;\n" +
            "}\n" +
            "\n" +
            "/*[Category, Deparment] NavMenuList Style End*/\n" +
            "/*[Category, Deparment] NavTreeList Style Begin*/\n" +
            ".CategoryNavTreeList, .DepartmentNavTreeList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".CategoryNavTreeListSelectedNode, .DepartmentNavTreeListSelectedNode\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".CategoryNavTreeListNode, .DepartmentNavTreeListNode\n" +
            "{\n" +
            "    padding: 4px 0;\n" +
            "    white-space: normal !important;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".CategoryNavTreeList a, .DepartmentNavTreeList a\n" +
            "{\n" +
            "    color: #000;\n" +
            "}\n" +
            ".CategoryNavTreeList a:hover, .DepartmentNavTreeList a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            "\n" +
            "/*[Category, Deparment] NavTreeList End*/\n" +
            "/* -----------------------------------------\n" +
            "     Default Center Content\n" +
            "----------------------------------------- */\n" +
            "/* Quick View Start */\n" +
            ".ModalBackground\n" +
            "{\n" +
            "    background-color: #fff;\n" +
            "    filter: alpha(opacity=80);\n" +
            "    opacity: 0.8;\n" +
            "    z-index: 9;\n" +
            "}\n" +
            ".QuickViewButtonBorder {\n" +
            "    text-align: center;\n" +
            "    position: absolute;\n" +
            "    /*display: none; Armando*/\n" +
            "}\n" +
            ".QuickViewButtonPanel {\n" +
            "    margin: 0 auto;\n" +
            "    text-align: center;\n" +
            "}\n" +
            "a.QuickViewButton {\n" +
            "    background: rgb(155, 10,222) url(Images/Background/quickview.gif) no-repeat 8% center;\n" +
            "    display: none;\n" +
            "    width: 60%;\n" +
            "    font-size: 11px;\n" +
            "    height: 30px;\n" +
            "    position: absolute;\n" +
            "    left: 20%;\n" +
            "    right: 20%;\n" +
            "    padding: 5px 3% 4px 7%;\n" +
            "    cursor: pointer;\n" +
            "    top: 40%;\n" +
            "    text-transform: uppercase;\n" +
            "    z-index: 1;\n" +
            "    line-height: 22px;\n" +
            "    color: #ffffff;\n" +
            "}\n" +
            ".NewArrival a.QuickViewButton\n" +
            "{\n" +
            "    background: rgb(155, 10 ,222) url(Images/Background/quickview.gif) no-repeat 8% center;\n" +
            "    display: none;\n" +
            "    width: 60%;\n" +
            "    font-size: 11px;\n" +
            "    height: 30px;\n" +
            "    position: absolute;\n" +
            "    left: 20%;\n" +
            "    right: 20%;\n" +
            "    padding: 5px 3% 4px 7%;\n" +
            "    cursor: pointer;\n" +
            "    text-transform: uppercase;\n" +
            "    z-index: 1;\n" +
            "    line-height: 22px;\n" +
            "    color: #ffffff;\n" +
            "}\n" +
            ".NewArrivalCategoryItem a.QuickViewButton\n" +
            "{\n" +
            "    background: rgb(155, 10 ,222) url(Images/Background/quickview.gif) no-repeat 8% center;\n" +
            "    display: none;\n" +
            "    width: 60%;\n" +
            "    font-size: 11px;\n" +
            "    height: 30px;\n" +
            "    position: absolute;\n" +
            "    left: 20%;\n" +
            "    right: 20%;\n" +
            "    padding: 5px 3% 4px 7%;\n" +
            "    cursor: pointer;\n" +
            "    text-transform: uppercase;\n" +
            "    z-index: 1;\n" +
            "    line-height: 22px;\n" +
            "    color: #ffffff;\n" +
            "}\n" +
            "a.QuickViewButton:hover\n" +
            "{\n" +
            "    background: #2a353c url(Images/Background/quickview-hover.gif) no-repeat 7% center;\n" +
            "}\n" +
            ".QuickView\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    position: fixed;\n" +
            "    z-index: 10;\n" +
            "    width: 100%;\n" +
            "    height: 100%;\n" +
            "    left: 0px;\n" +
            "    top: 0px;\n" +
            "    filter: alpha(opacity=80); /* for IE */\n" +
            "    opacity: 0.8; /* CSS3 standard */\n" +
            "    background-color: #fff;\n" +
            "}\n" +
            ".QuickViewPanel\n" +
            "{\n" +
            "    width: 800px;\n" +
            "    height: 400px;\n" +
            "    text-align: left;\n" +
            "    background-color: #fff;\n" +
            "    border: solid 1px #fff;\n" +
            "    border-top: 0;\n" +
            "    -webkit-box-shadow: 0px 0px 10px 0px #555;\n" +
            "    box-shadow: 0px 0px 10px 0px #555;\n" +
            "    position: fixed;\n" +
            "    top: 50%;\n" +
            "    left: 50%;\n" +
            "    z-index: 11;\n" +
            "    margin: -200px 0 0 -400px;\n" +
            "    border-collapse: separate;\n" +
            "}\n" +
            ".QuickViewPanel .ProductDetailsDefaultImageThumbnailDataList td, .QuickViewPanel .OptionGroupDetailsDatalist td, .QuickViewPanel .ProductDetail td\n" +
            "{\n" +
            "    border-bottom: 0px solid #BBBBBB;\n" +
            "    border-left: 0px solid #BBBBBB;\n" +
            "    padding-top: 5px;\n" +
            "    vertical-align: top;\n" +
            "}\n" +
            ".QuickViewPanel .ProductDetail .CommonValidateDiv\n" +
            "{\n" +
            "    width: 45px;\n" +
            "    margin-top: 3px;\n" +
            "}\n" +
            ".QuickViewPanel .QuantityDiscountLinkImage\n" +
            "{\n" +
            "    max-width: 150px;\n" +
            "}\n" +
            ".QuickViewPanel .Header\n" +
            "{\n" +
            "    height: 50px;\n" +
            "    display: block;\n" +
            "    width: 100%;\n" +
            "    background-image: url(\"Images/Background/BackgroundBottom.jpg\");\n" +
            "    background-repeat: repeat;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".QuickViewPanel .Header .Title\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 700px;\n" +
            "    height: 50px;\n" +
            "    padding-left: 50px;\n" +
            "}\n" +
            ".QuickViewPanel .Title\n" +
            "{\n" +
            "    font-size: 18px;\n" +
            "    height: 29px;\n" +
            "    line-height: 21px;\n" +
            "    margin-bottom: 5px;\n" +
            "}\n" +
            ".QuickViewPanel .Body\n" +
            "{\n" +
            "    height: 400px;\n" +
            "    display: block;\n" +
            "    width: 100%;\n" +
            "    background: #FFF;\n" +
            "    width: 800px;\n" +
            "}\n" +
            ".QuickViewPanel .Body .ProductImage\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 40%;\n" +
            "    overflow: auto;\n" +
            "    height: 370px;\n" +
            "    padding: 15px;\n" +
            "}\n" +
            ".QuickViewPanel .Body .ProductImage .MainImage\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    max-height: 250px;\n" +
            "    height: auto;\n" +
            "    text-align: center;\n" +
            "    margin: auto;\n" +
            "}\n" +
            ".QuickViewPanel .Body .ProductImage .MainImage img\n" +
            "{\n" +
            "    max-height: 250px;\n" +
            "    max-width: 275px;\n" +
            "}\n" +
            ".QuickViewPanel .Body .ProductDetail\n" +
            "{\n" +
            "    background: url(Images/Background/dot-line-ver.jpg) repeat-y;\n" +
            "    float: left;\n" +
            "    height: 355px;\n" +
            "    padding: 35px 20px 10px;\n" +
            "    width: 60%;\n" +
            "}\n" +
            ".QuickViewPanel .DetailOverflowPosition\n" +
            "{\n" +
            "    height: 250px;\n" +
            "    overflow: auto;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".QuickViewPanel .Body .ProductDetail .ProductDetailsDefaultQuantityDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "    padding-bottom: 10px;\n" +
            "    width: 100%;\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            ".QuickViewPanel .Body .ProductDetail .OptionRadioItemRadioButtonList label img.OptionImg\n" +
            "{\n" +
            "    border: 1px solid #D2D1D1;\n" +
            "}\n" +
            ".QuickViewPanel .QuantityDiscountPanel, .QuickViewPanel .ProductDetailsDefaultOptionDiv, .QuickViewPanel .ProductDetailsDefaultDescriptionDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "}\n" +
            ".QuickViewPanel .QuantityDiscountPanel a\n" +
            "{\n" +
            "    display: inline;\n" +
            "    text-align: left;\n" +
            "    margin: 0;\n" +
            "}\n" +
            ".QuickViewPanel .QuantityDiscountGridViewHeaderStyle\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".QuickViewPanel .close\n" +
            "{\n" +
            "    background-color: #333;\n" +
            "    border: 2px solid #000;\n" +
            "    border-radius: 15px;\n" +
            "    color: #FFFFFF;\n" +
            "    font-weight: bolder;\n" +
            "    height: 30px;\n" +
            "    padding: 2px 5px 5px 5px;\n" +
            "    position: absolute;\n" +
            "    right: -13px;\n" +
            "    text-align: center;\n" +
            "    text-decoration: none;\n" +
            "    top: -15px;\n" +
            "    width: 30px;\n" +
            "}\n" +
            ".QuickViewPanel .close:hover\n" +
            "{\n" +
            "    color: #f00;\n" +
            "}\n" +
            ".QuickViewPanel .ProductDetailsDefaultMessageDiv\n" +
            "{\n" +
            "    position: absolute;\n" +
            "    top: 0px;\n" +
            "    left: 348px;\n" +
            "}\n" +
            ".ProductDetailsDefaultMessageDiv .CommonErrorMessageDiv\n" +
            "{\n" +
            "    padding: 8px 10px 7px 23px;\n" +
            "    width: 380px;\n" +
            "}\n" +
            ".QuickViewPanel .CommonInfo, .QuickViewPanel .GiftCertificateDetailsPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 390px;\n" +
            "    margin: 5px 0;\n" +
            "}\n" +
            ".QuickViewPanel .CommonLabel, .QuickViewPanel .GiftCertificateDetailsTitle\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 25%;\n" +
            "    padding: 3px 0;\n" +
            "    font-weight: normal;\n" +
            "    color: #000;\n" +
            "    margin-right: 2%;\n" +
            "}\n" +
            ".QuickViewPanel .CommonValue\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 70%;\n" +
            "    font-size: 10px;\n" +
            "    padding: 3px 0;\n" +
            "}\n" +
            ".QuickViewPanel .CommonValue input\n" +
            "{\n" +
            "    width: 20%;\n" +
            "}\n" +
            ".QuickViewPanel .PriceValue\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 70%;\n" +
            "    font-size: 18px;\n" +
            "    font-weight: normal;\n" +
            "    color: #ff7200;\n" +
            "}\n" +
            ".QuickViewPanel .InfoRetailPrice\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 70%;\n" +
            "    margin: -3px 0 5px 27%;\n" +
            "}\n" +
            ".QuickViewPanel .RetailPriceValue\n" +
            "{\n" +
            "    float: left;\n" +
            "    color: #66767b;\n" +
            "    font-size: 12px;\n" +
            "    text-decoration: line-through;\n" +
            "    margin-right: 10px;\n" +
            "}\n" +
            ".QuickViewPanel .StockValue\n" +
            "{\n" +
            "    font-size: 12px;\n" +
            "}\n" +
            ".QuickViewPanel .ProductDescriptionValue\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    font-size: 11px;\n" +
            "    margin: 5px 0;\n" +
            "    font-size: 12px;\n" +
            "}\n" +
            ".QuickViewPanel .GiftCertificateDetailsLeft\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    font-size: 11px;\n" +
            "    margin: 5px 0;\n" +
            "}\n" +
            ".QuickViewAddCartButton\n" +
            "{\n" +
            "    display: table;\n" +
            "    width: 100%;\n" +
            "    padding: 5px 0;\n" +
            "}\n" +
            ".QuickViewPanel .AddCartButton\n" +
            "{\n" +
            "    float: right;\n" +
            "    width: 40%;\n" +
            "}\n" +
            ".QuickViewPanel a.AddCart\n" +
            "{\n" +
            "    font-size: 16px;\n" +
            "    padding: 3px 0;\n" +
            "    width: 100%;\n" +
            "    background-color: #ff7200;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".QuickViewPanel a.AddCart:hover\n" +
            "{\n" +
            "    color: #fff;\n" +
            "    background-color: #000;\n" +
            "}\n" +
            ".ViewDetailButton\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "}\n" +
            ".QuickViewPanel a.ViewDetail\n" +
            "{\n" +
            "    padding: 3px 5px;\n" +
            "    background-color: rgb(155, 10 ,222);\n" +
            "    color: #FFF;\n" +
            "}\n" +
            ".QuickViewPanel a.ViewDetail:hover\n" +
            "{\n" +
            "    background-color: #000;\n" +
            "}\n" +
            ".QuickViewPanel .ImageZoomingButtonPopupMessage\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".QuickViewPanel .ImagePanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: right;\n" +
            "    margin-top: 20px;\n" +
            "}\n" +
            ".QuickViewPanel .ThumbnailIamge\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-top: 20px;\n" +
            "}\n" +
            ".QuickViewPanel .OptionGroupDetailsTitleRight\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 28%;\n" +
            "    border-bottom: dotted 1px #ccc;\n" +
            "    padding: 3px 0;\n" +
            "    font-weight: normal;\n" +
            "    color: #000;\n" +
            "    margin-right: 2%;\n" +
            "}\n" +
            ".QuickViewPanel .OptionGroupDetailsTitleRight span\n" +
            "{\n" +
            "    font-size: 10px;\n" +
            "    color: #000;\n" +
            "    border: 0;\n" +
            "}\n" +
            ".QuickViewPanel .OptionGroupDetailsDatalist\n" +
            "{\n" +
            "    clear: left;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".QuickViewPanel .SpecItemName\n" +
            "{\n" +
            "    line-height: 18px;\n" +
            "}\n" +
            ".QuickViewPanel .ProductSpecificationItemList\n" +
            "{\n" +
            "    width: 390px;\n" +
            "}\n" +
            ".QuickViewPanel .ProductSpecificationItemList .SpecItemName\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 30%;\n" +
            "    padding: 5px;\n" +
            "    border-bottom: dashed 1px #e1e1e1;\n" +
            "    color: #555;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".QuickViewPanel .ProductSpecificationItemList .SpecItemValue\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 60%;\n" +
            "    padding: 10px 5px 5px 5px;\n" +
            "    color: #555;\n" +
            "    border-bottom: dashed 1px #e1e1e1;\n" +
            "}\n" +
            "\n" +
            "/* Quick View End */\n" +
            "/* AddToCart Notification Begin */\n" +
            ".AddToCartPanel\n" +
            "{\n" +
            "    width: 520px;\n" +
            "    text-align: left;\n" +
            "    background-color: #fff;\n" +
            "    border-top: 0;\n" +
            "    -webkit-box-shadow: 0px 0px 10px 0px #555;\n" +
            "    box-shadow: 0px 0px 10px 0px #555;\n" +
            "    padding: 15px;\n" +
            "    border-collapse: separate;\n" +
            "    z-index: 11;\n" +
            "}\n" +
            ".AddToCartPanel a.close\n" +
            "{\n" +
            "    background-color: #ccc;\n" +
            "    border: 1px solid #aaa;\n" +
            "    color: #FFFFFF;\n" +
            "    font-size: 16px;\n" +
            "    height: 30px;\n" +
            "    padding: 5px;\n" +
            "    position: absolute;\n" +
            "    right: 0;\n" +
            "    text-align: center;\n" +
            "    text-decoration: none;\n" +
            "    top: 0;\n" +
            "    width: 30px;\n" +
            "}\n" +
            ".AddToCartPanel .close:hover\n" +
            "{\n" +
            "    color: #f00;\n" +
            "}\n" +
            ".AddToCartCheckoutLink\n" +
            "{\n" +
            "    float: right;\n" +
            "}\n" +
            ".AddToCartName\n" +
            "{\n" +
            "    text-align: left;\n" +
            "    float: left;\n" +
            "    width: 50%;\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            ".AddToCartBottom\n" +
            "{\n" +
            "    display: table;\n" +
            "    width: 100%;\n" +
            "    padding: 10px 0 0;\n" +
            "}\n" +
            ".AddToCartDetail\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    padding: 15px 3%;\n" +
            "    border-top: 1px dashed #ddd;\n" +
            "    border-bottom: 1px dashed #ddd;\n" +
            "}\n" +
            ".AddToCartTitle\n" +
            "{\n" +
            "    color: #000;\n" +
            "    font-weight: normal;\n" +
            "    font-size: 16px;\n" +
            "    line-height: 30px;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    padding: 5px 0 10px;\n" +
            "}\n" +
            ".AddToCartNameLink\n" +
            "{\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            ".AddToCartNameLink .ProductName\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin-bottom: 8px;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    font-size: 14px;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".AddToCartNameLink .OptionName\n" +
            "{\n" +
            "    clear: left;\n" +
            "    font-size: 11px;\n" +
            "    color: #555;\n" +
            "    text-align: left;\n" +
            "}\n" +
            ".AddToCartImage\n" +
            "{\n" +
            "    float: left;\n" +
            "    text-align: left;\n" +
            "    width: 18%;\n" +
            "}\n" +
            ".AddToCartImage img\n" +
            "{\n" +
            "    max-width: 60px;\n" +
            "    width: auto !important;\n" +
            "    width: 60px;\n" +
            "}\n" +
            ".AddToCartPrice\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 29%;\n" +
            "    margin-left: 3%;\n" +
            "}\n" +
            ".AddToCartPanel .CommonLabel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 45%;\n" +
            "    border-bottom: dotted 1px #ccc;\n" +
            "    padding: 3px 0;\n" +
            "    color: #555;\n" +
            "    margin-right: 2%;\n" +
            "    margin-bottom: 8px;\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            ".AddToCartPanel .CommonValue\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 50%;\n" +
            "    font-size: 13px;\n" +
            "    color: #555;\n" +
            "    padding: 3px 0;\n" +
            "    font-weight: normal;\n" +
            "    margin-bottom: 8px;\n" +
            "}\n" +
            ".AddToCartPanel .PiceValue\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 50%;\n" +
            "    font-size: 14px;\n" +
            "    color: #000;\n" +
            "    padding: 0px 0;\n" +
            "    font-weight: normal;\n" +
            "    margin-bottom: 8px;\n" +
            "}\n" +
            ".AddToCartPanel a.AddCart\n" +
            "{\n" +
            "    font-size: 16px;\n" +
            "    padding: 3px 0;\n" +
            "    width: 40%;\n" +
            "    float: right;\n" +
            "    background-color: #ff7200;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".AddToCartPanel a.AddCart:hover\n" +
            "{\n" +
            "    background-color: #000;\n" +
            "    color: #fff;\n" +
            "}\n" +
            ".AddToCartContinueButton\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "}\n" +
            ".AddToCartContinue\n" +
            "{\n" +
            "    padding: 3px 10px;\n" +
            "    background-color: rgb(155, 10 ,222);\n" +
            "    color: #fff;\n" +
            "}\n" +
            ".AddToCartContinue:hover\n" +
            "{\n" +
            "    background-color: #000;\n" +
            "    color: #fff;\n" +
            "}\n" +
            "\n" +
            "/* AddToCart Notification End */\n" +
            "/*NewArrivalItem Begin*/\n" +
            ".NewArrivalTitle\n" +
            "{\n" +
            "    color: #000;\n" +
            "    font-size: 19px;\n" +
            "    font-weight: normal;\n" +
            "    line-height: 25px;\n" +
            "    padding: 5px 0px;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".NewArrival\n" +
            "{\n" +
            "    width: inherit;\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            ".NewArrival .CenterBlockRight\n" +
            "{\n" +
            "    margin-top: 50px;\n" +
            "}\n" +
            ".NewArrival .jcarousel-skin-tango .jcarousel-clip-horizontal\n" +
            "{\n" +
            "    width: 952px;\n" +
            "    margin: auto;\n" +
            "}\n" +
            ".NewArrival .jcarousel-skin-tango .jcarousel-item-horizontal\n" +
            "{\n" +
            "    margin: 0 13px 0 0;\n" +
            "}\n" +
            ".NewArrival .jcarousel-skin-tango .jcarousel-item\n" +
            "{\n" +
            "    width: 225px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".NewArrivalList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".NewArrivalItemStyle {\n" +
            "    width: 100%;\n" +
            "    vertical-align: top;\n" +
            "    min-height: 370px;\n" +
            "    position: relative;\n" +
            "    border: 2px solid rgb(155, 10,222) !important;\n" +
            "    border-bottom-style: dashed !important;\n" +
            "    border-top-style: dashed !important;\n" +
            "    border-left-style: dashed !important;\n" +
            "    border-right-style: dashed !important;\n" +
            "    background-color: #ededed !important;\n" +
            "}\n" +
            "\n" +
            ".NewArrivalItem\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    text-align: center;\n" +
            "    position: relative;\n" +
            "}\n" +
            ".NewArrivalItemColumn\n" +
            "{\n" +
            "    padding: 20px 0 40px;\n" +
            "    text-align: left;\n" +
            "    background-color: #fff;\n" +
            "}\n" +
            ".PageControlNewArrival\n" +
            "{\n" +
            "    color: #000;\n" +
            "    font-weight: normal;\n" +
            "    font-size: 16px;\n" +
            "}\n" +
            ".NewArrival .next, .NewArrival .prev\n" +
            "{\n" +
            "    display: block;\n" +
            "    height: 24px !important;\n" +
            "    top: -85px;\n" +
            "    position: absolute;\n" +
            "    width: 25px;\n" +
            "    z-index: 1;\n" +
            "}\n" +
            ".NewArrival .jcarousel-scroll a img\n" +
            "{\n" +
            "    border: 0;\n" +
            "    text-decoration: none;\n" +
            "    display: none;\n" +
            "    width: 25px;\n" +
            "    height: 24px;\n" +
            "}\n" +
            ".NewArrival .next\n" +
            "{\n" +
            "    right: 0;\n" +
            "    background: url(Images/Icon/next.jpg) no-repeat 0 0;\n" +
            "}\n" +
            ".NewArrival .prev\n" +
            "{\n" +
            "    right: 30px;\n" +
            "    background: url(Images/Icon/prev.jpg) no-repeat 0 0;\n" +
            "}\n" +
            ".NewArrival .next:hover\n" +
            "{\n" +
            "    background: url(Images/Icon/next-hover.jpg) no-repeat 0 0;\n" +
            "}\n" +
            ".NewArrival .prev:hover\n" +
            "{\n" +
            "    background: url(Images/Icon/prev-hover.jpg) no-repeat 0 0;\n" +
            "}\n" +
            ".NewArrivalLabel\n" +
            "{\n" +
            "    background-color: #ff7301;\n" +
            "    border-radius: 30px 30px 30px 30px;\n" +
            "    color: #FFFFFF;\n" +
            "    height: 45px;\n" +
            "    font-size: 12px;\n" +
            "    line-height: 35px;\n" +
            "    padding: 5px;\n" +
            "    position: absolute;\n" +
            "    text-align: center;\n" +
            "    width: 45px;\n" +
            "    z-index: 1;\n" +
            "    font-style: italic;\n" +
            "    font-weight: bold;\n" +
            "    margin: 0;\n" +
            "    text-transform: uppercase;\n" +
            "    left: 10px;\n" +
            "    top: 10px;\n" +
            "}\n" +
            "/*NewArrivalItem End*/\n" +
            "\n" +
            "/*RandomProduct Begin*/\n" +
            ".RandomProduct\n" +
            "{\n" +
            "    margin-bottom: 10px;\n" +
            "    position: relative;\n" +
            "}\n" +
            ".RandomProduct .CenterBlockLeft\n" +
            "{\n" +
            "    margin-top: 30px;\n" +
            "}\n" +
            ".RandomProductDataList\n" +
            "{\n" +
            "    width: 102%;\n" +
            "}\n" +
            ".RandomProductDataList .CommonProductItemStyle\n" +
            "{\n" +
            "    position: relative;\n" +
            "}\n" +
            ".RandomProductItem\n" +
            "{\n" +
            "    position: relative;\n" +
            "}\n" +
            ".RandomProductStock\n" +
            "{\n" +
            "    color: Red;\n" +
            "}\n" +
            "/*RandomProduct End*/\n" +
            "\n" +
            "/*ProductBestSelling Begin*/\n" +
            ".ProductBestSelling\n" +
            "{\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            ".ProductBestSelling .CenterBlockLeft\n" +
            "{\n" +
            "    margin-top: 30px;\n" +
            "}\n" +
            ".ProductBestSellingDataList\n" +
            "{\n" +
            "    width: 102%;\n" +
            "}\n" +
            ".ProductBestSellingDataList .CommonProductItemStyle\n" +
            "{\n" +
            "    position: relative;\n" +
            "}\n" +
            ".ProductBestSellingItem\n" +
            "{\n" +
            "    position: relative;\n" +
            "}\n" +
            "/*ProductBestSelling End*/\n" +
            "\n" +
            "/*PromotionGroup Begin*/\n" +
            ".PromotionGroup\n" +
            "{\n" +
            "    margin-bottom: 20px;\n" +
            "}\n" +
            ".PromotionGroup .CenterBlockLeft\n" +
            "{\n" +
            "    margin: 30px 0 10px;\n" +
            "}\n" +
            ".PromotionGroupDataList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".PromotionGroupTitle\n" +
            "{\n" +
            "    width: 100px;\n" +
            "    height: 21px;\n" +
            "    background: url(Images/Icon/promotion-label.jpg) no-repeat;\n" +
            "    position: absolute;\n" +
            "    z-index: 1;\n" +
            "    right: 2px;\n" +
            "    top: 2px;\n" +
            "}\n" +
            ".PromotionGroupImage\n" +
            "{\n" +
            "    position: relative;\n" +
            "    clear: left;\n" +
            "}\n" +
            ".CommonProductImage.PromotionGroupImage tr td\n" +
            "{\n" +
            "    border: 0;\n" +
            "}\n" +
            ".PromotionGroupDataList .CommonProductName\n" +
            "{\n" +
            "    text-align: left;\n" +
            "    background: none;\n" +
            "}\n" +
            ".PromotionGroupDataList .CommonProductNameLink\n" +
            "{\n" +
            "    font-size: 20px;\n" +
            "    color: #2a353c;\n" +
            "}\n" +
            ".PromotionGroupDataList .CommonProductDescription\n" +
            "{\n" +
            "    text-align: left;\n" +
            "}\n" +
            ".PromotionGroupDataList .OurPricePanel\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    margin: 10px 0;\n" +
            "}\n" +
            ".PromotionGroupDataList .OurPriceLabel\n" +
            "{\n" +
            "    float: left;\n" +
            "    line-height: 28px;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    font-size: 16px;\n" +
            "}\n" +
            ".PromotionGroupDataList .OurPriceValue\n" +
            "{\n" +
            "    float: right;\n" +
            "    font-size: 20px;\n" +
            "}\n" +
            ".PromotionGroupDataList table.CommonProductImage\n" +
            "{\n" +
            "    height: 175px;\n" +
            "}\n" +
            ".PromotionGroupDataList .CommonProductImage img\n" +
            "{\n" +
            "    max-height: 175px;\n" +
            "    height: auto !important;\n" +
            "    height: auto;\n" +
            "}\n" +
            ".PromotionGroupDataList .CommonProductImagePanel\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    height: 175px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ViewButtonPanel\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    position: absolute;\n" +
            "    top: 0;\n" +
            "    width: 100%;\n" +
            "    height: 175px;\n" +
            "    display: none;\n" +
            "    background-color: rgba(255,255,255,0.5);\n" +
            "    border: solid 1px #f3f3f3;\n" +
            "    z-index: 2;\n" +
            "}\n" +
            "a.ViewButton\n" +
            "{\n" +
            "    padding-top: 1px;\n" +
            "    background-color: rgb(155, 10 ,222);\n" +
            "    display: none;\n" +
            "    position: absolute;\n" +
            "    width: 60%;\n" +
            "    font-size: 11px;\n" +
            "    height: 24px;\n" +
            "    color: #fff;\n" +
            "    font-weight: bold;\n" +
            "    line-height: 24px;\n" +
            "    cursor: pointer;\n" +
            "    top: 45%;\n" +
            "    left: 20%;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            "a.ViewButton:hover\n" +
            "{\n" +
            "    background-color: #2a353c;\n" +
            "    color: #fff;\n" +
            "}\n" +
            ".CheckoutSpecialRequestPanel .CheckoutAddressLeftDataCheckbox label\n" +
            "{\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            "/*PromotionGroup End*/\n" +
            "\n" +
            "/*PromotionAds Begin*/\n" +
            ".PromotionAds\n" +
            "{\n" +
            "    margin: 20px 0;\n" +
            "}\n" +
            ".PromotionAds .SideBannerRight img\n" +
            "{\n" +
            "    width: auto;\n" +
            "}\n" +
            "/*PromotionAds End*/\n" +
            "\n" +
            "/*Newsletter Begin*/\n" +
            ".Newsletter\n" +
            "{\n" +
            "    clear: left;\n" +
            "    margin: 10px 0;\n" +
            "}\n" +
            "\n" +
            ".Newsletter .SidebarTop\n" +
            "{\n" +
            "    background: none;\n" +
            "    height: 20px;\n" +
            "    width: 100%;\n" +
            "    border: 0;\n" +
            "    padding: 0;\n" +
            "}\n";
    static String css2 =
            "\n" +
            "    .Newsletter .SidebarTopTitle {\n" +
            "        clear: left;\n" +
            "        float: left;\n" +
            "        text-transform: uppercase;\n" +
            "        line-height: 25px;\n" +
            "        margin-bottom: 5px;\n" +
            "        font-weight: lighter;\n" +
            "        color: #fff;\n" +
            "        font-size: 14px;\n" +
            "        font-family: Phenomena, Arial,Verdana,Calibri,Helvetica,sans-serif;\n" +
            "        font-style: normal;\n" +
            "        text-decoration: none;\n" +
            "    }\n" +
            "\n" +
            ".Newsletter .SidebarTopImgLeft, .Newsletter .SidebarTopImgRight, .Newsletter .SidebarBottom, .Newsletter .SidebarBottomImgLeft, .Newsletter .SidebarBottomImgRight\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".Newsletter .SidebarLeft\n" +
            "{\n" +
            "    border: 0;\n" +
            "}\n" +
            ".Newsletter .SidebarRight\n" +
            "{\n" +
            "    padding: 0;\n" +
            "    background: none;\n" +
            "    border: 0;\n" +
            "}\n"+
            ".NewsletterLabel\n" +
            "{\n" +
            "    color: #eee;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    margin: 0 0 10px;\n" +
            "    font-size: 12px;\n" +
            "}\n" +
            ".NewsletterForm\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "}\n" +
            "\n" +
            "input[type=\"text\"].NewsletterTextBox\n" +
            "{\n" +
            "    width: 68%;\n" +
            "    height: 28px;\n" +
            "    color: #2a353c;\n" +
            "    background-color: #fff;\n" +
            "    border: 0;\n" +
            "    margin: 0 0 2px;\n" +
            "    float: left;\n" +
            "    font-size: 10px;\n" +
            "    position: relative;\n" +
            "    z-index: 1;\n" +
            "    padding: 4px 10px;\n" +
            "    border-radius: 0;\n" +
            "}\n" +
            "\n" +
            ".NewsletterSubmit\n" +
            "{\n" +
            "    position: relative;\n" +
            "    z-index: 0;\n" +
            "    background-color: rgb(155, 10 ,222);\n" +
            "    color: #fff;\n" +
            "    float: left;\n" +
            "    padding: 0 5px;\n" +
            "    margin: 0;\n" +
            "    text-transform: lowercase;\n" +
            "    line-height: 28px;\n" +
            "}\n" +
            ".CommonValidateDivNewsLetter\n" +
            "{\n" +
            "    width: 46%;\n" +
            "    clear: both;\n" +
            "}\n" +
            "\n" +
            "/*Newsletter End*/\n" +
            "\n" +
            "/*PaymentLogo Begin*/\n" +
            ".PaymentLogo\n" +
            "{\n" +
            "    float: left;\n" +
            "    clear: left;\n" +
            "    margin-top: 15px;\n" +
            "}\n" +
            ".PaymentLogo img\n" +
            "{\n" +
            "    max-width: 220px !important;\n" +
            "}\n" +
            "/*PaymentLogo End*/\n" +
            "/*Faceted Search Start*/\n" +
            "\n" +
            ".PriceTitle\n" +
            "{\n" +
            "    padding: 0 0 5px;\n" +
            "    vertical-align: middle;\n" +
            "    color: #000;\n" +
            "    font-weight: bold;\n" +
            "    line-height: 27px;\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            ".FacetedSearchNavList\n" +
            "{\n" +
            "    margin-left: 10px;\n" +
            "    margin-bottom: 10px;\n" +
            "    font-size: 13px;\n" +
            "    width: 95%;\n" +
            "}\n" +
            ".FacetedSearchNavList .FacetedSearchNavList\n" +
            "{\n" +
            "    margin-left: 0;\n" +
            "    font-size: 14px;\n" +
            "}\n" +
            ".FacetedSearchNavList .PriceTitle\n" +
            "{\n" +
            "    padding-left: 0;\n" +
            "    font-size: 13px;\n" +
            "    margin-left: -10px;\n" +
            "}\n" +
            ".FacetedSearchNavList td\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    line-height: 25px;\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            ".FacetedSearchNavList a\n" +
            "{\n" +
            "    color: #000;\n" +
            "    text-decoration: none;\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            "\n" +
            ".FacetedSearchNavList a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    text-decoration: underline;\n" +
            "}\n" +
            "\n" +
            ".FacetedSearchSelected\n" +
            "{\n" +
            "    background-color: #FFFFFF;\n" +
            "    border: 1px dashed #DDDDDD;\n" +
            "    float: left;\n" +
            "    padding: 3px 5px;\n" +
            "    font-size: 11px;\n" +
            "    width: 100%;\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            ".FacetedSelectedBox\n" +
            "{\n" +
            "    padding: 5px 0;\n" +
            "}\n" +
            ".FacetedSelectedBox table\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".FacetedSearchSelected a\n" +
            "{\n" +
            "    float: right;\n" +
            "    margin-left: 5px;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            "\n" +
            ".FacetedSearchSelected a:hover\n" +
            "{\n" +
            "    text-decoration: none;\n" +
            "    color: #ff0000;\n" +
            "}\n" +
            "\n" +
            ".FacetedSelectedBox .GroupLabel\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            "\n" +
            "/*Faceted Search End*/\n" +
            "/* Mini Shopping Cart Start */\n" +
            ".MiniShoppingCartSidebarTopTitle\n" +
            "{\n" +
            "    color: #000000;\n" +
            "    font-size: 19px;\n" +
            "    font-weight: normal;\n" +
            "    line-height: 25px;\n" +
            "    padding: 5px 0;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            "\n" +
            ".MiniShoppingCartShowHidePanel\n" +
            "{\n" +
            "    display: none;\n" +
            "    float: right;\n" +
            "    margin-top: 2px;\n" +
            "}\n" +
            "\n" +
            ".MiniShoppingCartDetail\n" +
            "{\n" +
            "}\n" +
            "\n" +
            ".MiniShoppingCartTitle\n" +
            "{\n" +
            "    display: table;\n" +
            "    line-height: 24px;\n" +
            "    padding: 5px 0;\n" +
            "}\n" +
            "\n" +
            ".MiniShoppingCartButton\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "    margin-bottom: 5px;\n" +
            "    vertical-align: middle;\n" +
            "    float: left;\n" +
            "}\n" +
            ".MiniShoppingCartButton a\n" +
            "{\n" +
            "    text-transform: capitalize;\n" +
            "    text-shadow: 0;\n" +
            "    line-height: 25px;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".MiniShoppingCartButton a.BtnStyle2\n" +
            "{\n" +
            "    text-shadow: 0 0 0 #ff8112;\n" +
            "    background-color: #ff8112;\n" +
            "}\n" +
            ".MiniShoppingCartButton a.BtnStyle2:hover\n" +
            "{\n" +
            "    background-color: #000000;\n" +
            "    color: #ffffff;\n" +
            "}\n" +
            ".MiniShoppingCartDetail .CartDetailLabel\n" +
            "{\n" +
            "    font-size: 11px;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "}\n" +
            ".MiniShoppingCartDetail .CartDetailSubTotal\n" +
            "{\n" +
            "    font-size: 11px;\n" +
            "    color: #000;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "}\n" +
            "\n" +
            ".MiniShoppingCartLink\n" +
            "{\n" +
            "    color: #000;\n" +
            "    text-decoration: none;\n" +
            "    font-size: 12px;\n" +
            "}\n" +
            ".MiniShoppingCartLink:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".MiniShoppingCartQuantityAndPrice\n" +
            "{\n" +
            "    font-size: 12px;\n" +
            "    margin-top: 5px;\n" +
            "    color: #555;\n" +
            "}\n" +
            "\n" +
            ".MiniShoppingCartNoLink\n" +
            "{\n" +
            "    float: left;\n" +
            "    display: block;\n" +
            "    font-weight: normal;\n" +
            "    font-size: 11px;\n" +
            "    line-height: 17px;\n" +
            "}\n" +
            "\n" +
            ".MiniShoppingCartSubTotal\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    color: #000;\n" +
            "}\n" +
            "\n" +
            ".MiniShoppingCartRecentlyPanel\n" +
            "{\n" +
            "    border-top: solid 1px #e4e4e4;\n" +
            "    padding: 10px 5px;\n" +
            "}\n" +
            "\n" +
            ".MiniShoppingCartRecentlyTitle\n" +
            "{\n" +
            "    margin: 0 0 10px 0px;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".MiniShoppingCartRecentlyPanel .RecentlyAddGrid\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".MiniShoppingCartRecentlyPanel .RecentlyGridEmpty\n" +
            "{\n" +
            "    background-color: #f1f1f1;\n" +
            "    border: solid 1px #e5e5e5;\n" +
            "    text-align: center;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".MiniShoppingCartRecentlyPanel .RecentlyItemImage\n" +
            "{\n" +
            "    width: 30%;\n" +
            "}\n" +
            ".MiniShoppingCartRecentlyPanel .RecentlyItemImageDiv\n" +
            "{\n" +
            "    width: 100% !important;\n" +
            "    height: 75% !important;\n" +
            "    padding: 1px;\n" +
            "    border: solid 1px #ddd !important;\n" +
            "}\n" +
            ".MiniShoppingCartRecentlyPanel .RecentlyItemName\n" +
            "{\n" +
            "    font-size: 11px;\n" +
            "    padding-left: 10px;\n" +
            "}\n" +
            ".MiniShoppingCartRecentlyPanel .RecentlyItemDelete\n" +
            "{\n" +
            "}\n" +
            "/* Mini Shopping Cart End */\n" +
            "\n" +
            "/*ProductList CommonStyle Begin*/\n" +
            ".ProductListDefaultDataList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ProductListDefault\n" +
            "{\n" +
            "    clear: left;\n" +
            "    margin-bottom: 25px;\n" +
            "}\n" +
            "/*ProductList CommonStyle End*/\n" +
            "/*Product Catalog Begin*/\n" +
            ".Catalog .CommonPageRight, .Department .CommonPageRight, .Manufacturer .CommonPageRight\n" +
            "{\n" +
            "    padding: 0;\n" +
            "}\n" +
            ".CatalogRoot\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".ProductMainDiv .NewArrivalCategory .SidebarTop\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".MainDiv .NewArrivalCategory .SidebarLeft\n" +
            "{\n" +
            "    border-top: 0 !important;\n" +
            "}\n" +
            "\n" +
            ".MainDiv .Catalog .CategoryDescription\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "/*Product Catalog End*/\n" +
            "/*CatalogImage Begin*/\n" +
            ".CatalogImagePanel\n" +
            "{\n" +
            "    width: 460px;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            ".CatalogImage\n" +
            "{\n" +
            "    width: inherit;\n" +
            "    float: left;\n" +
            "}\n" +
            ".CatalogImage img\n" +
            "{\n" +
            "    height: auto !important;\n" +
            "    max-height: 200px;\n" +
            "    width: auto !important;\n" +
            "    max-width: 460px;\n" +
            "}\n" +
            ".CatalogName\n" +
            "{\n" +
            "    color: #000;\n" +
            "    font-size: 19px;\n" +
            "    font-weight: normal;\n" +
            "    line-height: 25px;\n" +
            "    padding: 12px 0 10px;\n" +
            "    text-transform: uppercase;\n" +
            "    min-height: 35px;\n" +
            "    width: 100%;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin-bottom: 10px;\n" +
            "    border-bottom: 3px dotted rgb(184, 184, 184);\n" +
            "}\n" +
            ".CatalogImageDescription\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "/*CatalogImage End*/\n" +
            "/*CatalogBreadcrumb Begin*/\n" +
            ".CatalogBreadcrumb\n" +
            "{\n" +
            "    color: #666;\n" +
            "    width: 95%;\n" +
            "    font-weight: normal;\n" +
            "    font-size: 11px;\n" +
            "    line-height: 20px;\n" +
            "}\n" +
            ".CatalogBreadcrumb a\n" +
            "{\n" +
            "    text-decoration: none;\n" +
            "    color: #999;\n" +
            "}\n" +
            ".CatalogBreadcrumb a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".CatalogBreadcrumbNodeStyle\n" +
            "{\n" +
            "    display: block;\n" +
            "    float: left;\n" +
            "    color: #000;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".CatalogBreadcrumbPathSeparatorStyle\n" +
            "{\n" +
            "    color: #999;\n" +
            "    padding: 0;\n" +
            "    font-size: 0 !important;\n" +
            "    background: url(Images/Icon/icon-next.gif) no-repeat center center;\n" +
            "    bottom: 4px;\n" +
            "    width: 20px;\n" +
            "    height: 20px;\n" +
            "    display: block;\n" +
            "    float: left;\n" +
            "}\n" +
            ".CatalogBreadcrumbRootNodeStyle\n" +
            "{\n" +
            "    display: block;\n" +
            "    float: left;\n" +
            "}\n" +
            "\n" +
            "\n" +
            "/*CatalogBreadcrumb End*/\n" +
            "/*ProductListViewType Begin*/\n" +
            ".OptionControlTitle\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-right: 5px;\n" +
            "}\n" +
            ".ProductListViewButton, .ProductGridViewButton, .ProductTableViewButton, .ProductListViewButtonDisable, .ProductGridViewButtonDisable, .ProductTableViewButtonDisable\n" +
            "{\n" +
            "    width: 16px;\n" +
            "    height: 16px;\n" +
            "    display: block;\n" +
            "    float: left;\n" +
            "    margin-right: 5px;\n" +
            "    font-size: 0;\n" +
            "}\n" +
            ".ProductListViewButton\n" +
            "{\n" +
            "    background: url(Images/icon/icon_list_enable.gif) no-repeat;\n" +
            "}\n" +
            ".ProductGridViewButton\n" +
            "{\n" +
            "    background: url(Images/icon/icon_grid_enable.gif) no-repeat;\n" +
            "}\n" +
            ".ProductTableViewButton\n" +
            "{\n" +
            "    background: url(Images/icon/icon_table_enable.gif) no-repeat;\n" +
            "}\n" +
            ".ProductListViewButtonDisable\n" +
            "{\n" +
            "    background: url(Images/icon/icon_list_disable.gif) no-repeat;\n" +
            "}\n" +
            ".ProductGridViewButtonDisable\n" +
            "{\n" +
            "    background: url(Images/icon/icon_grid_disable.gif) no-repeat;\n" +
            "}\n" +
            ".ProductTableViewButtonDisable\n" +
            "{\n" +
            "    background: url(Images/icon/icon_table_disable.gif) no-repeat;\n" +
            "}\n" +
            "/*ProductListViewType End*/\n" +
            "/*Common ProductList Sorting,Paging Begin*/\n" +
            ".ProductListDefaultSortString\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 26%;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".ProductListDefaultSortString a\n" +
            "{\n" +
            "    margin-top: 7px;\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            ".ProductListDefaultItemPerPage\n" +
            "{\n" +
            "    float: right;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".ProductListDefaultSortUpDown\n" +
            "{\n" +
            "    float: left;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".ProductListDefaultPageControlPanel\n" +
            "{\n" +
            "    clear: both;\n" +
            "    line-height: 30px;\n" +
            "    margin-bottom: 10px;\n" +
            "    padding: 3px 0;\n" +
            "    width: 100%;\n" +
            "    color: #000;\n" +
            "    border-top: solid 1px #e8e8e8;\n" +
            "    border-bottom: solid 1px #e8e8e8;\n" +
            "}\n" +
            ".ProductListDefaultItemPerPage select\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-right: 6px;\n" +
            "    margin-top: 6px;\n" +
            "    width: auto;\n" +
            "}\n" +
            ".ProductListDefaultSortUpDown select\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-right: 6px;\n" +
            "    margin-top: 6px;\n" +
            "    width: auto;\n" +
            "}\n" +
            ".ProductItemIconSort\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "    float: left;\n" +
            "}\n" +
            ".ProductListDefaultPagingControl\n" +
            "{\n" +
            "    border-top: 1px solid #e8e8e8;\n" +
            "    clear: both;\n" +
            "    color: #000;\n" +
            "    float: left;\n" +
            "    line-height: 27px;\n" +
            "    margin: 10px 0;\n" +
            "    padding: 5px 0;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ProductListDefaultPagingControl a\n" +
            "{\n" +
            "    margin: 0 2px;\n" +
            "}\n" +
            ".ProductListDefaultPagingControl .PagingNext\n" +
            "{\n" +
            "    color: #1e1e1e;\n" +
            "}\n" +
            ".ProductItemPaging\n" +
            "{\n" +
            "    float: right;\n" +
            "    margin-left: 10px;\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            ".ProductListDefaultDataList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ProductListDefaultDataListHeader\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".ProductListDefaultDataListItemStyle\n" +
            "{\n" +
            "    padding: 2px;\n" +
            "    vertical-align: top;\n" +
            "}\n" +
            ".ProductListItemTable td\n" +
            "{\n" +
            "    background-color: #fff;\n" +
            "}\n" +
            "/*Common ProductList Sorting,Paging End*/\n" +
            "/*Common ProductList Sorting - ItemPerPage and Sortby Begin*/\n" +
            ".ProductListGridListItemPerPage\n" +
            "{\n" +
            "    float: right;\n" +
            "    font-size: 11px;\n" +
            "    margin-right: 20px;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".ProductListGridListSortUpDown\n" +
            "{\n" +
            "    float: right;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".ProductListGridListItemPerPage select\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-right: 6px;\n" +
            "    margin-top: 6px;\n" +
            "    width: auto;\n" +
            "}\n" +
            ".ProductListGridListSortUpDown select\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-right: 6px;\n" +
            "    margin-top: 6px;\n" +
            "    width: auto;\n" +
            "}\n" +
            "/*Common ProductList Sorting - ItemPerPage and Sortby End*/\n" +
            "/* Common LinkToTop Style Begin */\n" +
            ".ProductLinkToTopDiv, .NewsLinkToTopDiv\n" +
            "{\n" +
            "    float: right;\n" +
            "    background: url(Images/Bullet/top.gif) no-repeat left center;\n" +
            "    padding-left: 14px;\n" +
            "}\n" +
            ".ProductLinkToTop, .NewsLinkToTop\n" +
            "{\n" +
            "    display: block;\n" +
            "    text-align: left;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".ProductLinkToTop:hover, .NewsLinkToTop:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            "/* Common LinkToTop Style End */\n" +
            "/* Common Pagin Style Begin */\n" +
            ".PagingPrev\n" +
            "{\n" +
            "    background: url(Images/Icon/icon-prev.gif) no-repeat left center;\n" +
            "    padding-left: 14px;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".PagingNext\n" +
            "{\n" +
            "    background: url(Images/Icon/icon-next.gif) no-repeat right center;\n" +
            "    padding-right: 14px;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".PagingNumber\n" +
            "{\n" +
            "    color: #fff;\n" +
            "    background-color: #29343b;\n" +
            "    padding: 1px 6px;\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            ".PagingCurrent\n" +
            "{\n" +
            "    color: #fff;\n" +
            "    background-color: #01ae91;\n" +
            "    padding: 1px 6px;\n" +
            "}\n" +
            ".PagingPrev:hover, .PagingNext:hover, .PagingNumber:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".PagingPrev[disabled], .PagingNext[disabled]\n" +
            "{\n" +
            "    color: #1e1e1e;\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            "/* Common Pagin Style End */\n" +
            "/* Common ItemCount Style Begin */\n" +
            ".ProductItemCountItemCount\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 30%;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            "/* Common ItemCount Style End */\n" +
            "/*Common Product other button style [wishlist/compare/tell friend] Begin*/\n" +
            ".AddToWishListButtonLinkButton\n" +
            "{\n" +
            "    background-image: url(Images/Icon/icon-wishlist.png);\n" +
            "}\n" +
            ".AddToCompareListButtonLinkButton\n" +
            "{\n" +
            "    background-image: url(Images/Icon/icon-compare.png);\n" +
            "}\n" +
            ".TellFriendLinkButton\n" +
            "{\n" +
            "    background-image: url(Images/Icon/TellFriend.png);\n" +
            "}\n" +
            ".AddToWishListButtonLinkButton, .AddToCompareListButtonLinkButton, .TellFriendLinkButton\n" +
            "{\n" +
            "    background-position: left 1px;\n" +
            "    background-repeat: no-repeat;\n" +
            "    border: 0 none;\n" +
            "    color: #1e1e1e;\n" +
            "    display: block;\n" +
            "    font-size: 11px;\n" +
            "    height: 20px;\n" +
            "    line-height: 20px;\n" +
            "    margin: 0 0 5px;\n" +
            "    padding: 0 0 0 17px;\n" +
            "    text-align: left;\n" +
            "    text-decoration: none;\n" +
            "    width: 100%;\n" +
            "}\n" +
            "/*Common Product other button style [wishlist/compare/tell friend] End*/\n" +
            "/*Common Category List [Layout] Begin*/\n" +
            ".CategoryListDefaultPageItemControlDiv, .DepartmentListDefaultPageItemControlDiv, .ManufacturerListDefaultPageItemControlDiv\n" +
            "{\n" +
            "    border-bottom: 1px solid #e8e8e8;\n" +
            "    clear: both;\n" +
            "    color: #000;\n" +
            "    float: left;\n" +
            "    line-height: 27px;\n" +
            "    margin: 5px 0 45px;\n" +
            "    padding: 5px 0;\n" +
            "    width: 100%;\n" +
            "}\n" +
            "\n" +
            ".CategoryListDefaultPageItemControlDiv a, .DepartmentListDefaultPageItemControlDiv a, .ManufacturerListDefaultPageItemControlDiv a\n" +
            "{\n" +
            "    margin: 0 2px;\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            ".CategoryListDefaultItemPerPageDiv, .DepartmentListDefaultItemPerPageDiv, .ManufacturerListDefaultItemPerPageDiv\n" +
            "{\n" +
            "    float: left;\n" +
            "    font-size: 11px;\n" +
            "    width: 50%;\n" +
            "}\n" +
            ".CategoryListDefaultItemPerPageDiv select, .DepartmentListDefaultItemPerPageDiv select, .ManufacturerListDefaultItemPerPageDiv select\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin: 3px 10px 0 0;\n" +
            "    width: auto;\n" +
            "}\n" +
            ".CategoryListItemDefaultTable\n" +
            "{\n" +
            "    margin-left: auto;\n" +
            "    margin-right: auto;\n" +
            "}\n" +
            ".CategoryListDefaultDataList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    clear: left;\n" +
            "    margin-bottom: 30px;\n" +
            "}\n" +
            ".CategoryListDefaultDataListHeader\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".CategoryListItemDefaultImageColumn\n" +
            "{\n" +
            "    height: 140px;\n" +
            "    background-color: #fff;\n" +
            "    border: solid 1px #e7e7e7;\n" +
            "    padding: 5px;\n" +
            "}\n" +
            ".CategoryListItemDefaultImageDiv\n" +
            "{\n" +
            "    width: 140px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".CategoryListItemDefaultImageDiv img\n" +
            "{\n" +
            "    height: auto !important;\n" +
            "    max-height: 130px;\n" +
            "    max-width: 140px;\n" +
            "    width: auto !important;\n" +
            "}\n" +
            ".CategoryListItemDefaultNameDiv\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    margin-top: 5px;\n" +
            "    margin-bottom: 15px;\n" +
            "    width: 150px;\n" +
            "}\n" +
            ".CategoryListDefaultDataListItem\n" +
            "{\n" +
            "    vertical-align: top;\n" +
            "}\n" +
            "/*Common Category List [Layout] End*/\n" +
            "/*Department List [Layout] Begin*/\n" +
            ".DepartmentListItemDefaultTable\n" +
            "{\n" +
            "    margin: 0 auto;\n" +
            "    width: 150px;\n" +
            "}\n" +
            ".DepartmentListDefaultDataList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    clear: left;\n" +
            "    margin-bottom: 30px;\n" +
            "}\n" +
            ".DepartmentListDefaultDataListHeader\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".DepartmentListItemDefaultImageColumn {\n" +
            "    height: 140px;\n" +
            "    background-color: #fff;\n" +
            "    /*border: solid 1px #E5E5E5;armando*/\n" +
            "    padding: 5px;\n" +
            "}\n" +
            ".DepartmentListItemDefaultImageDiv\n" +
            "{\n" +
            "    width: 140px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".DepartmentListItemDefaultImageDiv img\n" +
            "{\n" +
            "    height: auto !important;\n" +
            "    max-height: 130px;\n" +
            "    max-width: 140px;\n" +
            "    width: auto !important;\n" +
            "}\n" +
            ".DepartmentListItemDefaultNameDiv\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    margin-top: 5px;\n" +
            "    margin-bottom: 15px;\n" +
            "    width: 150px;\n" +
            "}\n" +
            ".DepartmentListItemDefaultNameDiv\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            ".DepartmentListItemDefaultNameDiv a\n" +
            "{\n" +
            "    color: #000;\n" +
            "    font-size: 10px;\n" +
            "    font-weight: normal;\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            ".DepartmentListItemDefaultNameDiv a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".DepartmentListDefaultDataListItem\n" +
            "{\n" +
            "    vertical-align: top;\n" +
            "}\n" +
            ".DepartmentListItemDefaultDescriptionColumn\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "/*DepartmentList [Layout] End*/\n" +
            "\n" +
            "/*------------------ CategoryList Style ------------------*/\n" +
            "/* CategoryListItemDefault3 Begin */\n" +
            ".CategoryDescription\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    margin: 0;\n" +
            "    color: #666;\n" +
            "    line-height: 22px;\n" +
            "    color: #1e1e1e;\n" +
            "    margin: 10px 0px 10px 0;\n" +
            "}\n" +
            ".CategoryListDefault3\n" +
            "{\n" +
            "    width: 102%;\n" +
            "    margin-bottom: 50px;\n" +
            "}\n" +
            ".CategoryListItemDefault3 {\n" +
            "    /*border: solid 1px #eaeaea; armando*/\n" +
            "    padding: 0 3px;\n" +
            "}\n" +
            ".CategoryDescriptionDiv\n" +
            "{\n" +
            "    margin: 15px 0px 25px 0;\n" +
            "    padding: 0 20px;\n" +
            "    color: #1e1e1e;\n" +
            "    line-height: 22px;\n" +
            "}\n" +
            ".CatalogControlPanel .CategoryDescriptionDiv\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "/* CategoryListItemDefault3 End */\n" +
            "\n" +
            "/*------------------ Product List Style ------------------\n" +
            "ProductListItem [Layout>Controls] Begin*/\n" +
            ".ProductRowDataList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ProductRowDataList .CommonProductImage\n" +
            "{\n" +
            "    padding: 30px 0;\n" +
            "}\n" +
            ".ProductRowDataList table.CommonProductImage\n" +
            "{\n" +
            "    padding-top: 0;\n" +
            "}\n" +
            ".ProductRowDataList .PriceDiscountLabel\n" +
            "{\n" +
            "    margin-top: 25px;\n" +
            "    margin-left: 10px;\n" +
            "}\n" +
            ".ProductRowDataList .CommonProductName\n" +
            "{\n" +
            "    margin-bottom: 0px;\n" +
            "    background: none;\n" +
            "    margin-left: 0px;\n" +
            "}\n" +
            ".ProductRowDataList .FreeShippingLabel\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".ProductRowDataList .DiscountLabel\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".ProductRowDataList .ProductListItemTellFriendPanel\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".ProductRowDataList a.QuickViewButton\n" +
            "{\n" +
            "    width: 96%;\n" +
            "    left: 2%;\n" +
            "    bottom: 2%;\n" +
            "    top: auto;\n" +
            "}\n" +
            ".ProductRowDataList .CommonProductImage img\n" +
            "{\n" +
            "    position: relative;\n" +
            "    z-index: 1;\n" +
            "    max-height: 150px;\n" +
            "}\n" +
            ".ProductListItem\n" +
            "{\n" +
            "    padding: 0;\n" +
            "    position: relative;\n" +
            "    margin: auto;\n" +
            "}\n" +
            ".ProductListItem .PriceDiscountLabel\n" +
            "{\n" +
            "    left: 0;\n" +
            "    top: 10px;\n" +
            "}\n" +
            ".ProductListItem .PriceLabel, .ProductListItem .OurPriceLabel\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".ProductListItem .DiscountPercent\n" +
            "{\n" +
            "    float: none;\n" +
            "}\n" +
            ".ProductListItem .PercentLabel, .ProductListItem .PercentValue\n" +
            "{\n" +
            "    color: #fff;\n" +
            "    margin: 0;\n" +
            "    font-style: italic;\n" +
            "    font-weight: bold;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".ProductListItem .PercentLabel\n" +
            "{\n" +
            "    font-size: 85%;\n" +
            "}\n" +
            ".ProductListItem .PercentLabel\n" +
            "{\n" +
            "    font-size: 85%;\n" +
            "}\n" +
            ".ProductListItem div.CommonProductImage\n" +
            "{\n" +
            "    width: 30%;\n" +
            "    float: left;\n" +
            "}\n" +
            ".ProductListItem .ProductListItemDetailsColumn\n" +
            "{\n" +
            "    width: 70%;\n" +
            "    padding: 25px 3.5% 0;\n" +
            "    float: left;\n" +
            "    text-align: left;\n" +
            "}\n" +
            ".ProductListItem .CommonProductPriceDetails\n" +
            "{\n" +
            "    margin-bottom: 0;\n" +
            "}\n" +
            ".ProductListItem .ProductListDiscountPercent\n" +
            "{\n" +
            "    margin-left: 0;\n" +
            "}\n" +
            ".ProductListItem .ProductListItemSpecialLabel\n" +
            "{\n" +
            "    float: right;\n" +
            "    margin: 7px 0 0 0;\n" +
            "    width: 46%;\n" +
            "}\n" +
            ".ProductListItem .ProductListItemQuantityDiscountPanel\n" +
            "{\n" +
            "    display: inline-block;\n" +
            "}\n" +
            ".ProductListItem .CommonProductDescription\n" +
            "{\n" +
            "    background: url(\"Images/Background/dot-line.jpg\") repeat-x left bottom;\n" +
            "    padding-bottom: 15px;\n" +
            "}\n" +
            ".ProductListItem .CommonProductRating\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 12px 0;\n" +
            "}\n" +
            ".ProductListItem .ProductListItemDetailsPriceDiv\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-left: 2%;\n" +
            "    margin-top: 5px;\n" +
            "}\n" +
            ".ProductListItem .RetailPricePanel\n" +
            "{\n" +
            "    margin-top: 8px;\n" +
            "}\n" +
            ".ProductListItemTellFriendPanel, .ProductListItemAddtoWishListPanel, .ProductListItemAddtoCompareListPanel\n" +
            "{\n" +
            "    display: inline-block;\n" +
            "    padding-left: 2%;\n" +
            "    margin-top: 3px;\n" +
            "}\n" +
            ".ProductListItemRmaPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 5px 0;\n" +
            "    width: 100%;\n" +
            "    font-size: 12px;\n" +
            "}\n" +
            ".ProductListItemTellFriendPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "}\n" +
            ".ProductListItemOutOfStockPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 5px 0;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ProductListItemOptionGroupPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 5px 0;\n" +
            "    width: 100%;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".ProductListItemButtonDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 5px 0;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ProductListItem .BtnStyle1\n" +
            "{\n" +
            "    background-color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".ProductListItem .CommonProductImagePanel\n" +
            "{\n" +
            "    position: relative;\n" +
            "}\n" +
            ".ProductListItem .CommonProductImagePanel .QuickViewButtonBorder\n" +
            "{\n" +
            "    top: 0;\n" +
            "}\n" +
            "/*ProductListItem [Layout>Controls] End*/\n" +
            "\n" +
            "/*ProductListItemColumn2 [Layout>Controls] Begin*/\n" +
            ".ProductColumn2DataList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ProductColumn2Item\n" +
            "{\n" +
            "    vertical-align: top;\n" +
            "}\n" +
            ".ProductListColumn2ItemStyle\n" +
            "{\n" +
            "    vertical-align: top;\n" +
            "    padding: 10px 0;\n" +
            "}\n" +
            ".ProductListItemColumn2\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    padding: 0;\n" +
            "    position: relative;\n" +
            "    margin: auto;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ProductListItemColumn2 .PriceLabel, .ProductListItemColumn2 .OurPriceLabel\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".ProductListItemColumn2 .DiscountPercent\n" +
            "{\n" +
            "    float: none;\n" +
            "}\n" +
            ".ProductListItemColumn2 .PercentLabel, .ProductListItemColumn2 .PercentValue\n" +
            "{\n" +
            "    color: #fff;\n" +
            "    margin: 0;\n" +
            "    font-style: italic;\n" +
            "    font-weight: bold;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".ProductListItemColumn2 .PercentLabel\n" +
            "{\n" +
            "    font-size: 85%;\n" +
            "}\n" +
            ".ProductListItemColumn2 .PercentLabel\n" +
            "{\n" +
            "    font-size: 85%;\n" +
            "}\n" +
            ".ProductListItemColumn2 .CommonProductPriceDetails\n" +
            "{\n" +
            "    margin-bottom: 0;\n" +
            "}\n" +
            ".ProductListItemColumn2 .ProductListDiscountPercent\n" +
            "{\n" +
            "    margin-left: 0;\n" +
            "}\n" +
            ".ProductListItemColumn2 .CommonProductSpecialLabel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 5px 0;\n" +
            "    width: 100%;\n" +
            "    display: none;\n" +
            "}\n" +
            ".ProductListItemColumn2 .CommonProductButton\n" +
            "{\n" +
            "    margin-top: 0px;\n" +
            "}\n" +
            ".ProductListItemColumn2 .CommonProductName\n" +
            "{\n" +
            "    position: relative;\n" +
            "}\n" +
            ".ProductListItemColumn2DetailsColumn\n" +
            "{\n" +
            "    margin: 0;\n" +
            "    position: relative;\n" +
            "}\n" +
            ".ProductListItemColumn2TellFriendPanel, .ProductListItemColumn2AddtoWishListPanel, .ProductListItemColumn2AddtoCompareListPanel\n" +
            "{\n" +
            "    display: inline-block;\n" +
            "    margin: 0px 8px;\n" +
            "    z-index: 0;\n" +
            "    position: relative;\n" +
            "    vertical-align: middle;\n" +
            "}\n" +
            ".AddToWishListButtonLinkButton:hover, .AddToCompareListButtonLinkButton:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    background-color: #FFF;\n" +
            "}\n" +
            ".ProductListItemColumn2TellFriendPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "}\n" +
            ".ProductListItemColumn2OutOfStockPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    color: Red;\n" +
            "}\n" +
            ".ProductListItemColumn2OptionGroupPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 5px 0;\n" +
            "    width: 100%;\n" +
            "    font-size: 14px;\n" +
            "}\n" +
            ".ProductListItemColumn2 .ProductListItemQuantityDiscountPanel\n" +
            "{\n" +
            "    display: inline-block;\n" +
            "}\n" +
            ".ProductListItemColumn2 .BtnStyle1\n" +
            "{\n" +
            "    background-color: rgb(155, 10 ,222);\n" +
            "}\n" +
            "/*ProductListItemColumn2 [Layout>Controls] End*/\n" +
            "\n" +
            "/* ProductListTableView [Layout>Controls] Begin */\n" +
            ".ProductListTableViewItem .RetailPriceValue, .ProductListTableViewItem .RetailPricePanel\n" +
            "{\n" +
            "    float: none;\n" +
            "}\n" +
            ".ProductListTableViewItem .OurPricePanel\n" +
            "{\n" +
            "    float: none;\n" +
            "}\n" +
            ".ProductTableDataList\n" +
            "{\n" +
            "    clear: left;\n" +
            "    margin-bottom: 20px;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ProductTableDataList .QuickViewButtonBorder\n" +
            "{\n" +
            "    top: 0px;\n" +
            "}\n" +
            ".ProductTableDataList .QuickViewButtonPanel\n" +
            "{\n" +
            "    min-height: 85px;\n" +
            "}\n" +
            ".ProductTableDataList a.QuickViewButton\n" +
            "{\n" +
            "    width: 96%;\n" +
            "    left: 2%;\n" +
            "    top: auto;\n" +
            "    bottom: 2%;\n" +
            "}\n" +
            ".ProductColumn2DataList .FreeShippingLabel\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".ProductColumn2DataList .DiscountLabel\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".ProductColumn2DataList .ProductListItemColumn2TellFriendPanel\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".ProductListTableViewItem\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    position: relative;\n" +
            "}\n" +
            ".ProductListTableViewItem .DiscountLabel\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "\n" +
            ".ProductListTableViewItem td\n" +
            "{\n" +
            "    border-bottom: solid 1px #f0f0f0;\n" +
            "    border-left: solid 1px #f0f0f0;\n" +
            "    vertical-align: top;\n" +
            "    z-index: 0;\n" +
            "    position: relative;\n" +
            "    padding: 10px 5px 0;\n" +
            "    background-color: #fff;\n" +
            "}\n" +
            ".ProductListTableViewItem .RatingControlColumn\n" +
            "{\n" +
            "    border: 0;\n" +
            "    padding: 0;\n" +
            "}\n" +
            ".ProductListTableViewItem .Image td\n" +
            "{\n" +
            "    border: 0;\n" +
            "    padding: 0px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ProductListTableViewTopItem\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    background-color: #fff;\n" +
            "    border-top: solid 1px #f0f0f0;\n" +
            "    padding: 0px;\n" +
            "    height: 34px;\n" +
            "    width: 100%;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".ProductListTableViewTopItem td\n" +
            "{\n" +
            "    border-bottom: solid 1px #f0f0f0;\n" +
            "    border-left: solid 1px #f0f0f0;\n" +
            "    padding: 0 1%;\n" +
            "    text-align: center;\n" +
            "    min-height: 38px;\n" +
            "}\n" +
            ".ProductListTableViewTopItem .Image\n" +
            "{\n" +
            "    width: 20%;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ProductListTableViewTopItem .Name\n" +
            "{\n" +
            "    font-weight: bold;\n" +
            "    font-weight: bold;\n" +
            "}\n" +
            ".ProductListTableViewTopItem .Sku\n" +
            "{\n" +
            "    width: 17%;\n" +
            "    font-weight: bold;\n" +
            "}\n" +
            ".ProductListTableViewTopItem .Price\n" +
            "{\n" +
            "    width: 19%;\n" +
            "    font-weight: bold;\n" +
            "}\n" +
            ".ProductListTableViewTopItem .Button\n" +
            "{\n" +
            "    width: 19%;\n" +
            "    border-right: solid 1px #f0f0f0;\n" +
            "}\n" +
            ".ProductListTableViewItem .DiscountPercent\n" +
            "{\n" +
            "    float: none;\n" +
            "}\n" +
            ".ProductListTableViewItem .PercentLabel, .ProductListTableViewItem .PercentValue\n" +
            "{\n" +
            "    color: #fff;\n" +
            "    margin: 0;\n" +
            "    font-style: italic;\n" +
            "    font-weight: bold;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".ProductListTableViewItem .PercentLabel\n" +
            "{\n" +
            "    font-size: 85%;\n" +
            "}\n" +
            ".ProductListTableViewItem .Image\n" +
            "{\n" +
            "    width: 20%;\n" +
            "    text-align: center;\n" +
            "    vertical-align: middle;\n" +
            "    padding: 0;\n" +
            "    min-height: 100px;\n" +
            "}\n" +
            ".ProductListTableViewItem .Image1\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ProductListTableViewItem .ImagePanel\n" +
            "{\n" +
            "    background-color: #fff;\n" +
            "    vertical-align: top;\n" +
            "    margin: auto;\n" +
            "}\n" +
            ".ProductListTableViewItem .ImagePanel img\n" +
            "{\n" +
            "    max-width: 105px;\n" +
            "    width: auto !important;\n" +
            "    width: 105px;\n" +
            "    max-height: 105px;\n" +
            "    height: auto !important;\n" +
            "    height: 105px;\n" +
            "    min-height: 90px;\n" +
            "}\n" +
            ".ProductListTableViewItem .ImagePanel .ProductLink\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ProductListTableViewItem .Name\n" +
            "{\n" +
            "}\n" +
            ".ProductListTableViewItem .Sku\n" +
            "{\n" +
            "    width: 17%;\n" +
            "    font-size: 14px;\n" +
            "    line-height: 28px;\n" +
            "    color: #66767B;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ProductListTableViewItem .Price\n" +
            "{\n" +
            "    width: 19%;\n" +
            "}\n" +
            ".ProductListTableViewItem .Button\n" +
            "{\n" +
            "    width: 19%;\n" +
            "    text-align: center;\n" +
            "    border-right: solid 1px #f0f0f0;\n" +
            "    padding-bottom: 10px;\n" +
            "}\n" +
            ".ProductListTableViewItem .RetailPricePanel\n" +
            "{\n" +
            "    margin-top: 5px;\n" +
            "}\n" +
            ".ProductListTableViewItem .CommonProductName\n" +
            "{\n" +
            "    float: left;\n" +
            "    height: auto;\n" +
            "    margin: 5px 10px;\n" +
            "    line-height: 29px;\n" +
            "    text-align: center;\n" +
            "    background: none;\n" +
            "}\n" +
            ".ProductListTableViewItem .CommonProductNameLink\n" +
            "{\n" +
            "    font-size: 14px;\n" +
            "    line-height: 25px;\n" +
            "}\n" +
            ".ProductListTableViewItem .CommonProductRating\n" +
            "{\n" +
            "    margin: auto;\n" +
            "    padding-top: 5px;\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            ".ProductListTableViewItem .BtnStyle1\n" +
            "{\n" +
            "    padding: 2px 10px;\n" +
            "    line-height: 20px;\n" +
            "    background-color: rgb(155, 10 ,222);\n" +
            "    margin: 0px 5px 8px 15%;\n" +
            "}\n" +
            ".TableViewTellFriendPanel, .TableViewAddtoWishListPanel, .TableViewAddtoCompareListPanel\n" +
            "{\n" +
            "    margin-left: 22%;\n" +
            "    display: inline-block;\n" +
            "    width: 95%;\n" +
            "}\n" +
            ".AdvancedSearchResult .ProductListTableViewItem .BtnStyle1\n" +
            "{\n" +
            "    padding: 2px 10px;\n" +
            "    line-height: 20px;\n" +
            "    background-color: rgb(155, 10 ,222);\n" +
            "    margin: 0px 5px 8px 27%;\n" +
            "}\n" +
            ".AdvancedSearchResult .TableViewTellFriendPanel, .AdvancedSearchResult .TableViewAddtoWishListPanel, .AdvancedSearchResult .TableViewAddtoCompareListPanel\n" +
            "{\n" +
            "    margin-left: 30%;\n" +
            "    display: inline-block;\n" +
            "    width: 95%;\n" +
            "}\n" +
            ".ProductListTableViewItem .AddToWishListButtonLinkButton, .ProductListTableViewItem .AddToCompareListButtonLinkButton, .ProductListTableViewItem .TellFriendLinkButton\n" +
            "{\n" +
            "    margin: 2px 0 0;\n" +
            "    line-height: 18px;\n" +
            "    height: 18px;\n" +
            "}\n" +
            ".ProductListTableViewEmpty\n" +
            "{\n" +
            "    margin-top: 15px;\n" +
            "}\n" +
            "\n" +
            ".ProductListTableViewItem .CommonProductImagePanel .QuickViewButtonBorder\n" +
            "{\n" +
            "    top: 0;\n" +
            "    padding: 10px 0;\n" +
            "}\n" +
            ".ProductListTableViewItem .FreeShippingLabel, .ProductListTableItem .DiscountLabel, .ProductListTableViewItem .TellFriendLinkButton\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "/* ProductListTableView [Layout>Controls] End */\n" +
            "\n" +
            "/*--------------- About Product Detail Section----------------*/\n" +
            "/* Product Page Begin */\n" +
            ".Product .CommonPage\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    border: 0;\n" +
            "}\n" +
            ".Product .CommonPageTop\n" +
            "{\n" +
            "    border: 0;\n" +
            "}\n" +
            ".Product .CommonPageTopImgLeft, .Product .CommonPageTopImgRight\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".Product .CommonPageLeft\n" +
            "{\n" +
            "    background: none;\n" +
            "    display: table;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".Product .CommonPageRight\n" +
            "{\n" +
            "    background: none;\n" +
            "    padding-top: 0;\n" +
            "}\n" +
            ".Product .CommonPageBottom\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "/* Product Page End */\n" +
            "/*/////////////////  ProductDetailsResponsive Begin  /////////////////*/\n" +
            ".ProductDetailsResponsive\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    line-height: 22px;\n" +
            "}\n" +
            ".Product .CommonPageTop\n" +
            "{\n" +
            "    min-height: 20px;\n" +
            "    background: none;\n" +
            "}\n" +
            "/*---- Section 1 ----*/\n" +
            ".ProductDetailsResponsive .ProductQuickInfoName\n" +
            "{\n" +
            "    font-size: 18px;\n" +
            "    font-weight: normal;\n" +
            "    color: #000;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            "\n" +
            "/*---- Section 2 ----*/\n" +
            ".ProductDetailsResponsive div.ProductDetailsResponsiveImage\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    min-height: 370px;\n" +
            "    padding: 0;\n" +
            "    margin: 0 auto 10px;\n" +
            "}\n" +
            ".ProductDetailsResponsive table.ProductDetailsResponsiveImage\n" +
            "{\n" +
            "    width: inherit;\n" +
            "    height: 370px;\n" +
            "    text-align: center;\n" +
            "    padding: 0;\n" +
            "}\n" +
            ".ProductDetailsResponsive .ProductDetailsResponsiveImage tr td\n" +
            "{\n" +
            "    vertical-align: middle;\n" +
            "    border: solid 1px #e7e7e7;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ProductDetailsResponsive .ProductDetailsResponsiveImage a\n" +
            "{\n" +
            "    display: block;\n" +
            "    margin: auto;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ProductDetailsResponsive .ProductDetailsResponsiveImage img\n" +
            "{\n" +
            "    max-width: none;\n" +
            "}\n" +
            ".ProductDetailsResponsive .ProductDetailsResponsiveImagePanel\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    height: 370px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ProductDetailsResponsive .CommonCategoryImage tr td\n" +
            "{\n" +
            "    border: 1px solid #E7E7E7;\n" +
            "    padding: 2px;\n" +
            "}\n" +
            "\n" +
            ".ProductDetailsResponsiveImageThumbnail\n" +
            "{\n" +
            "    width: 104%;\n" +
            "}\n" +
            ".ProductDetailsResponsiveImageThumbnail .ImageThumbnailItemStyle\n" +
            "{\n" +
            "    display: inline-block;\n" +
            "    margin: 10px 3% 10px 0;\n" +
            "    vertical-align: top;\n" +
            "    width: 21%;\n" +
            "    min-height: 80px;\n" +
            "}\n" +
            ".ProductDetailsResponsiveImageThumbnail table.CommonCategoryImage\n" +
            "{\n" +
            "    height: 80px;\n" +
            "    width: 100%;\n" +
            "}\n" +
            "\n" +
            "/*---- Section 3 ----*/\n" +
            ".ProductQuickInfoShortDescription\n" +
            "{\n" +
            "    font-size: 14px;\n" +
            "    color: black;\n" +
            "}\n" +
            ".ProductQuickInfoSku\n" +
            "{\n" +
            "    width: 30%;\n" +
            "    margin-right: 3%;\n" +
            "    display: inline-block;\n" +
            "    color: #66767b;\n" +
            "    float: left;\n" +
            "    width: 32%;\n" +
            "    display: inline-block;\n" +
            "}\n" +
            ".ProductQuickInfoStock\n" +
            "{\n" +
            "    width: 32%;\n" +
            "    margin-right: 3%;\n" +
            "    display: inline-block;\n" +
            "}\n" +
            ".ProductDetailsResponsiveRemainQuantityParagraphDetail\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".ProductQuickInfoRating\n" +
            "{\n" +
            "    width: 20%;\n" +
            "    margin-right: 3%;\n" +
            "    display: inline-block;\n" +
            "}\n" +
            ".ProductQuickInfoRating .RatingCustomerRatingControlDiv\n" +
            "{\n" +
            "    display: inline-block;\n" +
            "    float: left;\n" +
            "    margin-top: 7px;\n" +
            "}\n" +
            ".ProductQuickInfoRating .RatingCustomerMessageDiv\n" +
            "{\n" +
            "    display: inline-block;\n" +
            "    font-size: 14px;\n" +
            "    margin-left: 5px;\n" +
            "}\n" +
            ".StarRating\n" +
            "{\n" +
            "    min-width: 150px;\n" +
            "    margin-top: 19px;\n" +
            "}\n" +
            ".ProductQuickInfoRmaPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            ".ProductDetailsResponsive .FreeShippingLabel\n" +
            "{\n" +
            "    color: #1e1e1e;\n" +
            "    font-size: 14px;\n" +
            "    text-transform: uppercase;\n" +
            "    line-height: 30px;\n" +
            "    height: 30px;\n" +
            "    border: solid 1px #e7e7e7;\n" +
            "    display: inline-block;\n" +
            "    margin-right: 5%;\n" +
            "    padding: 0 10px 0 40px;\n" +
            "    font-weight: normal;\n" +
            "    background-color: #f9fbfd;\n" +
            "}\n" +
            ".ProductDetailsResponsive .QuantityDiscountPanel\n" +
            "{\n" +
            "    color: #1e1e1e;\n" +
            "    text-transform: uppercase;\n" +
            "    line-height: 30px;\n" +
            "    display: inline-block;\n" +
            "    float: left;\n" +
            "    margin-top: 15px;\n" +
            "}\n" +
            ".ProductDetailsResponsive .QuantityDiscountTop\n" +
            "{\n" +
            "    font-size: 14px;\n" +
            "    height: 30px;\n" +
            "    border: solid 1px #e7e7e7;\n" +
            "    padding: 0 3px 0 5px;\n" +
            "    font-weight: normal;\n" +
            "    background-color: #f9fbfd;\n" +
            "}\n" +
            ".ProductDetailsResponsive .QuantityDiscountRight\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "    display: block;\n" +
            "    width: 150%;\n" +
            "}\n" +
            ".ProductDetailsResponsive .DiscountLabel\n" +
            "{\n" +
            "    color: #1e1e1e;\n" +
            "    font-size: 14px;\n" +
            "    font-weight: normal;\n" +
            "    text-transform: uppercase;\n" +
            "    line-height: 30px;\n" +
            "    height: 30px;\n" +
            "    padding: 0 0px 0 25px;\n" +
            "    margin-top: 0;\n" +
            "}\n" +
            ".ProductDetailsResponsive .PercentLabel\n" +
            "{\n" +
            "    color: #ff3737;\n" +
            "    margin-left: 0px;\n" +
            "}\n" +
            ".QuantityDiscountFreeShippingDiv\n" +
            "{\n" +
            "    clear: both;\n" +
            "}\n" +
            ".ProductQuickInfoPrice\n" +
            "{\n" +
            "    clear: both;\n" +
            "}\n" +
            ".CustomerReviewsItemByColumn\n" +
            "{\n" +
            "    font-size: 13px;\n" +
            "    color: #707f84;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".CustomerReviewsDataList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".CustomerReviewsItemTable\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".CustomerReviewsByValue\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-right: 10px;\n" +
            "}\n" +
            ".RelatedProductsDetailsColumn, .RelatedProductsImageColumn\n" +
            "{\n" +
            "    padding-bottom: 40px;\n" +
            "}\n" +
            ".RatingCustomerBaseOnAmountLabel\n" +
            "{\n" +
            "    color: #ff7200;\n" +
            "}\n" +
            ".CustomerReviewsItemBodyColumn\n" +
            "{\n" +
            "    padding-bottom: 10px;\n" +
            "}\n" +
            ".ProductQuickInfoPriceTitle\n" +
            "{\n" +
            "    color: #1e1e1e;\n" +
            "}\n" +
            ".ProductDetailsResponsiveOurPrice\n" +
            "{\n" +
            "    color: #ff7200;\n" +
            "    font-size: 25px;\n" +
            "    font-weight: lighter;\n" +
            "    padding-top: 7px !important;\n" +
            "}\n" +
            ".ProductDetailsResponsiveRetailPrice\n" +
            "{\n" +
            "}\n" +
            ".ProductDetailsResponsiveRetailPrice .RetailPriceValue\n" +
            "{\n" +
            "    color: #66767b;\n" +
            "    font-size: 18px;\n" +
            "    font-weight: lighter;\n" +
            "    padding-top: 7px !important;\n" +
            "    margin-right: 20px;\n" +
            "}\n" +
            ".ProductDetailsResponsive .DiscountPercent\n" +
            "{\n" +
            "    padding-top: 5px !important;\n" +
            "}\n" +
            ".ProductDetailsResponsive .DiscountPercent .PercentLabel\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    font-size: 18px;\n" +
            "}\n" +
            ".ProductDetailsResponsive .DiscountPercent .PercentValue\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    font-size: 18px;\n" +
            "}\n" +
            "\n" +
            ".ProductDetailsResponsiveRecurringDiv\n" +
            "{\n" +
            "}\n" +
            ".ProductDetailsResponsiveRecurringAmountEveryPanel\n" +
            "{\n" +
            "}\n" +
            "\n" +
            ".ProductDetailsResponsive .ProductDetailsResponsiveOptionDiv\n" +
            "{\n" +
            "    margin-top: 20px;\n" +
            "    margin-bottom: 20px;\n" +
            "}\n" +
            ".ProductDetailsResponsive .QuantityDiscountGridViewHeaderStyle th\n" +
            "{\n" +
            "    border: 1px solid #DDDDDD;\n" +
            "    background-color: #f1f1f1;\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            ".ProductDetailsResponsive .QuantityDiscountGridView td\n" +
            "{\n" +
            "    border: 1px solid #DDDDDD;\n" +
            "    text-align: center;\n" +
            "    line-height: 25px;\n" +
            "}\n" +
            ".QuantityDiscountGridView\n" +
            "{\n" +
            "    background-color: #fff;\n" +
            "    width: 100%;\n" +
            "    font-size: 14px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".QuantityDiscountShowLinkImage\n" +
            "{\n" +
            "    opacity: 0;\n" +
            "}\n" +
            ".ProductDetailsResponsive .QuantityDiscountHideLink img\n" +
            "{\n" +
            "    opacity: 0;\n" +
            "}\n" +
            ".ProductDetailsResponsive .QuantityDiscountHideLink\n" +
            "{\n" +
            "    height: 30px;\n" +
            "    display: block;\n" +
            "    position: absolute;\n" +
            "}\n" +
            ".ProductDetailsResponsive .QuantityDiscountShowLink\n" +
            "{\n" +
            "    height: 30px;\n" +
            "    display: block;\n" +
            "    position: absolute;\n" +
            "}\n" +
            ".ProductDetailsResponsive .QuantityDiscountHideLink img, .ProductDetailsResponsive .QuantityDiscountShowLink img\n" +
            "{\n" +
            "    height: 25px;\n" +
            "}\n" +
            ".Product .AddToWishListButtonLinkButton, .Product .AddToCompareListButtonLinkButton, .Product .TellFriendLinkButton, .Promotion .TellFriendLinkButton\n" +
            "{\n" +
            "    border-right: solid 1px #eee;\n" +
            "    display: inline-block;\n" +
            "    margin: 5px 0 5px 5%;\n" +
            "    padding: 0 5% 0 25px;\n" +
            "    width: auto;\n" +
            "}\n" +
            ".ProductDetailsResponsive .ButtonDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    border-top: solid 1px #ddd;\n" +
            "    border-bottom: solid 1px #ddd;\n" +
            "    padding: 5px 0;\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            ".ProductDetailsResponsiveCustomPriceDiv\n" +
            "{\n" +
            "}\n" +
            ".ProductDetailsResponsiveCustomPriceLabel\n" +
            "{\n" +
            "}\n" +
            ".ProductDetailsResponsiveCustomPriceTextbox\n" +
            "{\n" +
            "}\n" +
            ".ProductDetailsResponsive .CustomPriceNote\n" +
            "{\n" +
            "}\n" +
            ".ProductDetailsResponsive .CustomPriceRequiredNote\n" +
            "{\n" +
            "}\n" +
            "\n" +
            ".ProductDetailsResponsiveQuantitySpan\n" +
            "{\n" +
            "    color: #1e1e1e;\n" +
            "    font-weight: lighter;\n" +
            "    float: left;\n" +
            "    margin-top: 7px;\n" +
            "    margin-right: 7px;\n" +
            "}\n" +
            ".ProductDetailsResponsiveQuantityText\n" +
            "{\n" +
            "}\n" +
            "\n" +
            ".ProductDetailsResponsiveValidatorTextOutOfStock\n" +
            "{\n" +
            "}\n" +
            "\n" +
            ".ProductDetailsResponsiveAddToCart .BtnStyle1\n" +
            "{\n" +
            "    background: #ff7200;\n" +
            "    padding: 7px 25px 7px 25px;\n" +
            "    font-size: 18px;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".ProductDetailsResponsiveAddToCart .BtnStyle1:hover\n" +
            "{\n" +
            "    background-color: #000;\n" +
            "}\n" +
            "\n" +
            ".ProductDetailsResponsiveSocialButtonDiv\n" +
            "{\n" +
            "}\n" +
            ".ProductDetailsResponsiveSocialButtonDiv .TellFriendLinkButton\n" +
            "{\n" +
            "}\n" +
            ".ProductDetailsResponsiveSocialButtonDiv .SocialButton\n" +
            "{\n" +
            "}\n" +
            ".ProductDetailsResponsiveSocialButtonDiv .AddThisButton\n" +
            "{\n" +
            "}\n" +
            "\n" +
            ".ProductDetailsResponsiveDescriptionDiv\n" +
            "{\n" +
            "}\n" +
            ".ProductDetailsResponsiveDescriptionDivTitle\n" +
            "{\n" +
            "}\n" +
            ".ProductDetailsResponsiveDescription\n" +
            "{\n" +
            "}\n" +
            ".ProductDetailsResponsive .pdetail-sec-four .BtnStyle1\n" +
            "{\n" +
            "    background: url(\"Images/Icon/icon-review.gif\") no-repeat scroll 5px center transparent;\n" +
            "    padding-left: 30px;\n" +
            "    color: #1e1e1e;\n" +
            "    font-size: 13px;\n" +
            "    text-shadow: none;\n" +
            "}\n" +
            ".ProductDetailsResponsive .pdetail-sec-four .StarRatingSummaryButtonColumn\n" +
            "{\n" +
            "    float: right;\n" +
            "    position: relative;\n" +
            "    bottom: 260%;\n" +
            "    margin-bottom: 30px;\n" +
            "}\n" +
            ".ProductDetailsResponsive .ProductDetailsButtom\n" +
            "{\n" +
            "    margin-top: 30px;\n" +
            "}\n" +
            ".ProductDetailsResponsive .RelatedProductsTitleRight\n" +
            "{\n" +
            "    font-size: 18px;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    text-transform: uppercase;\n" +
            "    border-bottom: #DDDDDD solid 1px;\n" +
            "    padding-bottom: 14px;\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            ".ProductDetailsResponsive .RelatedProductsTopTitle\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".RelatedProductsDetailsNameDiv a\n" +
            "{\n" +
            "    color: #1e1e1e !important;\n" +
            "}\n" +
            ".RelatedProductsDetailStockDiv\n" +
            "{\n" +
            "    color: Red;\n" +
            "}\n" +
            ".RelatedProductsDatalist\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".RelatedProductsItemTable\n" +
            "{\n" +
            "    margin-bottom: 20px;\n" +
            "    margin-top: 20px;\n" +
            "    border-bottom: 2px #ddd dotted;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ProductDetailsResponsive .RelatedProductsDetailsPriceDiv\n" +
            "{\n" +
            "    color: #ff7200;\n" +
            "    font-size: 18px;\n" +
            "    font-weight: lighter;\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            ".ProductDetailsResponsive .StarRatingSummaryTable, .StarRatingSummaryTableInner\n" +
            "{\n" +
            "    width: 101%;\n" +
            "}\n" +
            ".StarRatingSummaryTableInnerOurStarColumn\n" +
            "{\n" +
            "    width: 18%;\n" +
            "}\n" +
            ".ProductDetailsResponsive .StarRatingSummaryTable tr\n" +
            "{\n" +
            "    display: table-cell;\n" +
            "}\n" +
            ".ProductDetailsResponsive .StarRatingSummaryTable .StarRatingSummaryTableInner tr\n" +
            "{\n" +
            "    display: table-row;\n" +
            "}\n";
    static String css21 =
            ".RatingCustomerMessageDiv\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".StarRatingSummaryTableInnerOurLabelColumn\n" +
            "{\n" +
            "    float: left;\n" +
            "    padding: 0 15px;\n" +
            "}\n" +
            ".CustomerReviewsTop\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".ProductDetailsResponsive .StarRatingSummaryTableInnerCustomerLabelColumn\n" +
            "{\n" +
            "    padding: 5px 15px;\n" +
            "}\n" +
            ".ProductDetailsResponsive .RatingCustomerBaseOnAmountLabel\n" +
            "{\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            ".RelatedProductsDetailsColumn\n" +
            "{\n" +
            "    margin-bottom: 50px;\n" +
            "}\n" +
            ".ProductQuickInfoPrice\n" +
            "{\n" +
            "    clear: both;\n" +
            "}\n" +
            ".CustomerReviewsItemByColumn, .CustomerReviewsDate\n" +
            "{\n" +
            "    font-size: 13px;\n" +
            "    color: #707f84;\n" +
            "    float: left;\n" +
            "}\n" +
            ".CustomerReviewsItemTable, .CustomerReviewsDataList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    margin-bottom: 20px;\n" +
            "    margin-top: 20px;\n" +
            "}\n" +
            ".CustomerReviewsByLabel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "}\n" +
            ".CustomerReviewsSubject\n" +
            "{\n" +
            "    font-weight: bold;\n" +
            "    margin-bottom: 10px;\n" +
            "    margin-top: 10px;\n" +
            "    font-size: 14px;\n" +
            "}\n" +
            ".CustomerReviewsItemStyle\n" +
            "{\n" +
            "    border-bottom: 1px dotted #ededed;\n" +
            "}\n" +
            ".ProductDetailsResponsiveRatingSummary\n" +
            "{\n" +
            "    border-bottom: 1px dotted #ededed;\n" +
            "}\n" +
            ".ProductDetailsResponsiveQuantityDiv\n" +
            "{\n" +
            "}\n" +
            ".ProductDetailsResponsiveAddToCart\n" +
            "{\n" +
            "    float: left;\n" +
            "}\n" +
            ".ajax__tab_body\n" +
            "{\n" +
            "    color: #1e1e1e;\n" +
            "}\n" +
            ".ProductDetailsResponsive .ProductSpecificationItemList .SpecItemName\n" +
            "{\n" +
            "    clear: both;\n" +
            "    float: left;\n" +
            "    width: 40%;\n" +
            "    padding: 5px;\n" +
            "    border-bottom: dashed 1px #e5e5e5;\n" +
            "    color: #2d2d2d;\n" +
            "    font-weight: lighter;\n" +
            "}\n" +
            ".ProductDetailsResponsive .ProductSpecificationItemList .SpecItemValue\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 55%;\n" +
            "    padding: 5px;\n" +
            "    color: #2d2d2d;\n" +
            "    border-bottom: dashed 1px #e5e5e5;\n" +
            "    font-weight: lighter;\n" +
            "}\n" +
            ".ProductDetailsResponsive .ProductDetailsResponsiveDescriptionDivTitle\n" +
            "{\n" +
            "    clear: both;\n" +
            "    font-size: 14px;\n" +
            "    line-height: 30px;\n" +
            "    font-weight: bold;\n" +
            "    margin-bottom: 10px;\n" +
            "    border: 0;\n" +
            "    color: #2d2d2d;\n" +
            "    border-bottom: solid 1px #e5e5e5;\n" +
            "    border-top: solid 1px #e5e5e5;\n" +
            "    padding: 5px;\n" +
            "}\n" +
            ".ProductDetailsResponsive .ProductDetailsDefaulSpecificationDetailsDiv\n" +
            "{\n" +
            "    margin-bottom: 40px;\n" +
            "}\n" +
            ".OptionGroupDetailsTitleLeft\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".ProductDetailsResponsive .WriteReviewDiv .CommonHyperLink\n" +
            "{\n" +
            "    background: url(\"Images/Icon/icon-review.gif\") no-repeat scroll 5px center transparent;\n" +
            "    padding-left: 30px;\n" +
            "}\n" +
            ".ProductDetailsResponsiveDescriptionLongDiv, .CustomerReviewsItemBodyColumn\n" +
            "{\n" +
            "    font-size: 14px;\n" +
            "}\n" +
            ".ProductDetailsResponsiveSku\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".Product .TellFriendLinkButton\n" +
            "{\n" +
            "    border-right: 0px;\n" +
            "}\n" +
            ".ButtonDiv\n" +
            "{\n" +
            "    margin-top: 40px !important;\n" +
            "    border-bottom: 1px solid #ededed;\n" +
            "    border-top: 1px solid #ededed;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin-bottom: 10px;\n" +
            "    padding: 10px 0;\n" +
            "}\n" +
            ".ProductDetailsResponsive .CommonTextBox\n" +
            "{\n" +
            "    width: 13% !important;\n" +
            "    padding: 10px;\n" +
            "    height: 40px;\n" +
            "    color: #66767b;\n" +
            "    text-align: center;\n" +
            "    font-size: 18px;\n" +
            "    float: left;\n" +
            "    margin: 5px;\n" +
            "    margin-top: 0px;\n" +
            "    margin-right: 10px;\n" +
            "}\n" +
            "\n" +
            "/*ProductDetailsResponsive End*/\n" +
            "/*OptionGroupDetails Begin*/\n" +
            ".OptionGroupDetailsTitleRight span\n" +
            "{\n" +
            "    color: #000;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            "/*OptionGroupDetails End*/\n" +
            "/*OptionItemDetails Begin*/\n" +
            ".OptionItemDetails\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            ".OptionItemDetailsTop\n" +
            "{\n" +
            "    font-weight: lighter;\n" +
            "    color: #000;\n" +
            "    font-size: 14px;\n" +
            "    display: inline-block;\n" +
            "    float: left;\n" +
            "    margin: 10px 10px 10px 0px !important;\n" +
            "}\n" +
            ".OptionItemDetailsLeft\n" +
            "{\n" +
            "    margin: 10px 5px 10px 10px !important;\n" +
            "    float: left;\n" +
            "    clear: right;\n" +
            "    display: inline-block;\n" +
            "    width: 80%;\n" +
            "}\n" +
            ".OptionTextItem .OptionTextItemTable\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".OptionRadioItemRadioButtonList tr\n" +
            "{\n" +
            "    display: table-cell;\n" +
            "    float: left;\n" +
            "    width: 47%;\n" +
            "    margin-right: 3%;\n" +
            "}\n" +
            ".OptionItemDetailsErrorMessage\n" +
            "{\n" +
            "    color: #ff0000;\n" +
            "}\n" +
            "/*OptionItemDetails End*/\n" +
            "/*OptionRadioItem Begin*/\n" +
            ".OptionRadioItemDiv\n" +
            "{\n" +
            "    margin-top: -10px;\n" +
            "    margin-left: 23px;\n" +
            "}\n" +
            ".OptionRadioItemRadioButtonList td\n" +
            "{\n" +
            "    position: relative;\n" +
            "    height: 25px;\n" +
            "    width: 1%;\n" +
            "}\n" +
            ".OptionRadioItemRadioButtonList input\n" +
            "{\n" +
            "    float: left;\n" +
            "}\n" +
            ".OptionRadioItemRadioButtonList label\n" +
            "{\n" +
            "    position: relative;\n" +
            "    float: left;\n" +
            "    margin-top: 1px;\n" +
            "    margin-left: 1px;\n" +
            "    margin-right: 10px;\n" +
            "}\n" +
            ".OptionRadioItemRadioButtonList label span.OptionItemName\n" +
            "{\n" +
            "    color: #000;\n" +
            "    font-size: 13px;\n" +
            "    font-weight: lighter;\n" +
            "}\n" +
            ".OptionRadioItemRadioButtonList label img.OptionImg\n" +
            "{\n" +
            "    width: 18px;\n" +
            "    left: -40px;\n" +
            "    top: 1px;\n" +
            "    position: absolute;\n" +
            "    max-width: 18px;\n" +
            "    border-radius: 20px;\n" +
            "}\n" +
            ".OptionRadioItemRadioButtonList label span.OptionPrice\n" +
            "{\n" +
            "    color: #ff7200;\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            "/*OptionRadioItem End*/\n" +
            "/*OptionTextItem Begin*/\n" +
            ".OptionTextItem\n" +
            "{\n" +
            "    position: relative;\n" +
            "}\n" +
            ".OptionTextItemCheckDiv\n" +
            "{\n" +
            "    margin-left: 23px;\n" +
            "    position: relative;\n" +
            "}\n" +
            ".OptionTextItemCheckDiv\n" +
            "{\n" +
            "    float: left;\n" +
            "}\n" +
            ".OptionTextItemCheckDiv span.OptionItemName\n" +
            "{\n" +
            "    position: absolute;\n" +
            "    left: 30px;\n" +
            "    top: 1px;\n" +
            "}\n" +
            ".OptionTextItemCheckDiv span img.OptionImg\n" +
            "{\n" +
            "    border: solid 1px #D2D1D1;\n" +
            "    width: 6px;\n" +
            "    left: -20px;\n" +
            "    top: 3px;\n" +
            "    position: absolute;\n" +
            "}\n" +
            ".OptionTextItemTable span.OptionItemName\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    color: #bbb;\n" +
            "}\n" +
            ".OptionTextItemTable span.OptionPrice\n" +
            "{\n" +
            "    float: right;\n" +
            "    margin-left: 45px;\n" +
            "}\n" +
            ".OptionTextItemText\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    margin-left: 20px;\n" +
            "}\n" +
            ".OptionItemDetailsLeft\n" +
            "{\n" +
            "    width: inherit;\n" +
            "}\n" +
            ".OptionGroupDetailsDataListItemStyle\n" +
            "{\n" +
            "    width: 80%;\n" +
            "}\n" +
            "/*OptionTextItem End*/\n" +
            "/*OptionInputListItem Begin*/\n" +
            ".OptionInputListItemDataListItemStyle\n" +
            "{\n" +
            "    padding-bottom: 2px;\n" +
            "}\n" +
            ".OptionInputListItemDataListItemDiv\n" +
            "{\n" +
            "    position: relative;\n" +
            "    margin-left: 23px;\n" +
            "}\n" +
            ".OptionInputListItemDataListItemDiv input\n" +
            "{\n" +
            "    border: solid 1px #ccc;\n" +
            "}\n" +
            ".OptionInputListItemDataListItemDiv span.OptionItemName\n" +
            "{\n" +
            "    font-weight: lighter;\n" +
            "    color: #000;\n" +
            "}\n" +
            ".OptionPrice\n" +
            "{\n" +
            "    color: #ff7200;\n" +
            "}\n" +
            ".OptionInputListItemDataListItemDiv span img.OptionImg\n" +
            "{\n" +
            "    border: solid 1px #D2D1D1;\n" +
            "    position: absolute;\n" +
            "    width: 6px;\n" +
            "    top: 4px;\n" +
            "    left: -20px;\n" +
            "}\n" +
            "/*OptionInputListItem End*/\n" +
            "/*OptionUploadItem Begin*/\n" +
            "\n" +
            ".OptionUploadItemFileUploadDiv\n" +
            "{\n" +
            "    color: Orange;\n" +
            "}\n" +
            "\n" +
            ".OptionUploadItem .OptionUploadItemUploadLabel\n" +
            "{\n" +
            "    position: relative;\n" +
            "    margin-left: 23px;\n" +
            "    padding-bottom: 1px;\n" +
            "}\n" +
            ".OptionUploadItem .OptionUploadItemUploadLabel .OptionImg\n" +
            "{\n" +
            "    position: absolute;\n" +
            "    left: -20px;\n" +
            "    top: 3px;\n" +
            "    width: 6px;\n" +
            "    border: solid 1px #D2D1D1;\n" +
            "}\n" +
            ".OptionUploadItemFileUploadWidth\n" +
            "{\n" +
            "    width: 210px;\n" +
            "}\n" +
            "/*OptionUploadItem End*/\n" +
            "/*OptionUploadRequireItem Begin*/\n" +
            ".OptionUploadRequireItem .OptionUploadRequireItemUploadRQLabel\n" +
            "{\n" +
            "    position: relative;\n" +
            "    margin-left: 23px;\n" +
            "    padding-bottom: 1px;\n" +
            "}\n" +
            ".OptionUploadRequireItemUploadRQLabel .OptionImg\n" +
            "{\n" +
            "    position: absolute;\n" +
            "    left: -20px;\n" +
            "    top: 3px;\n" +
            "    width: 6px;\n" +
            "    border: solid 1px #D2D1D1;\n" +
            "}\n" +
            ".OptionUploadRequireItemFileUploadWidth\n" +
            "{\n" +
            "    width: 210px;\n" +
            "}\n" +
            "/*OptionUploadRequireItem End*/\n" +
            "\n" +
            "\n" +
            ".PrimaryColor\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".SecondaryColor\n" +
            "{\n" +
            "    color: #2a353c;\n" +
            "}\n" +
            "\n" +
            ".IntroductionMessagePanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    display: inline-block;\n" +
            "    margin-bottom: 40px;\n" +
            "}\n" +
            ".IntroductionMessagePanel .CenterBlockTop\n" +
            "{\n" +
            "    border-bottom: 0;\n" +
            "}\n" +
            ".IntroductionMessagePanel .CenterBlockTopTitle.SecondaryColor\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".IntroductionMessagePanel .CenterBlockTopTitle\n" +
            "{\n" +
            "    color: #000;\n" +
            "}\n" +
            ".IntroductionMessage\n" +
            "{\n" +
            "    font-size: 14px;\n" +
            "    line-height: 25px;\n" +
            "    text-align: justify;\n" +
            "}\n" +
            "\n" +
            "\n" +
            "\n" +
            "/*LikeBoxWidget Begin*/\n" +
            ".LikeBoxWidget iframe\n" +
            "{\n" +
            "    width: 188px !important;\n" +
            "}\n" +
            "/*LikeBoxWidget End*/\n" +
            "/*AddThis Begin*/\n" +
            ".AddThisWidget\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    display: table;\n" +
            "    text-align: center;\n" +
            "    clear: both;\n" +
            "}\n" +
            "/*AddThis End*/\n" +
            "/*PaymentLogo Begin*/\n" +
            ".PaymentLogo\n" +
            "{\n" +
            "    float: left;\n" +
            "    clear: right;\n" +
            "    margin-top: 15px;\n" +
            "}\n" +
            "/*PaymentLogo End*/\n" +
            "/*ProductSpecial Begin*/\n" +
            ".ProductSpecial .SidebarTop, .ProductSpecial .SidebarBottom\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".ProductSpecial .SidebarLeft\n" +
            "{\n" +
            "    font-size: 10px;\n" +
            "}\n" +
            ".ProductSpecial .SidebarRight\n" +
            "{\n" +
            "    padding: 0;\n" +
            "    border: solid 1px #ddd;\n" +
            "    background-color: #fff;\n" +
            "}\n" +
            ".ProductSpecialLabelPanel\n" +
            "{\n" +
            "    width: 60px;\n" +
            "    height: 60px;\n" +
            "    background: url(Images/Icon/icon-special.png) no-repeat left top;\n" +
            "    position: absolute;\n" +
            "    z-index: 100;\n" +
            "}\n" +
            ".ProductSpecial .ProductSpecialImage\n" +
            "{\n" +
            "    margin: auto;\n" +
            "}\n" +
            "\n" +
            ".ProductSpecial .ProductSpecialImage a\n" +
            "{\n" +
            "    height: 260px;\n" +
            "    width: 170px;\n" +
            "}\n" +
            "\n" +
            ".ProductSpecial .ProductSpecialImage a img\n" +
            "{\n" +
            "    margin-top: 5px;\n" +
            "    display: block;\n" +
            "    max-width: 170px;\n" +
            "    width: auto !important;\n" +
            "    width: 170px;\n" +
            "}\n" +
            "\n" +
            "/*ProductSpecial End*/\n" +
            "/*VerifyCoupon Begin*/\n" +
            "\n" +
            ".VerifyCouponTextBox\n" +
            "{\n" +
            "    z-index: 1;\n" +
            "    width: 60% !important;\n" +
            "    border: solid 1px #d0d0d0;\n" +
            "    border-right: 0;\n" +
            "    height: 18px;\n" +
            "    float: left;\n" +
            "}\n" +
            "/*VerifyCoupon End*/\n" +
            "/*FeaturedMerchants Begin*/\n" +
            ".FeaturedMerchantsAd\n" +
            "{\n" +
            "    margin-bottom: 3px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".FeaturedMerchantsAd img\n" +
            "{\n" +
            "    max-width: 188px;\n" +
            "    width: auto !important;\n" +
            "    width: 188px;\n" +
            "}\n" +
            "/*FeaturedMerchants End*/\n" +
            "/*FindGiftRegistry Begin*/\n" +
            "\n" +
            ".FindGiftRegistryDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "}\n" +
            ".FindGiftRegistryCreateLink\n" +
            "{\n" +
            "    background: url(Images/Icon/icon-gift.gif) no-repeat left center;\n" +
            "}\n" +
            ".FindGiftRegistryFindLink\n" +
            "{\n" +
            "    background: url(Images/Icon/icon-search.gif) no-repeat left center;\n" +
            "}\n" +
            ".FindGiftRegistryDiv a\n" +
            "{\n" +
            "    padding: 4px 5px 4px 25px;\n" +
            "    vertical-align: middle;\n" +
            "    display: block;\n" +
            "    color: #000;\n" +
            "    text-decoration: none;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin-bottom: 8px;\n" +
            "}\n" +
            ".FindGiftRegistryDiv a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            "\n" +
            "/*FindGiftRegistry End*/\n" +
            "/*JoinAffiliate Begin*/\n" +
            ".JoinAffiliate .SidebarRight img\n" +
            "{\n" +
            "    max-width: 192px;\n" +
            "    width: auto !important;\n" +
            "    width: 192px;\n" +
            "}\n" +
            "/*JoinAffiliate End*/\n" +
            "\n" +
            "/*Facebook CategoryList Begin*/\n" +
            ".CategoryListPageItemControl\n" +
            "{\n" +
            "    padding-bottom: 20px;\n" +
            "}\n" +
            ".CategoryListItemPerPage\n" +
            "{\n" +
            "    width: 30px;\n" +
            "    height: 20px;\n" +
            "    float: right;\n" +
            "    text-align: right;\n" +
            "    margin-left: 10px;\n" +
            "}\n" +
            ".CategoryListPagingControl\n" +
            "{\n" +
            "    text-align: right;\n" +
            "    float: right;\n" +
            "    margin-top: 3px;\n" +
            "}\n" +
            ".CategoryListDataList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".CategoryListDataListHeader\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            "/*Facebook CategoryList End*/\n" +
            "/*CategoryListItem Begin*/\n" +
            ".CategoryListItemTable\n" +
            "{\n" +
            "    margin-left: auto;\n" +
            "    margin-right: auto;\n" +
            "}\n" +
            ".CategoryListItemImage\n" +
            "{\n" +
            "    height: 150px;\n" +
            "    background-color: #fff;\n" +
            "    border: solid 1px #E5E5E5;\n" +
            "    padding: 5px;\n" +
            "}\n" +
            ".CategoryListItemImageDiv\n" +
            "{\n" +
            "    width: 150px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".CategoryListItemNameDiv\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            ".CategoryListItemNameDiv a\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    text-decoration: underline;\n" +
            "}\n" +
            ".CategoryListItemNameDiv a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            "/*CategoryListItem End*/\n" +
            "/*CategoryListItemDefault [Layout>Controls] Begin*/\n" +
            ".CategoryListItemDefaultTable\n" +
            "{\n" +
            "    margin: 0 auto;\n" +
            "    width: 150px;\n" +
            "}\n" +
            ".CategoryListItemDefaultImageColumn\n" +
            "{\n" +
            "    height: 150px;\n" +
            "    background-color: #fff;\n" +
            "    border: solid 1px #E5E5E5;\n" +
            "    padding: 5px;\n" +
            "}\n" +
            ".CategoryListItemDefaultImageDiv\n" +
            "{\n" +
            "    width: 150px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".CategoryListItemDefaultNameDiv\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            ".CategoryListItemDefaultNameDiv a\n" +
            "{\n" +
            "    color: #000;\n" +
            "    font-size: 10px;\n" +
            "    font-weight: normal;\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            ".CategoryListItemDefaultNameDiv a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".CategoryListItem1DescriptionDiv\n" +
            "{\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            ".CategoryListItemDefaultDescriptionColumn\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "/*CategoryListItemDefault [Layout>Controls] End*/\n" +
            "/*Manufacturer Begin*/\n" +
            ".Manufacturer .CategoryListDefault .ManufacturerControlPanel\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    margin: 0;\n" +
            "}\n" +
            ".ManufacturerDropDownList\n" +
            "{\n" +
            "    margin: 10px auto;\n" +
            "}\n" +
            ".ManufacturerNavList .SidebarRight\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            "/*Manufacturer End*/\n" +
            "/*ManufacturerTab Begin*/\n" +
            ".ManufacturerTabItemDefaultTable\n" +
            "{\n" +
            "    margin: 0 auto;\n" +
            "}\n" +
            ".ManufacturerTabDefaultDataList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ManufacturerTabItemDefaultImageColumn\n" +
            "{\n" +
            "    height: 24%;\n" +
            "    background-color: #fff;\n" +
            "    padding: 10px;\n" +
            "}\n" +
            ".ManufacturerTabItemDefaultImageDiv\n" +
            "{\n" +
            "    width: 24%;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ManufacturerTabItemDefaultImageDiv img\n" +
            "{\n" +
            "    height: auto !important;\n" +
            "    max-height: 130px;\n" +
            "    max-width: 140px;\n" +
            "    width: auto !important;\n" +
            "}\n" +
            "/*ManufacturerTab End*/\n" +
            "/*ManufacturerList [Layout] Begin*/\n" +
            ".ManufacturerListItemDefaultTable\n" +
            "{\n" +
            "    margin: 0 auto;\n" +
            "    width: 150px;\n" +
            "}\n" +
            ".ManufacturerListDefaultDataList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    clear: left;\n" +
            "}\n" +
            ".ManufacturerListDefaultDataListHeader\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            "/*ManufacturerList [Layout] End*/\n" +
            "/*ManufacturerList [Layout>Controls] Begin*/\n" +
            ".ManufacturerListItemDefaultImageColumn\n" +
            "{\n" +
            "    height: 140px;\n" +
            "    background-color: #fff;\n" +
            "    border: solid 1px #E5E5E5;\n" +
            "    padding: 5px;\n" +
            "}\n" +
            ".ManufacturerListItemDefaultImageDiv\n" +
            "{\n" +
            "    width: 140px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ManufacturerListItemDefaultImageDiv img\n" +
            "{\n" +
            "    height: auto !important;\n" +
            "    max-height: 130px;\n" +
            "    max-width: 140px;\n" +
            "    width: auto !important;\n" +
            "}\n" +
            ".ManufacturerListItemDefaultNameDiv\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    margin-top: 5px;\n" +
            "    margin-bottom: 15px;\n" +
            "    width: 150px;\n" +
            "}\n" +
            ".ManufacturerListItemDefaultNameDiv a\n" +
            "{\n" +
            "    color: #000;\n" +
            "    font-size: 10px;\n" +
            "    font-weight: normal;\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            ".ManufacturerListItemDefaultNameDiv a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".ManufacturerListItem1DescriptionDiv\n" +
            "{\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            ".ManufacturerListItemDefaultDescriptionColumn\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "\n" +
            "/*ManufacturerList [Layout>Controls] End*/\n" +
            "/*Promotion Begin*/\n" +
            ".Promotion .CommonPageRight\n" +
            "{\n" +
            "    padding: 15px 0 0;\n" +
            "}\n" +
            ".Promotion .ProductListDefaultDataList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".PromotionListDefault tr\n" +
            "{\n" +
            "    width: 50%;\n" +
            "    min-height: 200px;\n" +
            "}\n" +
            ".PromotionListDefault .PromotionGroupListItemTable tr\n" +
            "{\n" +
            "    display: table-row;\n" +
            "}\n" +
            ".PromotionListDefault .ProductListDefaultDataListItemStyle\n" +
            "{\n" +
            "    display: inline-block;\n" +
            "    width: 50%;\n" +
            "}\n" +
            ".Promotion .TellFriendLinkButton\n" +
            "{\n" +
            "    border: 0;\n" +
            "}\n" +
            "\n" +
            "/*Promotion End*/\n" +
            "/*Promotion Item Begin*/\n" +
            ".PromotionItem .SidebarTop\n" +
            "{\n" +
            "    background-color: #fff;\n" +
            "    border: 0;\n" +
            "}\n" +
            ".PromotionItem .SidebarTopTitle\n" +
            "{\n" +
            "    font-size: 19px;\n" +
            "}\n" +
            ".PromotionItem .SidebarRight\n" +
            "{\n" +
            "    background-color: #fff;\n" +
            "    border: 0;\n" +
            "    padding: 15px 0;\n" +
            "}\n" +
            ".PromotionItem .Content\n" +
            "{\n" +
            "    padding: 13px 0;\n" +
            "}\n" +
            ".PromotionItem .NameLabel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    color: #000;\n" +
            "    font-size: 18px;\n" +
            "    vertical-align: middle;\n" +
            "}\n" +
            ".PromotionItem .PriceLabel\n" +
            "{\n" +
            "    float: left;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    font-size: 14px;\n" +
            "    font-weight: normal;\n" +
            "    vertical-align: middle;\n" +
            "    margin-left: 20px;\n" +
            "    line-height: 22px;\n" +
            "}\n" +
            ".PromotionItem .DiscriptionLabel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    vertical-align: middle;\n" +
            "    margin: 10px 0px 15px 0px;\n" +
            "}\n" +
            ".PromotionItem .AlternatingItem\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    height: 30px;\n" +
            "    margin: 10px 0px;\n" +
            "    background: url(Images/Icon/icon-promotion-combine.png) no-repeat center center;\n" +
            "}\n" +
            "\n" +
            ".PromotionItem .AlternatingItem img\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".PromotionItem .PromotionDetailsDefaultImageAddtoCart\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "    float: right;\n" +
            "}\n" +
            ".PromotionItem .PromotionDetailsDefaultImageAddtoCart a.BtnStyle1\n" +
            "{\n" +
            "    background-color: #FF7200;\n" +
            "}\n" +
            ".PromotionItem .PromotionDetailsDefaultImageAddtoCart a.BtnStyle1:hover\n" +
            "{\n" +
            "    background-color: #000000;\n" +
            "    color: #ffffff;\n" +
            "}\n" +
            ".PromotionItem .PromotionDetailsDefaultImageTellFriendImage\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-top: 10px;\n" +
            "    width: 88%;\n" +
            "}\n" +
            ".PromotionItem .PromotionDetailsDefaultImageTellFriendImage a.BtnStyle4\n" +
            "{\n" +
            "    float: right;\n" +
            "}\n" +
            ".PromotionItem .PromotionDetailsDefaultImageTellFriendImage .BtnStyle4\n" +
            "{\n" +
            "    background-color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".PromotionItem .PromotionDetailsDefaultImageTellFriendImage .BtnStyle4:hover\n" +
            "{\n" +
            "    background-color: #000;\n" +
            "}\n" +
            ".PromotionSortString\n" +
            "{\n" +
            "    float: left;\n" +
            "    font-size: 10px;\n" +
            "}\n" +
            ".PromotionSortUpDown\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-left: 10px;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".PromotionItemPerPage\n" +
            "{\n" +
            "    float: right;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".PromotionItemPerPage .OptionControlTitle\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-left: 5px;\n" +
            "}\n" +
            ".PromotionSortString select, .PromotionItemPerPage .ItemsPerPageDrop\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin: 7px 5px 0;\n" +
            "}\n" +
            ".PromotionItem .ProductDetailsDefaultLikeButtonDiv\n" +
            "{\n" +
            "    width: 25%;\n" +
            "    padding-bottom: 10px;\n" +
            "}\n" +
            ".PromotionItem .SocialButton\n" +
            "{\n" +
            "    width: 50%;\n" +
            "    float: left;\n" +
            "}\n" +
            "/*Promotion Item End*/\n" +
            "\n" +
            "/*Promotion Product Group Begin*/\n" +
            ".PromotionProductGroup\n" +
            "{\n" +
            "    border: solid 2px #e8e8e8;\n" +
            "    padding: 15px;\n" +
            "}\n" +
            "\n" +
            ".PromotionProductGroup .MessagePanel\n" +
            "{\n" +
            "    color: Red;\n" +
            "    text-align: right;\n" +
            "    padding-top: 15px;\n" +
            "}\n" +
            ".PromotionProductGroup .ProductSelect\n" +
            "{\n" +
            "    margin-top: 3px;\n" +
            "    text-align: center;\n" +
            "    clear: left;\n" +
            "}\n" +
            ".ProductOption .BtnStyle3\n" +
            "{\n" +
            "    float: none;\n" +
            "    margin: auto;\n" +
            "    cursor: pointer;\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            "/*Promotion Product Group End*/\n" +
            "/* Promotion Product Item Begin */\n" +
            ".PromotionProductGroupDataList\n" +
            "{\n" +
            "    margin: 0;\n" +
            "}\n" +
            ".PromotionProductGroupDataList tr\n" +
            "{\n" +
            "    display: inline;\n" +
            "}\n" +
            ".PromotionProductGroupDataList tr td\n" +
            "{\n" +
            "    display: inline-block;\n" +
            "}\n" +
            "\n" +
            ".PromotionProductGroupDataList .OptionRadioItemRadioButtonList tr\n" +
            "{\n" +
            "    display: table-row;\n" +
            "    float: none;\n" +
            "}\n" +
            ".PromotionProductGroupDataList .OptionRadioItemRadioButtonList tr td\n" +
            "{\n" +
            "    display: block;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".PromotionProductGroupDataList .OptionRadioItemRadioButtonList label\n" +
            "{\n" +
            "    float: none;\n" +
            "}\n" +
            ".PromotionProductGroupDataList .ProductGroupProductItemStyle\n" +
            "{\n" +
            "    width: 145px;\n" +
            "    vertical-align: top;\n" +
            "    text-align: center;\n" +
            "    padding: 20px 0;\n" +
            "}\n" +
            ".PromotionProductGroupDataList .PromotionProductItem\n" +
            "{\n" +
            "    width: 85%;\n" +
            "    min-height: 170px;\n" +
            "    margin: 5px 7.5%;\n" +
            "    position: relative;\n" +
            "}\n" +
            ".PromotionProductGroupDataList .ProductGroupCombineItem div\n" +
            "{\n" +
            "    display: table;\n" +
            "    width: 30px;\n" +
            "    height: 180px;\n" +
            "}\n" +
            ".PromotionProductGroupDataList .ProductGroupCombineItem\n" +
            "{\n" +
            "    background: url(Images/Icon/icon-combine-item.gif) no-repeat center center;\n" +
            "    width: 30px;\n" +
            "}\n" +
            ".PromotionProductGroup .ProductGroupCombineItem img, .PromotionItem .AlternatingItem img\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".PromotionProductItem .ProductName a\n" +
            "{\n" +
            "    color: #000000;\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            ".PromotionProductItem .ProductImage\n" +
            "{\n" +
            "    width: 75px;\n" +
            "    margin-bottom: 10px;\n" +
            "    text-align: left;\n" +
            "    float: left;\n" +
            "    left: 15%;\n" +
            "    position: relative;\n" +
            "}\n" +
            ".PromotionProductItem .ProductName\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            ".PromotionProductItem .ProductQuantity\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    font-size: 14px;\n" +
            "}\n" +
            ".PromotionProductItem .ProductQuantity .ProductQuantitySign\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".PromotionProductItem .ProductPrice\n" +
            "{\n" +
            "    text-decoration: line-through;\n" +
            "    color: #a9a9a9;\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            ".PromotionProductItem .ProductOption\n" +
            "{\n" +
            "    margin-top: 3px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".PromotionProductItem .ProductSelect\n" +
            "{\n" +
            "    margin-top: 3px;\n" +
            "    text-align: center;\n" +
            "    clear: left;\n" +
            "    bottom: 0;\n" +
            "    clear: left;\n" +
            "    position: absolute;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".PromotionProductItem .OptionPopup\n" +
            "{\n" +
            "    left: 0px;\n" +
            "    top: 0px;\n" +
            "    position: fixed;\n" +
            "    z-index: 11;\n" +
            "    width: 100%;\n" +
            "    height: 100%;\n" +
            "}\n" +
            ".PromotionProductItem .OptionPanel\n" +
            "{\n" +
            "    background-color: #fff;\n" +
            "    text-align: left;\n" +
            "    padding: 20px 30px;\n" +
            "    width: 300px;\n" +
            "    height: auto;\n" +
            "    border-top: 0;\n" +
            "    -webkit-box-shadow: 0px 0px 10px 0px #555;\n" +
            "    box-shadow: 0px 0px 10px 0px #555;\n" +
            "    border-collapse: separate;\n" +
            "}\n" +
            ".PromotionProductItem .OptionButton\n" +
            "{\n" +
            "    clear: left;\n" +
            "    display: table;\n" +
            "    margin: 15px auto 0;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".PromotionProductItem .FixProductOption\n" +
            "{\n" +
            "    font-size: 11px;\n" +
            "    color: #888;\n" +
            "}\n" +
            "/*Promotion Product Item End */\n" +
            "/*PromotionGroupListItem [Layout>Controls] Begin*/\n" +
            ".PromotionGroupListItem\n" +
            "{\n" +
            "    padding: 10px 0px;\n" +
            "}\n" +
            ".PromotionGroupListItemTable\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".PromotionGroupListItemImageColumn\n" +
            "{\n" +
            "    width: 40%;\n" +
            "    vertical-align: top;\n" +
            "}\n" +
            ".PromotionGroupListItemImageDiv\n" +
            "{\n" +
            "    background-color: #fff;\n" +
            "    padding: 2px;\n" +
            "    width: 190px;\n" +
            "    margin-left: auto;\n" +
            "    margin-right: auto;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".PromotionGroupListItemImageDiv img\n" +
            "{\n" +
            "    max-height: 180px;\n" +
            "    height: auto !important;\n" +
            "    height: 180px;\n" +
            "    max-width: 180px;\n" +
            "    width: auto !important;\n" +
            "    width: 180px;\n" +
            "}\n" +
            ".PromotionGroupListItemDetailsColumn\n" +
            "{\n" +
            "    padding: 10px 2.5%;\n" +
            "    vertical-align: top;\n" +
            "    width: 55%;\n" +
            "}\n" +
            ".PromotionGroupListItemNameDiv\n" +
            "{\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            ".PromotionGroupListItemNameLink\n" +
            "{\n" +
            "    color: #000000;\n" +
            "    font-size: 15px;\n" +
            "    font-weight: normal;\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            ".PromotionGroupListItemNameLink:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".PromotionGroupListItemDescription\n" +
            "{\n" +
            "    margin: 5px 0px;\n" +
            "}\n" +
            ".PromotionGroupListItemPriceDiv\n" +
            "{\n" +
            "    clear: both;\n" +
            "    float: left;\n" +
            "    margin-top: 5px;\n" +
            "}\n" +
            ".PromotionGroupListItemPricePanel\n" +
            "{\n" +
            "    font-size: 14px;\n" +
            "    margin: 5px 0px;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".PromotionGroupListItemPriceLabel\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-right: 10px;\n" +
            "}\n" +
            ".PromotionGroupListItemPriceValue\n" +
            "{\n" +
            "    float: left;\n" +
            "    font-weight: bold;\n" +
            "}\n" +
            ".PromotionGroupListItemButtonDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin-top: 15px;\n" +
            "}\n" +
            ".PromotionGroupListItemButtonDiv .TellFriendLinkButton\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "/*PromotionGroupListItem [Layout>Controls]End*/\n" +
            "/*OptionItemDetails Begin*/\n" +
            ".OptionItemDetails\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            ".OptionItemDetailsTop\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".OptionItemDetailsLeft\n" +
            "{\n" +
            "    margin-top: 5px;\n" +
            "}\n" +
            ".OptionItemDetailsErrorMessage\n" +
            "{\n" +
            "    color: #ff0000;\n" +
            "}\n" +
            "/*OptionItemDetails End*/\n" +
            "/*OptionRadioItem Begin*/\n" +
            ".OptionRadioItemDiv\n" +
            "{\n" +
            "    margin-top: -10px;\n" +
            "    margin-left: 23px;\n" +
            "}\n" +
            ".OptionRadioItemRadioButtonList td\n" +
            "{\n" +
            "    position: relative;\n" +
            "    height: 25px;\n" +
            "}\n" +
            ".OptionRadioItemRadioButtonList input\n" +
            "{\n" +
            "    float: left;\n" +
            "}\n" +
            ".OptionRadioItemRadioButtonList label\n" +
            "{\n" +
            "    position: relative;\n" +
            "    float: left;\n" +
            "    margin-top: 1px;\n" +
            "    margin-left: 10px;\n" +
            "    width: 83%;\n" +
            "}\n" +
            ".OptionRadioItemRadioButtonList label span.OptionItemName\n" +
            "{\n" +
            "}\n" +
            ".OptionRadioItemRadioButtonList label img.OptionImg\n" +
            "{\n" +
            "    border: solid 1px #ddd;\n" +
            "    width: 15px;\n" +
            "    left: -50px;\n" +
            "    top: 3px;\n" +
            "    position: absolute;\n" +
            "    max-width: 15px;\n" +
            "}\n" +
            ".OptionRadioItemRadioButtonList label span.OptionPrice\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            "/*OptionRadioItem End*/\n" +
            "/*OptionTextItem Begin*/\n" +
            ".OptionTextItem\n" +
            "{\n" +
            "    position: relative;\n" +
            "}\n" +
            ".OptionTextItemCheckDiv\n" +
            "{\n" +
            "    margin-left: 23px;\n" +
            "    position: relative;\n" +
            "}\n" +
            ".OptionTextItemCheckDiv\n" +
            "{\n" +
            "    float: left;\n" +
            "}\n" +
            ".OptionTextItemCheckDiv span.OptionItemName\n" +
            "{\n" +
            "    position: absolute;\n" +
            "    left: 30px;\n" +
            "    top: 1px;\n" +
            "}\n" +
            ".OptionTextItemCheckDiv span img.OptionImg\n" +
            "{\n" +
            "    border: solid 1px #D2D1D1;\n" +
            "    width: 6px;\n" +
            "    left: -20px;\n" +
            "    top: 3px;\n" +
            "    position: absolute;\n" +
            "}\n" +
            ".OptionTextItemTable span.OptionItemName\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    color: #bbb;\n" +
            "}\n" +
            ".OptionTextItemTable span.OptionPrice\n" +
            "{\n" +
            "    float: right;\n" +
            "    margin-left: 45px;\n" +
            "}\n" +
            ".OptionTextItemText\n" +
            "{\n" +
            "    width: 180px;\n" +
            "    margin-left: 20px;\n" +
            "}\n" +
            "/*OptionTextItem End*/\n" +
            "/*OptionInputListItem Begin*/\n" +
            ".OptionInputListItemDataListItemStyle\n" +
            "{\n" +
            "    padding-bottom: 2px;\n" +
            "}\n" +
            ".OptionInputListItemDataListItemDiv\n" +
            "{\n" +
            "    position: relative;\n" +
            "    margin-left: 23px;\n" +
            "}\n" +
            ".OptionInputListItemDataListItemDiv input\n" +
            "{\n" +
            "    border: solid 1px #ccc;\n" +
            "}\n" +
            ".OptionInputListItemDataListItemDiv span.OptionItemName\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    color: #bbb;\n" +
            "}\n" +
            ".OptionInputListItemDataListItemDiv span img.OptionImg\n" +
            "{\n" +
            "    border: solid 1px #D2D1D1;\n" +
            "    position: absolute;\n" +
            "    width: 6px;\n" +
            "    top: 4px;\n" +
            "    left: -20px;\n" +
            "}\n" +
            "/*OptionInputListItem End*/\n" +
            "/*OptionUploadItem Begin*/\n" +
            ".OptionUploadItem .OptionUploadItemUploadLabel\n" +
            "{\n" +
            "    position: relative;\n" +
            "    margin-left: 23px;\n" +
            "    padding-bottom: 1px;\n" +
            "}\n" +
            ".OptionUploadItem .OptionUploadItemUploadLabel .OptionImg\n" +
            "{\n" +
            "    position: absolute;\n" +
            "    left: -20px;\n" +
            "    top: 3px;\n" +
            "    width: 6px;\n" +
            "    border: solid 1px #D2D1D1;\n" +
            "}\n" +
            ".OptionUploadItemFileUploadWidth\n" +
            "{\n" +
            "    width: 210px;\n" +
            "}\n" +
            "/*OptionUploadItem End*/\n" +
            "/*OptionUploadRequireItem Begin*/\n" +
            ".OptionUploadRequireItem .OptionUploadRequireItemUploadRQLabel\n" +
            "{\n" +
            "    position: relative;\n" +
            "    margin-left: 23px;\n" +
            "    padding-bottom: 1px;\n" +
            "}\n" +
            ".OptionUploadRequireItemUploadRQLabel .OptionImg\n" +
            "{\n" +
            "    position: absolute;\n" +
            "    left: -20px;\n" +
            "    top: 3px;\n" +
            "    width: 6px;\n" +
            "    border: solid 1px #D2D1D1;\n" +
            "}\n" +
            ".OptionUploadRequireItemFileUploadWidth\n" +
            "{\n" +
            "    width: 210px;\n" +
            "    margin-left: 22px;\n" +
            "}\n" +
            "/*OptionUploadRequireItem End*/\n" +
            "/*RecurringSpecial Begin*/\n" +
            ".RecurringSpecialPanel\n" +
            "{\n" +
            "    margin-top: 5px;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".RecurringSpecialNotice\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            "/*RecurringSpecial End*/\n" +
            "/*ContactUs Begin*/\n" +
            ".ContactUsBlock\n" +
            "{\n" +
            "    margin: 10px 0;\n" +
            "    width: 45%;\n" +
            "    clear: left;\n" +
            "}\n" +
            ".ContactUsBlock Table\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    float: left;\n" +
            "}\n" +
            ".ContactUsCaptchaStyle div\n" +
            "{\n" +
            "    clear: left;\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            ".ContactUsCaptchaStyle div input\n" +
            "{\n" +
            "    margin-top: 5px;\n" +
            "    border: solid 1px #ccc;\n" +
            "}\n" +
            ".ContactUsButtonDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: right;\n" +
            "    padding: 5px 0px;\n" +
            "    text-align: right;\n" +
            "    margin-right: 28%;\n" +
            "}\n" +
            ".ContactUsButtonDiv .BtnStyle1\n" +
            "{\n" +
            "    background-color: #ff7200;\n" +
            "}\n" +
            ".ContactUsButtonDiv .BtnStyle1:hover\n" +
            "{\n" +
            "    background-color: #000000;\n" +
            "    color: #ffffff;\n" +
            "}\n" +
            ".ContactUsLabel\n" +
            "{\n" +
            "    width: 120px;\n" +
            "    float: left;\n" +
            "    padding: 4px 0px 4px 0px;\n" +
            "    margin-right: 5px;\n" +
            "    clear: left;\n" +
            "}\n" +
            ".ContactUsData\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-right: 20px;\n" +
            "    padding: 4px 0px 4px 0px;\n" +
            "}\n" +
            ".ContactUsTextBox\n" +
            "{\n" +
            "    margin-bottom: 5px;\n" +
            "    width: 200px;\n" +
            "}\n" +
            ".ContactUsTextBoxLong\n" +
            "{\n" +
            "    margin-bottom: 5px;\n" +
            "    width: 400px;\n" +
            "}\n" +
            ".ContactUsCommentBox\n" +
            "{\n" +
            "    margin-bottom: 5px;\n" +
            "    width: 160%;\n" +
            "    height: 150px;\n" +
            "}\n" +
            ".ContactUsCaptcha\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 65%;\n" +
            "    clear: left;\n" +
            "}\n" +
            ".ContactUsCompanyInfo\n" +
            "{\n" +
            "    margin: 0 10px 10px;\n" +
            "    padding-right: 15%;\n" +
            "    float: left;\n" +
            "    margin-left: 0;\n" +
            "}\n" +
            ".ContactMap\n" +
            "{\n" +
            "    width: 70%;\n" +
            "    height: 300px;\n" +
            "}\n" +
            ".ContactMap img\n" +
            "{\n" +
            "    max-width: none;\n" +
            "}\n" +
            ".ContactUsContact\n" +
            "{\n" +
            "    float: left;\n" +
            "}\n" +
            ".ContactUsValidate\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ContactUsValidateLong\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            "/*ContactUs End*/\n" +
            "/*CommonUserLogin [UserLogin, AffiliateLogin] Begin*/\n" +
            ".UserLogin, .AffiliateLogin\n" +
            "{\n" +
            "    margin: 0 15px;\n" +
            "}\n" +
            ".UserLogin .CommonLoginPageRight, .AffiliateLogin .CommonLoginPageRight\n" +
            "{\n" +
            "    width: 78%;\n" +
            "}\n" +
            ".CommonUserLoginControl\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    margin: 0;\n" +
            "}\n" +
            ".CommonUserLoginError\n" +
            "{\n" +
            "    margin: 5px 0;\n" +
            "    color: #ff0000;\n" +
            "}\n" +
            ".CommonUserLoginMessageFailure\n" +
            "{\n" +
            "    margin-top: 5px;\n" +
            "    margin-bottom: 10px;\n" +
            "    color: #ff0000;\n" +
            "}\n" +
            ".CommonUserLoginLoginPanel\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 53%;\n" +
            "    padding: 0px;\n" +
            "    background: url(Images/Background/dot-line-ver.jpg) repeat-y right top;\n" +
            "}\n" +
            ".CommonUserLoginRegisterPanel\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 42%;\n" +
            "    margin-left: 5%;\n" +
            "}\n" +
            ".CommonUserLoginPanelTitle, .CommonUserLoginRegisterTitle\n" +
            "{\n" +
            "    color: #000;\n" +
            "    float: left;\n" +
            "    font-size: 16px;\n" +
            "    margin: 10px 0;\n" +
            "}\n" +
            "\n" +
            ".CommonUserLoginControl .CommonUserLoginPanelTitle, .CommonUserLoginRegisterTitle\n" +
            "{\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            "\n" +
            ".CommonUserLoginPanelDescription, .CommonUserLoginRegisterDescription\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    margin: 10px 0 25px;\n" +
            "}\n" +
            ".CommonUserLoginPanelUserName, .CommonUserLoginPanelPassword\n" +
            "{\n" +
            "    clear: both;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    margin: 20px 0 0;\n" +
            "}\n" +
            ".CommonUserLoginPanelUserName label, .CommonUserLoginPanelPassword label\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 25%;\n" +
            "}\n" +
            ".CommonUserLoginPanelUserName input, .CommonUserLoginPanelPassword input\n" +
            "{\n" +
            "    float: left;\n" +
            "    padding: 2px;\n" +
            "    width: 60% !important;\n" +
            "}\n" +
            ".CommonUserLoginPanelUserName span, .CommonUserLoginPanelPassword span\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-left: 10px;\n" +
            "    margin-top: 3px;\n" +
            "}\n" +
            "\n" +
            ".CommonUserLoginPanelRemember\n" +
            "{\n" +
            "    clear: both;\n" +
            "    float: left;\n" +
            "    text-align: left;\n" +
            "    height: 20px;\n" +
            "    line-height: 20px;\n" +
            "    vertical-align: middle;\n" +
            "    margin: 20px 0 20px 24%;\n" +
            "    width: 69%;\n" +
            "}\n" +
            ".CommonUserLoginPanelRemember input\n" +
            "{\n" +
            "    float: left;\n" +
            "}\n" +
            ".CommonUserLoginPanelRemember label\n" +
            "{\n" +
            "    float: left;\n" +
            "    height: 20px;\n" +
            "    line-height: 20px;\n" +
            "    vertical-align: middle;\n" +
            "    display: block;\n" +
            "    font-weight: lighter;\n" +
            "}\n" +
            ".CommonUserLoginPanelButton\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin: 10px 5% 10px 25%;\n" +
            "    width: 30%;\n" +
            "}\n" +
            ".CommonUserLoginForgotPasswordDiv\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin: 13px 0;\n" +
            "}\n" +
            ".CommonUserLoginForgotPasswordDiv a\n" +
            "{\n" +
            "    color: #999;\n" +
            "    font-size: 11px;\n" +
            "    text-decoration: underline;\n" +
            "}\n" +
            ".CommonUserLoginRegisterLink\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "}\n" +
            "\n" +
            ".CommonUserLoginRegisterLink .BtnStyle1\n" +
            "{\n" +
            "    text-transform: none;\n" +
            "    background-color: #ff7200;\n" +
            "}\n" +
            "\n" +
            ".CommonUserLoginRegisterPanel .CommonUserLoginRegisterLink .BtnStyle1\n" +
            "{\n" +
            "    text-transform: none;\n" +
            "    background-color: #ff7200;\n" +
            "}\n" +
            ".CommonUserLoginRegisterPanel .CommonUserLoginRegisterLink .BtnStyle1:hover\n" +
            "{\n" +
            "    background-color: #000;\n" +
            "}\n" +
            ".CommonUserLoginRegisterPanel .CommonUserLoginSkipLoginPanel .CommonUserLoginRegisterLink .BtnStyle1\n" +
            "{\n" +
            "    text-transform: none;\n" +
            "    background-color: #ff7200;\n" +
            "}\n" +
            ".CommonUserLoginRegisterPanel .CommonUserLoginSkipLoginPanel .CommonUserLoginRegisterLink .BtnStyle1:hover\n" +
            "{\n" +
            "    background-color: #000;\n" +
            "}\n" +
            "\n" +
            ".CommonUserLoginSkipLoginPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    margin: 20px 0;\n" +
            "}\n" +
            "\n" +
            ".CommonUserLoginSkipLoginPanel .BtnStyle1\n" +
            "{\n" +
            "    background-color: #ff7200;\n" +
            "}\n" +
            "\n" +
            ".CommonUserLoginValidatorText\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-left: 25%;\n" +
            "    width: 60%;\n" +
            "}\n" +
            ".CommonUserLoginValidateDiv\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".CommonUserLoginRegisterDescription ul\n" +
            "{\n" +
            "    padding: 0;\n" +
            "    margin: 5px 0;\n" +
            "    line-height: 20px;\n" +
            "    list-style-type: none;\n" +
            "}\n" +
            ".CommonUserLoginRegisterDescription ul li\n" +
            "{\n" +
            "    background: url(Images/Bullet/bullet2.gif) no-repeat left 8px;\n" +
            "    padding-left: 20px;\n" +
            "}\n" +
            "\n" +
            "/*CommonUserLogin [UserLogin, AffiliateLog\n" +
            ".ContentLayoutRight .NoteText {\n" +
            "    color: #ff0000;\n" +
            "}\n" +
            "/*ContentLayout End*/\n" +
            "/*AffiliateLogin Begin*/\n" +
            ".AffiliateLoginJoinAffiliateProgramDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "    display: table;\n" +
            "    margin: 10px auto;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".AffiliateLoginInformation\n" +
            "{\n" +
            "    margin-top: 5px;\n" +
            "    font-size: 13px;\n" +
            "    line-height: 22px;\n" +
            "}\n" +
            ".AffiliateLoginInformation .ContentLayoutRight\n" +
            "{\n" +
            "    min-height: 0;\n" +
            "}\n" +
            "/*AffiliateLogin End*/\n" +
            "/*StoreSitemap Begin*/\n" +
            "\n" +
            ".StoreSiteMapInformationTop, .StoreSiteMapProductTop, .StoreSiteMapDepartmentTop\n" +
            "{\n" +
            "    margin: 10px 0;\n" +
            "    background: url(Images/Background/dot-line.jpg) repeat-x left bottom;\n" +
            "    width: 99%;\n" +
            "    line-height: 30px;\n" +
            "}\n" +
            ".StoreSiteMapInformationTopTitle, .StoreSiteMapProductTopTitle, .StoreSiteMapDepartmentTopTitle\n" +
            "{\n" +
            "    color: #000;\n" +
            "    font-weight: normal;\n" +
            "    font-size: 16px;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".StoreSiteMapInformationLeft, .StoreSiteMapProductLeft, .StoreSiteMapDepartmentLeft\n" +
            "{\n" +
            "    padding: 20px;\n" +
            "}\n" +
            ".StoreSiteMapProductPanel, .StoreSiteMapDepartmentPanel\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            ".StoreSiteMapProductItemTopBreadcrumbPanel, .StoreSiteMapDepartmentItemTopBreadcrumbPanel\n" +
            "{\n" +
            "    color: #000;\n" +
            "}\n" +
            ".StoreSiteMapProductItemTopBreadcrumbPanel a, .StoreSiteMapDepartmentItemTopBreadcrumbPanel a\n" +
            "{\n" +
            "    color: #000;\n" +
            "    font-weight: bold;\n" +
            "}\n" +
            ".StoreSiteMapProductItemTopBreadcrumbPanel a:hover, .StoreSiteMapDepartmentItemTopBreadcrumbPanel a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            ".StoreSiteMapProductList, .StoreSiteMapDepartmentList\n" +
            "{\n" +
            "    list-style: none;\n" +
            "    margin: 0px;\n" +
            "    padding: 0;\n" +
            "}\n" +
            ".StoreSiteMapProductListItem, .StoreSiteMapDepartmentListItem\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "    margin-left: 15px;\n" +
            "    margin-bottom: 5px;\n" +
            "    padding-left: 20px;\n" +
            "    background: url(Images/Bullet/Bullet1.gif) no-repeat left 5px;\n" +
            "}\n" +
            ".StoreSiteMapProductListItem a, .StoreSiteMapDepartmentListItem a\n" +
            "{\n" +
            "    color: #666 !important;\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            ".StoreSiteMapProductListItem a:hover, .StoreSiteMapDepartmentListItem a:hover\n" +
            "{\n" +
            "    text-decoration: underline;\n" +
            "}\n" +
            ".StoreSiteMapProductDataList, .StoreSiteMapDepartmentDataList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".StoreSiteMapProductDataListItemStyle, .StoreSiteMapDepartmentDataListItemStyle\n" +
            "{\n" +
            "    vertical-align: top;\n" +
            "    width: 50%;\n" +
            "}\n" +
            ".StoreSiteMapInformationTopImgLeft, .StoreSiteMapInformationTopImgRight, .StoreSiteMapInformationBottom\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "/*StoreSitemap End*/\n" +
            "/*NewsletterPage Begin*/\n" +
            ".NewsletterPageTableInnerTableDescription\n" +
            "{\n" +
            "    padding-right: 10px;\n" +
            "}\n" +
            ".NewsletterDiv\n" +
            "{\n" +
            "    margin: 15px 0;\n" +
            "}\n" +
            ".NewsletterPageTextBox\n" +
            "{\n" +
            "    border: solid 1px #ccc;\n" +
            "    width: 200px;\n" +
            "}\n" +
            ".NewsletterPanel\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin: 20px 10px 10px 0;\n" +
            "}\n" +
            ".NewsletterPageLabel\n" +
            "{\n" +
            "    width: 100px;\n" +
            "    font-weight: normal;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    padding: 2px 0;\n" +
            "    font-size: 10px;\n" +
            "    color: #333;\n" +
            "}\n" +
            ".NewsletterPageData\n" +
            "{\n" +
            "    float: left;\n" +
            "}\n" +
            ".NewsletterMessageDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".NewsletterLoginImageButton\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-left: 20px;\n" +
            "    margin-top: 20px;\n" +
            "}\n" +
            ".NewsletterPageMsg\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    margin: 5px 0;\n" +
            "}\n" +
            ".NewsletterValidatorText\n" +
            "{\n" +
            "    float: left;\n" +
            "    clear: left;\n" +
            "    margin-left: 100px;\n" +
            "    margin-top: 3px;\n" +
            "}\n" +
            ".NewsletterValidateDiv\n" +
            "{\n" +
            "    width: 202px;\n" +
            "}\n" +
            "/*NewsletterPage End*/\n" +
            "/*NewsNavList Begin*/\n" +
            ".NewsNavList .SidebarTop\n" +
            "{\n" +
            "    line-height: 38px;\n" +
            "    min-height: 45px;\n" +
            "}\n" +
            ".NewsNavList .SidebarTopTitle\n" +
            "{\n" +
            "    line-height: 38px;\n" +
            "    padding: 8px 0;\n" +
            "}\n" +
            "/*News Begin*/\n" +
            ".NewsPagingBox\n" +
            "{\n" +
            "    padding: 10px 0;\n" +
            "    width: 100%;\n" +
            "    float: right;\n" +
            "    height: 20px;\n" +
            "}\n" +
            ".NewsItemsPerPageDiv\n" +
            "{\n" +
            "    float: right;\n" +
            "}\n" +
            ".NewsPagingDiv\n" +
            "{\n" +
            "    float: right;\n" +
            "    margin-right: 5px;\n" +
            "}\n" +
            ".NewsGrid\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    clear: left;\n" +
            "}\n" +
            ".NewsGrid .NewsListRowStyle\n" +
            "{\n" +
            "    clear: left;\n" +
            "    width: 45%;\n" +
            "    vertical-align: top;\n" +
            "    padding: 10px 2% 30px;\n" +
            "}\n" +
            ".NewsGrid .Topic a\n" +
            "{\n" +
            "    float: left;\n" +
            "    clear: left;\n" +
            "    line-height: 20px;\n" +
            "    margin: 0 0 15px;\n" +
            "    font-weight: normal;\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            ".NewsGrid .Topic a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".NewsGrid .FooterItem\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    background: url(Images/Background/dot-line.jpg) repeat-x left top;\n" +
            "    padding: 8px 0 0;\n" +
            "    margin-top: 8px;\n" +
            "}\n" +
            ".NewsGrid .PostedDate\n" +
            "{\n" +
            "    float: left;\n" +
            "    font-size: 11px;\n" +
            "    text-align: left;\n" +
            "    font-style: italic;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".NewsGrid .publisherName\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".NewsGrid .Description\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    font-size: 14px;\n" +
            "    line-height: 20px;\n" +
            "    text-transform: none;\n" +
            "    width: 100%;\n" +
            "    margin-bottom: 8px;\n" +
            "}\n" +
            ".NewsGrid .NewsMore\n" +
            "{\n" +
            "    float: right;\n" +
            "    color: #999;\n" +
            "    font-size: 10px;\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            ".NewsGrid .NewsMoreHide\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".NewsGrid .NewsContent\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    border-top: solid 1px #ddd;\n" +
            "}\n" +
            ".NewsGrid .NewsSocialButton\n" +
            "{\n" +
            "    float: right;\n" +
            "    width: 35%;\n" +
            "    padding-bottom: 10px;\n" +
            "}\n" +
            ".NewsSocialButton .SocialButton\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-right: 10px;\n" +
            "    width: 25%;\n" +
            "}\n" +
            ".NewsGrid .continueBtn .BtnLink\n" +
            "{\n" +
            "    background: url(Images/Bullet/more.gif) no-repeat right center;\n" +
            "    font-size: 11px;\n" +
            "    line-height: 18px;\n" +
            "    margin: 0;\n" +
            "    padding: 0;\n" +
            "    padding-right: 22px;\n" +
            "    vertical-align: middle;\n" +
            "    text-decoration: none;\n" +
            "    width: auto;\n" +
            "    float: right;\n" +
            "    color: #000;\n" +
            "    border: 0;\n" +
            "}\n" +
            ".NewsGrid .continueBtn .BtnLink:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".NewsListImage\n" +
            "{\n" +
            "    float: right;\n" +
            "}\n" +
            ".NewsListImage img\n" +
            "{\n" +
            "    margin: 0 0 5px 10px;\n" +
            "    display: block;\n" +
            "}\n" +
            "/*News End*/\n" +
            "/*NewsDetails Begin*/\n" +
            ".NewsDetailsDiv\n" +
            "{\n" +
            "    margin: 0px;\n" +
            "    padding: 5px 0 0px;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".NewsDetailsData\n" +
            "{\n" +
            "    float: left;\n" +
            "    clear: left;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".NewsDetailsTopic\n" +
            "{\n" +
            "    font-size: 19px;\n" +
            "    float: left;\n" +
            "    clear: left;\n" +
            "    width: 100%;\n" +
            "}\n" +
            "\n" +
            ".NewsDetailsImageDiv img\n" +
            "{\n" +
            "    display: block;\n" +
            "    margin: 0 20px 10px 0;\n" +
            "    padding: 5px;\n" +
            "    background-color: #fff;\n" +
            "}\n" +
            "\n" +
            ".NewsDetails .PostedDate\n" +
            "{\n" +
            "    float: left;\n" +
            "    clear: left;\n" +
            "    width: 100%;\n" +
            "    font-size: 10px;\n" +
            "    text-align: left;\n" +
            "    margin-top: 5px;\n" +
            "    margin-bottom: 20px;\n" +
            "    font-style: italic;\n" +
            "}\n" +
            "\n" +
            ".NewsDetails .LinkToTop\n" +
            "{\n" +
            "    margin-top: 20px;\n" +
            "    font-size: 10px;\n" +
            "    padding: 8px 0 0;\n" +
            "    border-top: dotted 1px #ccc;\n" +
            "    width: 100%;\n" +
            "    clear: both;\n" +
            "    float: right;\n" +
            "}\n" +
            ".NewsDetails .LinkToTop .SocialButton\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-right: 5px;\n" +
            "    width: 80px;\n" +
            "}\n" +
            ".NewsDetails .LinkToTop a.BtnLink\n" +
            "{\n" +
            "    float: right;\n" +
            "}\n" +
            ".NewsDetailsData\n" +
            "{\n" +
            "    line-height: 20px;\n" +
            "}\n";
    static String css3 =
            "/*NewsDetails End*/\n" +
            "/*GiftRegistrySearch Begin*/\n" +
            ".GiftRegistrySearchLabel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    padding: 4px;\n" +
            "    width: 120px;\n" +
            "    margin-right: 5px;\n" +
            "}\n"+
            ".GiftRegistrySearchData\n" +
            "{\n" +
            "    float: left;\n" +
            "    padding: 4px;\n" +
            "}\n" +
            ".GiftRegistrySearchContent\n" +
            "{\n" +
            "    padding-top: 15px;\n" +
            "    padding-bottom: 15px;\n" +
            "}\n" +
            ".GiftRegistrySearchButton\n" +
            "{\n" +
            "    float: right;\n" +
            "}\n" +
            "/*GiftRegistrySearch End*/\n" +
            "/*AdvancedSearch Begin*/\n" +
            ".AdvancedSearch\n" +
            "{\n" +
            "    display: table;\n" +
            "    padding-bottom: 10px;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".AdvancedSearchPanel\n" +
            "{\n" +
            "    margin: 0px 10px 10px 0;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 90%;\n" +
            "    color: #000;\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            ".AdvancedSearchLabel\n" +
            "{\n" +
            "    float: left;\n" +
            "    padding-top: 5px;\n" +
            "    padding-right: 0;\n" +
            "    color: #000;\n" +
            "    width: 20%;\n" +
            "}\n" +
            ".AdvancedSearchToLabel\n" +
            "{\n" +
            "    float: left;\n" +
            "    padding-top: 5px;\n" +
            "    width: 10%;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".AdvancedSearchDrop\n" +
            "{\n" +
            "    float: left;\n" +
            "    padding-top: 2px;\n" +
            "    margin-right: 0;\n" +
            "    width: 30%;\n" +
            "}\n" +
            ".AdvancedSearchDrop select\n" +
            "{\n" +
            "    color: #7a888d;\n" +
            "    font-size: 11px;\n" +
            "    border: solid 1px #f0f0f0;\n" +
            "    padding: 2px 0;\n" +
            "}\n" +
            ".AdvancedSearchText\n" +
            "{\n" +
            "    float: left;\n" +
            "    padding-top: 1px;\n" +
            "    width: 35%;\n" +
            "}\n" +
            ".AdvancedSearchTextBox\n" +
            "{\n" +
            "    font-size: 12px;\n" +
            "    color: #000;\n" +
            "}\n" +
            ".AdvancedSearchResultBackButton\n" +
            "{\n" +
            "    position: relative;\n" +
            "    left: 15px;\n" +
            "    float: left;\n" +
            "}\n" +
            ".AdvancedSearchDotted\n" +
            "{\n" +
            "    clear: left;\n" +
            "    padding-top: 40px;\n" +
            "    background: url(Images/Background/dot-line.jpg) repeat-x left bottom;\n" +
            "}\n" +
            ".AdvancedSearchHeader\n" +
            "{\n" +
            "    margin-top: 30px;\n" +
            "    margin-bottom: 20px;\n" +
            "    color: #000;\n" +
            "}\n" +
            ".AdvancedSearchInLabel\n" +
            "{\n" +
            "    float: left;\n" +
            "    padding-top: 5px;\n" +
            "    margin-right: 10px;\n" +
            "}\n" +
            ".AdvancedSearchManufacturerLabel, .AdvancedSearchDepartmentLabel, .AdvancedSearchVendorLabel\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 20%;\n" +
            "    color: #000;\n" +
            "    padding-top: 5px;\n" +
            "}\n" +
            ".AdvancedSearchButton\n" +
            "{\n" +
            "    float: right;\n" +
            "    margin-top: 30px;\n" +
            "}\n" +
            ".AdvancedSearchResetButton\n" +
            "{\n" +
            "    float: right;\n" +
            "    clear: right;\n" +
            "    margin-top: 30px;\n" +
            "    padding-left: 25px;\n" +
            "}\n" +
            ".AdvancedSearchKeywordTable\n" +
            "{\n" +
            "    clear: left;\n" +
            "    width: 100%;\n" +
            "    padding: 10px 4%;\n" +
            "    border: solid 1px #E1E1E1;\n" +
            "    margin-bottom: 20px;\n" +
            "}\n" +
            ".AdvancedSearchTitle\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    font-size: 20px;\n" +
            "    line-height: 30px;\n" +
            "    margin-left: 10px;\n" +
            "    margin-top: 12px;\n" +
            "}\n" +
            ".AdvancedSearchTable\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    margin: 20px 0;\n" +
            "    clear: left;\n" +
            "    padding: 20px 0;\n" +
            "}\n" +
            ".AdvancedSearchDataList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".AdvancedSearchDataListTable\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".AdvancedSearchDataListTableHeaderCheck\n" +
            "{\n" +
            "}\n" +
            ".AdvancedSearchInnerTableLabel\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".AdvancedSearchInnerTableInputPrice\n" +
            "{\n" +
            "    width: 85px;\n" +
            "    float: left;\n" +
            "}\n" +
            ".AdvancedSearchInnerTableInputTo\n" +
            "{\n" +
            "    float: left;\n" +
            "    line-height: 22px;\n" +
            "    vertical-align: middle;\n" +
            "    margin-right: 10px;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".AdvancedSearchInnerTableInput input\n" +
            "{\n" +
            "    border: solid 1px #ccc;\n" +
            "}\n" +
            ".AdvancedSearchBox\n" +
            "{\n" +
            "    clear: left;\n" +
            "    width: 92%;\n" +
            "    padding: 10px 4%;\n" +
            "    border-color: #E1E1E1;\n" +
            "    border-style: solid;\n" +
            "    border-width: 1px;\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            ".AdvancedSearchTypeCheckList\n" +
            "{\n" +
            "    width: 70%;\n" +
            "    margin-left: 19%;\n" +
            "}\n" +
            ".AdvancedSearchTypeCheckList input\n" +
            "{\n" +
            "    margin-right: 10px;\n" +
            "}\n" +
            ".AdvancedSearchTypeCheckList td\n" +
            "{\n" +
            "    width: 25%;\n" +
            "    padding: 10px 0;\n" +
            "}\n" +
            ".AdvancedSearchInType\n" +
            "{\n" +
            "    padding-left: 4px;\n" +
            "    padding-bottom: 15px;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    clear: left;\n" +
            "}\n" +
            ".AdvancedSearchInCategory, .AdvancedSearchInDepartment, .AdvancedSearchInManufacturer\n" +
            "{\n" +
            "    padding-left: 4px;\n" +
            "    padding-bottom: 10px;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    clear: left;\n" +
            "}\n" +
            ".AdvancedSearchInTypeTitle\n" +
            "{\n" +
            "    padding: 2px 0px 2px 0px;\n" +
            "    margin-right: 5px;\n" +
            "    clear: left;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".AdvancedSearchInCategoryTitle, .AdvancedSearchInDepartmentTitle, .AdvancedSearchInManufacturerTitle\n" +
            "{\n" +
            "    width: 170px;\n" +
            "    float: left;\n" +
            "    padding: 2px 0px 2px 0px;\n" +
            "    margin-right: 5px;\n" +
            "    clear: left;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".AdvancedSearchInCategoryDrop, .AdvancedSearchInDepartmentDrop, .AdvancedSearchinmanufacturerDrop, .AdvancedSearchInVendorDrop\n" +
            "{\n" +
            "    width: 230px;\n" +
            "}\n" +
            ".AdvancedSearchInCategoryDropDiv, .AdvancedSearchInDepartmentDropDiv, .AdvancedSearchinmanufacturerDropDiv\n" +
            "{\n" +
            "    float: left;\n" +
            "    min-width: 300px;\n" +
            "    padding-top: 2px;\n" +
            "    padding-bottom: 2px;\n" +
            "}\n" +
            ".AdvancedSearchResult, .AdvancedContentSearchResult, .AdvancedSearchResultDepartment\n" +
            "{\n" +
            "    margin-bottom: 15px;\n" +
            "}\n" +
            ".ContentList .ProductListPageControlPanel\n" +
            "{\n" +
            "    background-color: #F8F8F8;\n" +
            "    clear: both;\n" +
            "    line-height: 30px;\n" +
            "    margin-bottom: 10px;\n" +
            "    padding: 3px 2%;\n" +
            "    width: 96%;\n" +
            "}\n" +
            ".ContentList .ProductListPagingControl\n" +
            "{\n" +
            "    border: none;\n" +
            "    padding: 5px 0;\n" +
            "}\n" +
            ".ContentList .ProductListItemPerPage\n" +
            "{\n" +
            "    width: auto;\n" +
            "    float: right;\n" +
            "    font-size: 10px;\n" +
            "    color: #000;\n" +
            "}\n" +
            ".ContentList .ProductListItemPerPage select\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-right: 10px;\n" +
            "    margin-top: 6px;\n" +
            "}\n" +
            ".ContentList .NewsTopicItemColumnTopicStyle\n" +
            "{\n" +
            "    line-height: 24px;\n" +
            "    vertical-align: middle;\n" +
            "    color: #000;\n" +
            "    padding: 0 10px;\n" +
            "}\n" +
            ".ContentList .NewsTopicItemColumnTopicStyle a\n" +
            "{\n" +
            "    color: #000;\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            ".AdvancedSearchResult .CommonPageRight, .AdvancedSearchResultDepartment .CommonPageRight\n" +
            "{\n" +
            "    padding: 15px 0;\n" +
            "}\n" +
            ".AdvancedSearchPanel .CommonValidateDiv\n" +
            "{\n" +
            "    margin-top: 1px;\n" +
            "    width: 75px;\n" +
            "}\n" +
            ".SearchByKeyword\n" +
            "{\n" +
            "    margin: 0px;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 50%;\n" +
            "}\n" +
            ".SearchByCategory\n" +
            "{\n" +
            "    margin: 0px;\n" +
            "    clear: none;\n" +
            "    float: right;\n" +
            "    width: 45%;\n" +
            "    margin: 0px 15px 50px 0px;\n" +
            "}\n" +
            ".SearchByCategoryField\n" +
            "{\n" +
            "    margin: 0px;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 50%;\n" +
            "}\n" +
            ".SearchByDepartment\n" +
            "{\n" +
            "    margin-right: 0px;\n" +
            "    margin-top: 10px;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 50%;\n" +
            "}\n" +
            ".SearchByManufacturer\n" +
            "{\n" +
            "    margin-right: 0px;\n" +
            "    margin-top: 10px;\n" +
            "    clear: none;\n" +
            "    float: right;\n" +
            "    width: 45%;\n" +
            "}\n" +
            ".SearchByVendor\n" +
            "{\n" +
            "    margin-right: 0px;\n" +
            "    margin-top: 10px;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 50%;\n" +
            "}\n" +
            ".SearchByPrice\n" +
            "{\n" +
            "    margin: 0px 15px 0px 0px;\n" +
            "    clear: none;\n" +
            "    float: right;\n" +
            "    width: 45%;\n" +
            "}\n" +
            ".SearchTextByKeyword\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-left: 5%;\n" +
            "    width: 40%;\n" +
            "}\n" +
            ".SearchTextByKeyword input[type=\"text\"]\n" +
            "{\n" +
            "    width: 100% !important;\n" +
            "}\n" +
            ".SearchTextByPrice\n" +
            "{\n" +
            "    width: 35%;\n" +
            "    padding-left: 0;\n" +
            "    margin: 0;\n" +
            "}\n" +
            "\n" +
            ".ShowAdvancedSearchLinkButton\n" +
            "{\n" +
            "    float: right;\n" +
            "    color: #000;\n" +
            "    font-size: 11px;\n" +
            "    text-transform: uppercase;\n" +
            "    text-decoration: underline;\n" +
            "    background: url(Images/Bullet/Advance-Search-toggle-show.gif) no-repeat right center;\n" +
            "    padding-right: 32px;\n" +
            "}\n" +
            ".HideAdvancedSearchLinkButton\n" +
            "{\n" +
            "    float: right;\n" +
            "    color: #000;\n" +
            "    font-size: 11px;\n" +
            "    text-transform: uppercase;\n" +
            "    text-decoration: underline;\n" +
            "    background: url(Images/Bullet/Advance-Search-toggle-hide.gif) no-repeat right center;\n" +
            "    padding-right: 32px;\n" +
            "}\n" +
            "\n" +
            "/*AdvancedSearch End*/\n" +
            "/*AdvancedSearch CheckList Begin*/\n" +
            ".CategoryCheckListCheckBoxList, .DepartmentCheckListCheckBoxList\n" +
            "{\n" +
            "    border: solid 1px #ccc;\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            ".CategoryCheckListCheckBoxList label\n" +
            "{\n" +
            "    font-size: 12px;\n" +
            "}\n" +
            ".CategoryCheckListCheckBoxList td, .DepartmentCheckListCheckBoxList td\n" +
            "{\n" +
            "    width: 25%;\n" +
            "}\n" +
            ".AdvancedSearchDataListTableHeaderCheck label\n" +
            "{\n" +
            "    font-size: 13px !important;\n" +
            "    color: #1e1e1e;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".AdvancedSearchDataListTable\n" +
            "{\n" +
            "    padding-top: 20px;\n" +
            "}\n" +
            ".AdvancedSearchButton .BtnStyle1\n" +
            "{\n" +
            "    background-color: #ff7200;\n" +
            "}\n" +
            ".AdvancedSearchButton .BtnStyle1:hover\n" +
            "{\n" +
            "    background-color: #000;\n" +
            "}\n" +
            "/*AdvancedSearch End*/\n" +
            "\n" +
            "\n" +
            "/*CouponMessageDisplay Begin */\n" +
            ".CouponMessageDisplayAvaliableMessageHeader\n" +
            "{\n" +
            "    margin: 10px 0 5px 0;\n" +
            "}\n" +
            ".CouponMessageDisplayLabel\n" +
            "{\n" +
            "    margin: 5px 10px 5px 0;\n" +
            "    display: block;\n" +
            "    float: left;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            "\n" +
            ".CouponPromotionWarningDisplayLabel\n" +
            "{\n" +
            "    margin: 5px 0;\n" +
            "    display: block;\n" +
            "    float: left;\n" +
            "}\n" +
            "\n" +
            ".CouponMessageDisplayData\n" +
            "{\n" +
            "    margin: 5px 0;\n" +
            "    display: block;\n" +
            "    float: left;\n" +
            "}\n" +
            "\n" +
            ".CouponMessageDisplayAvaliableMessageList, .CouponMessageDisplay\n" +
            "{\n" +
            "    clear: left;\n" +
            "    width: 100%;\n" +
            "    display: table;\n" +
            "}\n" +
            ".CouponPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 10px 0;\n" +
            "}\n" +
            ".CouponPanel .CommonFormLabel\n" +
            "{\n" +
            "    padding: 0;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".CouponPanel .CommonTextBox\n" +
            "{\n" +
            "    margin-right: 10px;\n" +
            "    float: left;\n" +
            "}\n" +
            ".CouponBackButton\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 20px 0 10px;\n" +
            "}\n" +
            "/*CouponMessageDisplay End */\n" +
            "\n" +
            "/*AccountDetails Begin*/\n" +
            ".AccountDetailsDiv\n" +
            "{\n" +
            "    margin: 0px;\n" +
            "    width: 100%;\n" +
            "    clear: left;\n" +
            "}\n" +
            ".AccountDetailsTextBox\n" +
            "{\n" +
            "    width: 150px;\n" +
            "}\n" +
            ".AccountDetailsLongTextBox\n" +
            "{\n" +
            "    width: 200px;\n" +
            "}\n" +
            ".AccountDetailsCheckBox\n" +
            "{\n" +
            "    float: left;\n" +
            "}\n" +
            ".AccountDetailsCheckBoxDiv\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-left: 37%;\n" +
            "    padding-bottom: 20px;\n" +
            "    clear: left;\n" +
            "    width: 120%;\n" +
            "}\n" +
            ".AccountDetailsCountryStatePanel\n" +
            "{\n" +
            "    clear: both;\n" +
            "}\n" +
            ".AccountDetailsCheckBoxDiv .AccountDetailsCheckBox label\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".AccountDetailsButtonDiv\n" +
            "{\n" +
            "    margin-top: 20px;\n" +
            "    text-align: right;\n" +
            "    float: right;\n" +
            "    clear: left;\n" +
            "}\n" +
            ".AccountDetailsButtonDiv .BtnStyle1\n" +
            "{\n" +
            "    background-color: #ff7200;\n" +
            "}\n" +
            ".AccountDetailsButtonDiv .BtnStyle1:hover\n" +
            "{\n" +
            "    background-color: #000;\n" +
            "}\n" +
            ".AccountDetailsShippingItemInfoPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".AccountDetailsPanel\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    float: left;\n" +
            "    clear: left;\n" +
            "}\n" +
            ".ShippingDestination\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".AccountDetails .CommonFormLabel\n" +
            "{\n" +
            "    width: 120px;\n" +
            "}\n" +
            ".AccountDetails .CheckoutTextBox\n" +
            "{\n" +
            "    width: 140px;\n" +
            "    float: left;\n" +
            "}\n" +
            "/*AccountDetails End*/\n" +
            "\n" +
            "/*ImageZoomingButton Begin*/\n" +
            ".ImageZoomingButton\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            "\n" +
            ".ImageZoomingButton a\n" +
            "{\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            "\n" +
            ".ImageZoomingButtonPopup\n" +
            "{\n" +
            "    float: left;\n" +
            "}\n" +
            "\n" +
            ".ImageZoomingButtonZoom\n" +
            "{\n" +
            "    float: right;\n" +
            "}\n" +
            "\n" +
            ".ImageZoomingButtonPopupImage\n" +
            "{\n" +
            "    float: left;\n" +
            "}\n" +
            "\n" +
            ".ImageZoomingButtonPopupMessage\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-left: 5px;\n" +
            "    margin-top: 2px;\n" +
            "}\n" +
            "\n" +
            ".ImageZoomingButtonZoomImage\n" +
            "{\n" +
            "    float: left;\n" +
            "}\n" +
            "\n" +
            ".ImageZoomingButtonZoomMessage\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-left: 5px;\n" +
            "    margin-top: 2px;\n" +
            "}\n" +
            "\n" +
            "/*ImageZoomingButton End*/\n" +
            "\n" +
            "/*GiftCertificateDetails Begin*/\n" +
            ".GiftCertificateDetailsPanel\n" +
            "{\n" +
            "    margin: 10px 0;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "}\n" +
            "\n" +
            ".GiftCertificateDetailsTitle\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            "\n" +
            ".GiftCertificateDetailsLabelColumn\n" +
            "{\n" +
            "    width: 90px;\n" +
            "    text-align: left;\n" +
            "}\n" +
            "\n" +
            ".GiftCertificateDetailsInputColumn input\n" +
            "{\n" +
            "    border: solid 1px #ccc;\n" +
            "}\n" +
            "\n" +
            ".GiftCertificateDetailsInputColumn textarea\n" +
            "{\n" +
            "    width: 150px;\n" +
            "}\n" +
            "/*GiftCertificateDetails End*/\n" +
            "/*ForgotPassword Begin*/\n" +
            ".ForgotPasswordDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "    width: 100%;\n" +
            "    margin: 15px 0;\n" +
            "}\n" +
            "\n" +
            ".ForgotPasswordTextBox\n" +
            "{\n" +
            "    border: solid 1px #ccc;\n" +
            "    width: 200px;\n" +
            "}\n" +
            ".ForgotPasswordPanel\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin: 20px 10px 10px 0;\n" +
            "}\n" +
            ".ForgotPasswordLabel\n" +
            "{\n" +
            "    width: 100px;\n" +
            "    font-weight: normal;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    padding: 2px 0;\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            ".ForgotPasswordData\n" +
            "{\n" +
            "    float: left;\n" +
            "}\n" +
            ".ForgotPasswordMessageDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ForgotPasswordLoginImageButton\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-left: 20px;\n" +
            "    margin-top: 20px;\n" +
            "    background-color: #ff7200;\n" +
            "}\n" +
            ".ForgotPasswordLoginImageButton:hover\n" +
            "{\n" +
            "    background-color: #000000;\n" +
            "    color: #ffffff;\n" +
            "}\n" +
            ".ForgotPasswordValidatorText\n" +
            "{\n" +
            "    float: left;\n" +
            "    clear: left;\n" +
            "    margin-left: 100px;\n" +
            "    margin-top: 3px;\n" +
            "}\n" +
            ".ForgotPasswordValidateDiv\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            "/*ForgotPassword End*/\n" +
            "/*MyAccount Begin*/\n" +
            ".MyAccountInformation\n" +
            "{\n" +
            "}\n" +
            "\n" +
            ".MyAccountInformationTopImgLeft\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "\n" +
            ".MyAccountInformationTopImgRight\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "\n" +
            ".MyAccountInformationTop\n" +
            "{\n" +
            "    padding: 5px 0;\n" +
            "    background: url(Images/Bullet/TitleBullet.gif) no-repeat left center;\n" +
            "}\n" +
            "\n" +
            ".MyAccountInformationTopTitle\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    font-size: 10px;\n" +
            "    margin-left: 15px;\n" +
            "}\n" +
            ".MyAccountInformationLeft\n" +
            "{\n" +
            "    padding: 10px;\n" +
            "    border-top: solid 2px #ccc;\n" +
            "}\n" +
            ".MyAccountInformationList\n" +
            "{\n" +
            "    list-style: none;\n" +
            "    margin-left: 0px;\n" +
            "    padding: 0px;\n" +
            "}\n" +
            "\n" +
            ".MyAccountInformationListItem\n" +
            "{\n" +
            "    background-image: url(Images/Bullet/bullet2.gif);\n" +
            "    background-position: 0 3px;\n" +
            "    background-repeat: no-repeat;\n" +
            "    margin-left: 20px;\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            "\n" +
            ".MyAccountInformationItemLink\n" +
            "{\n" +
            "    margin-left: 20px;\n" +
            "    text-decoration: none;\n" +
            "    vertical-align: middle;\n" +
            "}\n" +
            "\n" +
            ".MyAccountInformationItemLink:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    text-decoration: underline;\n" +
            "}\n" +
            ".ShippingAddressLinkPanel\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "    float: right;\n" +
            "}\n" +
            "/*MyAccount End*/\n" +
            "/*SearchFilter Begin*/\n" +
            ".SearchFilter\n" +
            "{\n" +
            "    line-height: 24px;\n" +
            "    color: #2a353c;\n" +
            "    float: left;\n" +
            "    letter-spacing: 0.2px;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".SearchFilterValueRangePanel, .SearchFilterDateRangePanel, .SearchFilterTextPanel, .SearchFilterBooleanPanel\n" +
            "{\n" +
            "    margin-top: 5px;\n" +
            "    margin-bottom: 10px;\n" +
            "    background-color: #f9f9f9;\n" +
            "    border: dashed 1px #E1E1E1;\n" +
            "    padding: 7px;\n" +
            "}\n" +
            ".SearchFilterValueRangeImageButton, .SearchFilterDateRangeImageButton, .SearchFilterTextImageButton, .SearchFilterBooleanImageButton\n" +
            "{\n" +
            "    clear: none;\n" +
            "    float: left;\n" +
            "    margin-left: 5px;\n" +
            "}\n" +
            ".SearchFilterLabel\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-right: 5px;\n" +
            "}\n" +
            ".SearchFilterStartDateImageButton, .SearchFilterEndDateImageButton\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-right: 5px;\n" +
            "    margin-top: 4px;\n" +
            "}\n" +
            ".SearchFilterTextBox, .SearchFilterBooleanDropDown\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-right: 8px;\n" +
            "    border: solid 1px #f0f0f0;\n" +
            "}\n" +
            ".SearchFilterMessageLabel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            ".SearchFilterValueRangePanel .CommonValidatorTextLowerBound\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "}\n" +
            ".SearchFilterValueRangePanel .CommonValidatorTextUpperBound\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "}\n" +
            ".SearchFilterValueRangePanel .CommonValidateDiv\n" +
            "{\n" +
            "    margin-bottom: -1px;\n" +
            "    margin-top: 2px;\n" +
            "    width: 81px;\n" +
            "}\n" +
            ".ValueRangeValidateDiv\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 90px;\n" +
            "}\n" +
            "\n" +
            "/*GiftCertificate Begin*/\n" +
            ".GiftCertificateDetailsDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "    color: #000;\n" +
            "    float: left;\n" +
            "    font-size: 13px;\n" +
            "    font-weight: normal;\n" +
            "    line-height: 30px;\n" +
            "    margin: 5px 0 15px;\n" +
            "    padding: 5px 0;\n" +
            "    text-transform: none;\n" +
            "    width: 100%;\n" +
            "}\n" +
            "\n" +
            ".GiftCertificateMessageDiv\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    color: Red;\n" +
            "}\n" +
            "\n" +
            ".GiftCertificateDivInner\n" +
            "{\n" +
            "    position: relative;\n" +
            "    margin-left: auto;\n" +
            "    margin-right: auto;\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            "\n" +
            ".GiftCertificateTextBox\n" +
            "{\n" +
            "    width: 25% !important;\n" +
            "    margin-left: 3%;\n" +
            "    float: left;\n" +
            "    margin-top: 2px;\n" +
            "}\n" +
            "\n" +
            ".GiftCertificateVerifyImageButton\n" +
            "{\n" +
            "    margin-top: 3px;\n" +
            "    clear: none;\n" +
            "    float: left;\n" +
            "}\n" +
            ".GiftCertificateResultDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 50%;\n" +
            "    padding: 15px;\n" +
            "    margin-top: 20px;\n" +
            "    border: dashed 1px #ddd;\n" +
            "}\n" +
            ".GiftCertificateLabelColumn\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    color: #000;\n" +
            "    line-height: 24px;\n" +
            "}\n" +
            ".GiftCertificateValueColumn\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    line-height: 24px;\n" +
            "}\n" +
            ".GiftCertificateSpan\n" +
            "{\n" +
            "    float: left;\n" +
            "    line-height: 24px;\n" +
            "    text-transform: uppercase;\n" +
            "    font-size: 13px;\n" +
            "    text-transform: none;\n" +
            "}\n" +
            "/*GiftCertificate End*/\n" +
            "/*GiftRegistryList Begin*/\n" +
            ".GiftRegistryListNoteDiv\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryListHilight\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryListGridViewDiv\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryListGridView\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    border: solid 1px #e4e4e4;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryListGridViewHeaderStyle th\n" +
            "{\n" +
            "    background-color: #f8f8f8;\n" +
            "    border-bottom: solid 1px #e8e8e8;\n" +
            "    padding: 0px;\n" +
            "    height: 28px;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryListDeleteHeaderStyle\n" +
            "{\n" +
            "    width: 30px;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryListDeleteItemStyle\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryListEventDateHeaderStyle, .GiftRegistryListProductListLinkHeaderStyle, .GiftRegistryListEditEventLinkHeaderStyle, .GiftRegistryListSendEmailLinkHeaderStyle, .GiftRegistryListProductListLinkItemStyle\n" +
            "{\n" +
            "    width: 14%;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryListEditEventLinkItemStyle\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryListSendEmailLinkItemStyle\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".GiftRegistryListEventDateHeaderStyle, .GiftRegistryListEventNameHeaderStyle\n" +
            "{\n" +
            "    text-align: left;\n" +
            "}\n" +
            "/*GiftRegistryList End*/\n" +
            "/*GiftRegistryDetail Begin*/\n" +
            ".GiftRegistryDetailNote\n" +
            "{\n" +
            "    color: #ff0000;\n" +
            "    margin: 10px 0;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryDetailDiv\n" +
            "{\n" +
            "    margin: 0px;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryDetailDiv .CommonPageInnerTitle\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryDetailButtonDiv\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "    text-align: right;\n" +
            "    float: right;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryDetailBackLinkImage\n" +
            "{\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryDetailAddImage\n" +
            "{\n" +
            "    background-color: #FF7200;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryDetailEditImage\n" +
            "{\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryDetailTextBox\n" +
            "{\n" +
            "    margin-bottom: 5px;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryDetailLongTextBox\n" +
            "{\n" +
            "    margin-bottom: 5px;\n" +
            "    width: 200px;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryValidate\n" +
            "{\n" +
            "    width: 80%;\n" +
            "}\n" +
            ".GiftRegistryValidateLong\n" +
            "{\n" +
            "    width: 80%;\n" +
            "}\n" +
            ".GiftRegistryDetailDiv input[type=\"text\"]\n" +
            "{\n" +
            "    width: 80%;\n" +
            "}\n" +
            ".GiftRegistryDetailCityStatePanel .CountryAndStateListDropDown\n" +
            "{\n" +
            "    width: 40%;\n" +
            "    margin: 0;\n" +
            "    clear: none;\n" +
            "    margin-right: 10px;\n" +
            "}\n" +
            ".GiftRegistryDetailCityStatePanel input[type=\"text\"].CountryAndStateListCountryTextBox\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 40%;\n" +
            "    margin-left: 29%;\n" +
            "    margin-bottom: 3px;\n" +
            "}\n" +
            ".GiftRegistryDetailCityStatePanel input[type=\"text\"].CountryAndStateListStateTextBox\n" +
            "{\n" +
            "    float: right;\n" +
            "    width: 40%;\n" +
            "    margin-bottom: 3px;\n" +
            "    margin-right: 31%;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryDetailDiv .CommonFormLabel\n" +
            "{\n" +
            "    width: 25%;\n" +
            "    float: left;\n" +
            "    padding: 2px 0px;\n" +
            "    margin: 0 2%;\n" +
            "    color: #000;\n" +
            "    clear: left;\n" +
            "    font-size: 12px;\n" +
            "    line-height: 25px;\n" +
            "}\n" +
            ".GiftRegistryDetailDiv .CommonFormData\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 50%;\n" +
            "    padding-top: 2px;\n" +
            "    padding-bottom: 2px;\n" +
            "}\n" +
            "/*GiftRegistryDetail End*/\n" +
            "/*GiftRegistryComplete Begin*/\n" +
            ".GiftRegistryCompleteContentDiv\n" +
            "{\n" +
            "    margin-top: 20px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryCompleteButtonDiv\n" +
            "{\n" +
            "    margin: 20px auto 0;\n" +
            "    text-align: center;\n" +
            "    display: table;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryCompleteContinueButtonImage\n" +
            "{\n" +
            "    border: none;\n" +
            "}\n" +
            "/*GiftRegistryComplete End*/\n" +
            "/*GiftRegistrySelect Begin*/\n" +
            ".GiftRegistrySelectButtonDiv\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    margin-top: 15px;\n" +
            "    clear: left;\n" +
            "    float: right;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistrySelectRadioButtonList label\n" +
            "{\n" +
            "    line-height: 20px;\n" +
            "    vertical-align: top;\n" +
            "    margin-left: 5px;\n" +
            "    display: inline-block;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistrySelectValidator\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    text-align: center;\n" +
            "    display: block;\n" +
            "}\n" +
            "/*GiftRegistrySelect End*/\n" +
            "/*GiftRegistryItemList Begin*/\n" +
            ".GiftRegistryItemListHilight\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemListNoteDiv\n" +
            "{\n" +
            "    margin: 10px 0;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemListLabel\n" +
            "{\n" +
            "    float: left;\n" +
            "    clear: left;\n" +
            "    width: 120px;\n" +
            "    line-height: 22px;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemListData\n" +
            "{\n" +
            "    line-height: 22px;\n" +
            "    float: left;\n" +
            "}\n" +
            ".GiftRegistryItemListTitle\n" +
            "{\n" +
            "    border-bottom: 1px dotted #CCCCCC;\n" +
            "    float: left;\n" +
            "    font-size: 10px;\n" +
            "    font-weight: normal;\n" +
            "    margin: 10px 0;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemListGridView\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    border: solid 1px #e4e4e4;\n" +
            "    clear: left;\n" +
            "}\n" +
            ".GiftRegistryItemListProductNameHeaderStyle\n" +
            "{\n" +
            "    text-align: left;\n" +
            "}\n" +
            ".GiftRegistryItemListHasQuantityHeaderStyle, .GiftRegistryItemListWantQuantityHeaderStyle, .GiftRegistryItemListUnitPriceHeaderStyle\n" +
            "{\n" +
            "    width: 16%;\n" +
            "    text-align: right;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemListDeleteHeaderStyle\n" +
            "{\n" +
            "    width: 5%;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemListDeleteItemStyle\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemListUnitPriceStyle\n" +
            "{\n" +
            "    text-align: right;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemListWantQuantityItemStyle\n" +
            "{\n" +
            "    text-align: right;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemListHasQuantityItemStyle\n" +
            "{\n" +
            "    text-align: right;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemListButtonBottomDiv\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "    clear: left;\n" +
            "    float: right;\n" +
            "}\n" +
            ".GiftRegistryItemList .CommonValidateDiv\n" +
            "{\n" +
            "    margin-top: 1px;\n" +
            "    position: relative;\n" +
            "    left: 59px;\n" +
            "    width: 51px;\n" +
            "}\n" +
            "/*GiftRegistryItemList End*/\n" +
            "/*ProductPopup Begin*/\n" +
            ".ProductPopup\n" +
            "{\n" +
            "    padding: 15px;\n" +
            "}\n" +
            "\n" +
            ".ProductPopupTopImgLeft\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "\n" +
            ".ProductPopupTopImgRight\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "\n" +
            ".ProductPopupTopTitle\n" +
            "{\n" +
            "    line-height: 25px;\n" +
            "    font-size: 14px;\n" +
            "}\n" +
            "\n" +
            ".ProductPopupLeft\n" +
            "{\n" +
            "    border: solid 1px #e4e4e4;\n" +
            "    background-color: #fff;\n" +
            "}\n" +
            "\n" +
            ".ProductPopupTable\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            "\n" +
            ".ProductPopupTitleColumn\n" +
            "{\n" +
            "    border-bottom: solid 1px #cdcdcb;\n" +
            "    background-color: #eee;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            "\n" +
            ".ProductPopupDetailsColumn\n" +
            "{\n" +
            "    padding-bottom: 10px;\n" +
            "}\n" +
            "\n" +
            ".ProductPopupBottom\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "\n" +
            ".ProductPopupTopLink\n" +
            "{\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            "\n" +
            ".ProductPopupCloseWindowsLink\n" +
            "{\n" +
            "}\n" +
            ".ProductPopupTopLink:hover, .ProductPopupCloseWindowsLink:hover\n" +
            "{\n" +
            "    cursor: pointer;\n" +
            "    color: #AB1621;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ProductPopupImageColumn\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ProductPopupImageColumn img\n" +
            "{\n" +
            "    max-height: 200px;\n" +
            "    height: auto !important;\n" +
            "    height: 200px;\n" +
            "    max-width: 200px;\n" +
            "    width: auto !important;\n" +
            "    width: 200px;\n" +
            "}\n" +
            "/*ProductPopup End*/\n" +
            "/*GiftRegistrySendMail Begin*/\n" +
            ".GiftRegistrySendMailPanel\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin: 10px 0;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".GiftRegistrySendMailLabel\n" +
            "{\n" +
            "    float: left;\n" +
            "    clear: left;\n" +
            "    line-height: 22px;\n" +
            "    width: 120px;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistrySendMailData\n" +
            "{\n" +
            "    float: left;\n" +
            "    padding: 2px;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistrySendMailCaptchaDiv\n" +
            "{\n" +
            "    border: 1px solid #DDDDDD;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 10px 0 10px 120px;\n" +
            "    padding: 10px;\n" +
            "    width: 425px;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistrySendMailButtonDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "    margin-top: 10px;\n" +
            "    float: right;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistrySendMailCaptchaLabel\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    text-decoration: underline;\n" +
            "}\n" +
            ".GiftRegistrySendMailCaptchaStyle\n" +
            "{\n" +
            "    clear: left;\n" +
            "}\n" +
            ".GiftRegistrySendMailCaptchaStyle div\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistrySendMailCaptchaStyle div input\n" +
            "{\n" +
            "    margin-top: 5px;\n" +
            "    border: solid 1px #ccc;\n" +
            "}\n" +
            ".GiftRegistrySendMailTextbox\n" +
            "{\n" +
            "    margin-bottom: 5px;\n" +
            "    width: 300px;\n" +
            "}\n" +
            ".GiftRegistrySendMailValidate\n" +
            "{\n" +
            "    width: 300px;\n" +
            "}\n" +
            "/*GiftRegistrySendMail End*/\n" +
            "/*GiftRegistrySendMailFinished Begin*/\n" +
            ".GiftRegistrySendMailFinishedImageDiv\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistrySendMailFinishedContent\n" +
            "{\n" +
            "    margin-top: 20px;\n" +
            "    margin-bottom: 20px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            "/*GiftRegistrySendMailFinished End*/\n" +
            "/*GiftRegistryResult Begin*/\n" +
            ".GiftRegistryResultBackLinkDiv\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    margin-top: 20px;\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryResultGridView\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            "/*GiftRegistryResult End*/\n" +
            "/*GiftRegistryItem Begin*/\n" +
            ".GiftRegistryItemLabel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    line-height: 24px;\n" +
            "    font-weight: normal;\n" +
            "    width: 80px;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemData\n" +
            "{\n" +
            "    line-height: 24px;\n" +
            "}\n" +
            "\n" +
            "\n" +
            ".GiftRegistryItemQuantityHeaderStyle\n" +
            "{\n" +
            "    width: 70px;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemHasHeaderStyle\n" +
            "{\n" +
            "    width: 60px;\n" +
            "    text-align: right;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemHasItemStyle\n" +
            "{\n" +
            "    text-align: right;\n" +
            "    padding-right: 5px;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemWantHeaderStyle\n" +
            "{\n" +
            "    width: 60px;\n" +
            "    text-align: right;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemWantItemStyle\n" +
            "{\n" +
            "    text-align: right;\n" +
            "    padding-right: 5px;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemUnitPriceHeaderStyle\n" +
            "{\n" +
            "    width: 70px;\n" +
            "    text-align: right;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemUnitPriceItemStyle\n" +
            "{\n" +
            "    text-align: right;\n" +
            "    padding-right: 5px;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemQuantityItemStyle\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemQuantityItemStyle .CommonTextBox\n" +
            "{\n" +
            "    text-align: right;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemButtonDiv\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "    clear: left;\n" +
            "    float: right;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemAddToCartButtonImage\n" +
            "{\n" +
            "    border: none;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemMessageLabel\n" +
            "{\n" +
            "    display: block;\n" +
            "    padding-bottom: 10px;\n" +
            "    margin-left: 120px;\n" +
            "    margin-right: auto;\n" +
            "    clear: both;\n" +
            "}\n" +
            "\n" +
            ".GiftRegistryItemMessageLabel li\n" +
            "{\n" +
            "    margin-left: 30px;\n" +
            "}\n" +
            "/*GiftRegistryItem End*/\n" +
            "\n" +
            "/*AddShoppingCartNotComplete Begin*/\n" +
            ".AddShoppingCartNotCompleteContent, .AddToCartNotCompleteContent\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "    padding-bottom: 20px;\n" +
            "}\n" +
            ".AddShoppingCartNotComplete .CommonHyperLink\n" +
            "{\n" +
            "    margin: auto;\n" +
            "    display: table;\n" +
            "    font-size: 12px;\n" +
            "}\n" +
            ".AddShoppingCartNotComplete .CommonPageTop\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "/*AddToCart End*/\n" +
            "/*AffiliateDetails Begin*/\n" +
            ".AffiliateDetailsAgreementPanel\n" +
            "{\n" +
            "    clear: both;\n" +
            "    float: left;\n" +
            "    margin: 20px 0 10px 19%;\n" +
            "    width: 60%;\n" +
            "}\n" +
            "\n" +
            ".AffiliateDetailsDownloadDiv\n" +
            "{\n" +
            "}\n" +
            "\n" +
            ".AffiliateDetailsDownloadLinkIcon\n" +
            "{\n" +
            "    margin-right: 5px;\n" +
            "}\n" +
            ".AffiliateDetailsDownloadDiv a\n" +
            "{\n" +
            "    font-size: 12px;\n" +
            "    line-height: 25px;\n" +
            "}\n" +
            ".AffiliateDetailsAgreementContent\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    border: #f0f0f0 1px solid;\n" +
            "    padding: 5px;\n" +
            "    overflow: auto;\n" +
            "    height: 300px;\n" +
            "    text-align: left;\n" +
            "    margin-top: 5px;\n" +
            "    font-size: 12px;\n" +
            "    line-height: 22px;\n" +
            "}\n" +
            "\n" +
            ".AffiliateDetailsAgreementAcceptDiv\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    margin-left: auto;\n" +
            "    margin-right: auto;\n" +
            "    margin-top: 10px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            ".AffiliateDetailsButtonDiv\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "    text-align: right;\n" +
            "    clear: left;\n" +
            "    float: right;\n" +
            "}\n" +
            ".AffiliateDetailsValidatorText\n" +
            "{\n" +
            "    text-align: left;\n" +
            "    width: 100%;\n" +
            "    margin: 2px auto;\n" +
            "}\n" +
            ".AffiliateDetailsValidatorDiv\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            "\n" +
            ".CommissionRate\n" +
            "{\n" +
            "    margin-top: 5px;\n" +
            "}\n" +
            "/*AffiliateDetails End*/\n" +
            "/*AffiliateRegisterFinish Begin*/\n" +
            ".AffiliateRegisterFinishMessageDiv\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            ".AffiliateRegisterFinishLinkPanel\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    margin-top: 15px;\n" +
            "}\n" +
            "/*AffiliateRegisterFinish End*/\n" +
            "/*AffiliateGenerateLink Begin*/\n" +
            ".AffiliateGenerateLinkDiv\n" +
            "{\n" +
            "    border: solid 1px #ccc;\n" +
            "    margin-top: 10px;\n" +
            "    padding: 10px;\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            "\n" +
            ".AffiliateGenerateLinkInner\n" +
            "{\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            "\n" +
            ".AffiliateGenerateLinkTextBox\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            "\n" +
            ".AffiliateGenerateLinkButtonDiv\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "    clear: right;\n" +
            "    float: right;\n" +
            "}\n" +
            "\n" +
            ".AffiliateGenerateLinkButtonDiv img\n" +
            "{\n" +
            "    border: none;\n" +
            "}\n" +
            "/*AffiliateGenerateLink End*/\n" +
            "/*AffiliateCommission Begin*/\n" +
            ".AffiliateCommissionNoResultPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    padding: 10px 0;\n" +
            "}\n" +
            ".AffiliateCommissionRemarkDiv\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            "\n" +
            ".AffiliateCommissionPaymentStatusHeaderStyle\n" +
            "{\n" +
            "    width: 20%;\n" +
            "}\n" +
            "\n" +
            ".AffiliateCommissionPaymentStatusItemStyle\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            ".AffiliateCommissionOrderDateHeaderStyle\n" +
            "{\n" +
            "}\n" +
            "\n" +
            ".AffiliateCommissionOrderDateItemStyle\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            ".AffiliateCommissionCommissionHeaderStyle\n" +
            "{\n" +
            "    text-align: right;\n" +
            "}\n" +
            "\n" +
            ".AffiliateCommissionCommissionItemStyle\n" +
            "{\n" +
            "    width: 20%;\n" +
            "    text-align: right;\n" +
            "}\n" +
            "\n" +
            ".AffiliateCommissionFooterTotalAmountColumn\n" +
            "{\n" +
            "    text-align: right;\n" +
            "    font-weight: normal;\n" +
            "    color: #ff6000;\n" +
            "}\n" +
            "\n" +
            ".AffiliateCommissionProductCostHeaderStyle\n" +
            "{\n" +
            "    width: 20%;\n" +
            "    text-align: right;\n" +
            "}\n" +
            "\n" +
            ".AffiliateCommissionProductCostItemStyle\n" +
            "{\n" +
            "    text-align: right;\n" +
            "}\n" +
            "\n" +
            ".AffiliateCommissionFooterTotalColumn\n" +
            "{\n" +
            "    text-align: right;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            "\n" +
            ".AffiliateCommissionOrderIDHeaderStyle\n" +
            "{\n" +
            "    width: 15%;\n" +
            "}\n" +
            "\n" +
            ".AffiliateCommissionOrderIDItemStyle\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            ".AffiliateCommissionNoResultLinkDiv\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".AffiliateCommissionGridViewFooterStyle td\n" +
            "{\n" +
            "    padding: 5px 2%;\n" +
            "    font-weight: bold;\n" +
            "}\n" +
            "/*AffiliateCommission End*/\n" +
            "/*AffiliateCommissionSearch Begin*/\n" +
            ".AffiliateCommissionSearchLabel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    padding: 4px;\n" +
            "    width: 120px;\n" +
            "    margin-right: 5px;\n" +
            "}\n" +
            "\n" +
            ".AffiliateCommissionSearchData\n" +
            "{\n" +
            "    float: left;\n" +
            "    padding: 4px;\n" +
            "}\n" +
            "\n" +
            ".AffiliateCommissionSearchButtonDiv\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "    clear: right;\n" +
            "    float: right;\n" +
            "}\n" +
            ".AffiliateCommissionSearchLinkDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            ".AffiliateCommissionNoResultDiv\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    border: solid 1px #eee;\n" +
            "    background-color: #f8f8f8;\n" +
            "    padding: 8px;\n" +
            "}\n" +
            ".AffiliateCommissionSearchValidateDiv\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 140px;\n" +
            "}\n" +
            ".AffiliateCommissionSearchData .CommonTextBox\n" +
            "{\n" +
            "    width: 138px;\n" +
            "    float: left;\n" +
            "}\n" +
            ".AffiliateCommissionSearchData .Label\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin: 2px 5px;\n" +
            "}\n" +
            ".CommonCommissionSearchValidateDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "}\n" +
            ".AffiliateCommissionSearchData .CommonImageButton\n" +
            "{\n" +
            "    margin: 3px 0 0 3px;\n" +
            "    float: left;\n" +
            "}\n" +
            "/*AffiliateCommissionSearch End*/\n" +
            "\n" +
            "/*ContactUsFinished Begin*/\n" +
            ".ContactUsFinishedContent\n" +
            "{\n" +
            "    margin: 10px;\n" +
            "}\n" +
            "/*ContactUsFinished End*/\n" +
            "\n" +
            "/*Coupon Begin*/\n" +
            ".Coupon .CouponMessageDisplayAvaliableMessageHeader\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            "\n" +
            ".CouponMessageParagraph\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            "\n" +
            ".CouponCodeParagraph\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            "\n" +
            ".CouponDetailsTable\n" +
            "{\n" +
            "    margin-left: auto;\n" +
            "    margin-right: auto;\n" +
            "}\n" +
            "\n" +
            ".CouponDetailsLabelColumn\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    text-align: right;\n" +
            "    padding-right: 10px;\n" +
            "    width: 100px;\n" +
            "}\n" +
            "\n" +
            ".CouponItemListProductsColumn ul\n" +
            "{\n" +
            "    margin: 0px auto auto 30px;\n" +
            "    padding: 0px;\n" +
            "}\n" +
            "/*Coupon End*/\n" +
            "\n" +
            "/*CouponAndGift Begin*/\n" +
            ".CouponAndGiftImageButtonDiv\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "    margin-right: 0;\n" +
            "    clear: left;\n" +
            "    float: right;\n" +
            "    display: table;\n" +
            "}\n" +
            "/*CouponAndGift End*/\n" +
            "\n" +
            "/*CustomerReview Begin*/\n" +
            ".CustomerReviewProduct\n" +
            "{\n" +
            "    clear: left;\n" +
            "    width: 100%;\n" +
            "    display: table;\n" +
            "}\n" +
            ".CustomerReviewContent\n" +
            "{\n" +
            "    float: right;\n" +
            "    width: 50%;\n" +
            "    padding-top: 10px;\n" +
            "    margin-left: 2%;\n" +
            "}\n" +
            ".CustomerReviewProductDetail\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 45%;\n" +
            "    padding: 10px;\n" +
            "}\n" +
            ".CustomerReviewProductDetail .ProductImage\n" +
            "{\n" +
            "    width: 40%;\n" +
            "    float: left;\n" +
            "}\n" +
            ".CustomerReviewProductDetail .ProductInfo\n" +
            "{\n" +
            "    width: 55%;\n" +
            "    margin-left: 2%;\n" +
            "    float: left;\n" +
            "}\n" +
            ".CustomerReviewProductDetail a.InfoName\n" +
            "{\n" +
            "    font-size: 14px;\n" +
            "    text-decoration: none;\n" +
            "    color: #000;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".CustomerReviewProductDetail a.InfoName:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".CustomerReviewProductDetail .InfoSku\n" +
            "{\n" +
            "    clear: left;\n" +
            "    font-size: 11px;\n" +
            "    float: left;\n" +
            "    margin-top: 15px;\n" +
            "    margin-bottom: 10px;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".CustomerReviewProductDetail .InfoRating\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin-bottom: 10px;\n" +
            "    width: 100%;\n" +
            "    padding: 10px 0;\n" +
            "    border-top: solid 1px #eee;\n" +
            "    border-bottom: solid 1px #eee;\n" +
            "}\n" +
            ".CustomerReviewProductDetail .InfoTitleLabel\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin-right: 10px;\n" +
            "    color: #000;\n" +
            "}\n" +
            ".CustomerReviewProductDetail .RatingCustomerDiv\n" +
            "{\n" +
            "    float: left;\n" +
            "}\n" +
            ".CustomerReviewProductDetail .RatingCustomerMessageDiv\n" +
            "{\n" +
            "    font-size: 12px;\n" +
            "}\n" +
            ".CustomerReviewProductDetail .InfoShortDescription\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 10px 0;\n" +
            "    width: 100%;\n" +
            "    font-size: 12px;\n" +
            "    line-height: 22px;\n" +
            "}\n" +
            ".CustomerReviewProductDetail .RetailPriceValue\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    font-size: 12px;\n" +
            "    text-decoration: line-through;\n" +
            "    margin-top: 5px;\n" +
            "}\n" +
            ".CustomerReviewProductDetail .InfoPrice\n" +
            "{\n" +
            "    clear: left;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    font-size: 16px;\n" +
            "    font-weight: normal;\n" +
            "    line-height: 30px;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ReviewIntroHeader\n" +
            "{\n" +
            "    font-size: 14px;\n" +
            "    clear: left;\n" +
            "    color: #000;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    margin-bottom: 15px;\n" +
            "}\n" +
            ".ReviewIntroMessage\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    margin-bottom: 7px;\n" +
            "    font-size: 13px;\n" +
            "    padding-bottom: 13px;\n" +
            "    border-bottom: solid 1px #eee;\n" +
            "    line-height: 20px;\n" +
            "}\n" +
            ".CustomerReviewContent .ReviewTitle\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    font-size: 14px;\n" +
            "    margin: 10px 0;\n" +
            "}\n" +
            ".ReviewSubjectRow\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    margin: 7px 0;\n" +
            "}\n" +
            ".CustomerReviewContent .InfoTitleLabel\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 30%;\n" +
            "    color: #000;\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            ".CustomerReviewMessageDiv .ReviewIntroMessage\n" +
            "{\n" +
            "    border: 0;\n" +
            "    margin: 0;\n" +
            "    padding: 0;\n" +
            "}\n" +
            ".CustomerReviewMessageTextBox\n" +
            "{\n" +
            "    float: right;\n" +
            "    margin-right: 2%;\n" +
            "    width: 65% !important;\n" +
            "}\n" +
            ".CustomerReviewStarList\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 5px 0;\n" +
            "    padding: 7px 3%;\n" +
            "    background-color: #fff;\n" +
            "    border: solid 1px #eee;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ReviewGuide\n" +
            "{\n" +
            "    display: block;\n" +
            "}\n" +
            "ul.ReviewGuide\n" +
            "{\n" +
            "    list-style-type: none;\n" +
            "}\n" +
            "ul.ReviewGuide li\n" +
            "{\n" +
            "    color: #000;\n" +
            "    background: url(Images/Bullet/bullet5.gif) no-repeat left 5px;\n" +
            "    line-height: 22px;\n" +
            "    font-size: 13px;\n" +
            "    padding-left: 15px;\n" +
            "}\n" +
            ".CustomerReviewMessageDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    margin: 10px 0;\n" +
            "}\n" +
            ".CustomerReviewMessageFromDiv\n" +
            "{\n" +
            "    margin: 5px 0;\n" +
            "}\n" +
            ".CustomerReviewLabel\n" +
            "{\n" +
            "    padding: 4px;\n" +
            "}\n" +
            ".CustomerReviewButtonDiv\n" +
            "{\n" +
            "    clear: both;\n" +
            "    float: right;\n" +
            "    margin-right: 1%;\n" +
            "    text-align: right;\n" +
            "}\n" +
            ".CustomerReviewButtonDiv .BtnStyle1\n" +
            "{\n" +
            "    background-color: #ff7200;\n" +
            "}\n" +
            ".CustomerReviewButtonDiv .BtnStyle1:hover\n" +
            "{\n" +
            "    background-color: #000;\n" +
            "}\n" +
            ".CustomerReviewRatingLoginPanel\n" +
            "{\n" +
            "    margin-bottom: 25px;\n" +
            "}\n" +
            ".CustomerReviewValidatorText\n" +
            "{\n" +
            "    float: right;\n" +
            "    margin-right: 2%;\n" +
            "    width: 65%;\n" +
            "}\n" +
            ".CustomerReviewValidateDiv\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".CustomerReviewStarRatingValidatorText\n" +
            "{\n" +
            "    float: right;\n" +
            "    margin-right: 2%;\n" +
            "    width: 65%;\n" +
            "}\n" +
            ".CustomerReviewStarRatingValidateDiv\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    float: left;\n" +
            "}\n" +
            ".CustomerReviewStarRatingDiv .CustomerReviewStarRatingValidatorText\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "}\n" +
            "/*CustomerReview End*/\n" +
            "\n" +
            "/*Error404 Begin*/\n" +
            ".Error404Content\n" +
            "{\n" +
            "    /*color: Red;*/\n" +
            "}\n" +
            ".Error404Content a\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    text-decoration: underline;\n" +
            "    cursor: pointer;\n" +
            "}\n" +
            ".Error404Content ul li\n" +
            "{\n" +
            "    margin-bottom: 5px;\n" +
            "}\n" +
            "/*Error404 End*/\n" +
            "/*FileDownload Begin*/\n" +
            ".FileDownloadErrorContent\n" +
            "{\n" +
            "    color: Red;\n" +
            "}\n" +
            "/*FileDownload End*/\n" +
            "/*FileDownloadManager Begin*/\n" +
            ".FileDownloadManagerContent\n" +
            "{\n" +
            "    color: Red;\n" +
            "}\n" +
            "/*FileDownloadManager End*/\n" +
            "/*GenericError Begin*/\n" +
            ".GenericErrorContent\n" +
            "{\n" +
            "    /*color: Red;*/\n" +
            "}\n" +
            ".GenericErrorContent a\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    text-decoration: underline;\n" +
            "    cursor: pointer;\n" +
            "}\n" +
            ".GenericErrorContentDiv\n" +
            "{\n" +
            "    line-height: 30px;\n" +
            "}\n" +
            ".GenericErrorContent ul li\n" +
            "{\n" +
            "    margin-bottom: 5px;\n" +
            "}\n" +
            "/*GenericError End*/\n" +
            "/*PasswordRecoveryFinished Begin*/\n" +
            ".PasswordRecoveryFinishedParagraph\n" +
            "{\n" +
            "    line-height: 24px;\n" +
            "}\n" +
            "/*PasswordRecoveryFinished End*/\n" +
            "/*ResetPassword Begin*/\n" +
            ".ResetPasswordContent\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            "/*ResetPassword End*/\n" +
            "/*TellFriend Begin*/\n" +
            ".TellFriendFormDiv\n" +
            "{\n" +
            "}\n" +
            "\n" +
            "input[type=\"text\"].TellFriendTextBox, input[type=\"text\"].TellFriendLongTextBox\n" +
            "{\n" +
            "    width: 90%;\n" +
            "    margin-bottom: 3px;\n" +
            "}\n" +
            "\n" +
            ".TellFriendImageButtonDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: right;\n" +
            "    margin-top: 20px;\n" +
            "}\n" +
            ".TellFriendImageButtonDiv .BtnStyle1\n" +
            "{\n" +
            "    background-color: #ff7200;\n" +
            "}\n" +
            ".TellFriendImageButtonDiv .BtnStyle1:hover\n" +
            "{\n" +
            "    background-color: #000;\n" +
            "}\n" +
            ".TellFriendFormData\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 50%;\n" +
            "    padding-top: 2px;\n" +
            "    padding-bottom: 2px;\n" +
            "}\n" +
            ".TellFriendFormLabel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 20%;\n" +
            "    padding-top: 2px;\n" +
            "    padding-bottom: 2px;\n" +
            "    line-height: 25px;\n" +
            "    height: 25px;\n" +
            "    margin-bottom: 5px;\n" +
            "    margin-left: 5%;\n" +
            "}\n" +
            ".TellFriendFormTextEditorDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 70%;\n" +
            "    margin-left: 25%;\n" +
            "}\n" +
            ".TellFriendMessageTextBox\n" +
            "{\n" +
            "    width: 90%;\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            ".TellFriendCapchaDiv\n" +
            "{\n" +
            "    border: 0;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 60%;\n" +
            "    margin-left: 25%;\n" +
            "}\n" +
            ".TellFriendCapchaDiv .CommonPageInnerTitle\n" +
            "{\n" +
            "    text-transform: capitalize;\n" +
            "    font-size: 14px;\n" +
            "}\n" +
            ".TellFriendCaptchaStyle div\n" +
            "{\n" +
            "    clear: left;\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            "\n" +
            ".TellFriendCaptchaStyle div input[type=\"text\"]\n" +
            "{\n" +
            "    margin-top: 5px;\n" +
            "    width: 60%;\n" +
            "}\n" +
            "\n" +
            ".TellFriendValidate\n" +
            "{\n" +
            "    width: 90%;\n" +
            "}\n" +
            ".TellFriendValidateLong\n" +
            "{\n" +
            "    width: 90%;\n" +
            "}\n" +
            "/*TellFriend End*/\n" +
            "/*TellFriendFinished Begin*/\n" +
            ".TellFriendFinishedDiv\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            ".TellFriendFinishedMessage\n" +
            "{\n" +
            "    margin-top: 40px;\n" +
            "    margin-bottom: 40px;\n" +
            "}\n" +
            "\n" +
            ".TellFriendFinishedImageIcon\n" +
            "{\n" +
            "    margin-top: 20px;\n" +
            "}\n" +
            "/*TellFriendFinished End*/\n" +
            "/*-------------------------------------------------*/\n" +
            "/*-------------------------------------------------*/\n" +
            "\n" +
            "/*ContentMenuNavNormalList Begin*/\n" +
            ".ContentMenuNavNormalList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            "\n" +
            ".ContentMenuNavNormalList a\n" +
            "{\n" +
            "    padding-left: 30px;\n" +
            "    width: 182px;\n" +
            "    height: 100%;\n" +
            "    line-height: 22px;\n" +
            "    vertical-align: middle;\n" +
            "    display: block;\n" +
            "    background: url(Images/Bullet/Bullet3.gif) no-repeat 15px 7px;\n" +
            "    color: #555;\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            "\n" +
            ".ContentMenuNavNormalTopList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".HeaderMenuRight .ContentMenuNavNormalTopList .SidebarTop\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "\n" +
            ".HeaderMenuRight .ContentMenuNavNormalTopList\n" +
            "{\n" +
            "    width: auto;\n" +
            "    border: 0 none;\n" +
            "    margin-top: 0px;\n" +
            "}\n" +
            "/*ContentMenuNavNormalList End*/\n" +
            "\n" +
            "/*ContentMenuNavList [Left,Right] Begin*/\n" +
            "\n" +
            ".MainDivLeft .ContentMenuNavList, .MainDivRight .ContentMenuNavList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    margin-bottom: 20px;\n" +
            "    clear: left;\n" +
            "}\n" +
            ".MainDivLeft .ContentMenuNavMenuList, .MainDivRight .ContentMenuNavMenuList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ContentMenuNavMenuListStaticMenuItem td a\n" +
            "{\n" +
            "    padding: 3px 0px;\n" +
            "    width: inherit;\n" +
            "    vertical-align: middle;\n" +
            "    display: block;\n" +
            "    color: #000;\n" +
            "    text-decoration: none;\n" +
            "    white-space: normal;\n" +
            "    font-size: 13px !important;\n" +
            "}\n" +
            "\n" +
            ".ContentMenuNavMenuListStaticMenuItem:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".ContentMenuNavMenuListDynamicMenuItem\n" +
            "{\n" +
            "    z-index: 0;\n" +
            "}\n" +
            ".ContentMenuNavMenuListDynamicMenuItem a\n" +
            "{\n" +
            "    z-index: 0;\n" +
            "    display: block;\n" +
            "    vertical-align: middle;\n" +
            "    color: #000;\n" +
            "    background: none;\n" +
            "    padding: 4px 15px;\n" +
            "    width: 160px;\n" +
            "    white-space: normal;\n" +
            "    font-size: 13px !important;\n" +
            "}\n" +
            ".ContentMenuNavMenuListDynamicMenuItem:hover\n" +
            "{\n" +
            "    background-color: #f2f2f2;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".ContentMenuNavMenuListDynamicMenuStyle\n" +
            "{\n" +
            "    z-index: 100 !important;\n" +
            "    margin: 0;\n" +
            "    border: solid 1px #ddd;\n" +
            "}\n" +
            ".ContentMenuNavMenuListDynamicMenuItem img\n" +
            "{\n" +
            "    width: 0;\n" +
            "    height: 0;\n" +
            "    background: url(Images/Icon/arrow-left.png) no-repeat center center;\n" +
            "    padding: 10px;\n" +
            "}\n" +
            "\n" +
            "\n" +
            "/*ContentMenuNavList [Left,Right] End*/\n" +
            "\n" +
            "\n" +
            "/*ContentMenuItem Begin*/\n" +
            "\n" +
            ".ContentMenuItemColumnTopicStyle\n" +
            "{\n" +
            "    padding-top: 4px;\n" +
            "    padding-bottom: 4px;\n" +
            "    padding-left: 10px;\n" +
            "    border-bottom: solid 1px #e4e4e4;\n" +
            "}\n" +
            "\n" +
            ".ContentMenuItemColumnTopicStyle a\n" +
            "{\n" +
            "    text-decoration: none;\n" +
            "    margin-left: 7px;\n" +
            "}\n" +
            "\n" +
            ".ContentMenuItemColumnTopicStyle a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            "/*ContentMenuItem End*/\n" +
            "\n" +
            "/*AdvancedContentSearchResult Begin*/\n" +
            ".AdvancedContentSearchResult .CommonPage, .AdvancedContentSearchResult .CommonPageTop, .AdvancedContentSearchResult .CommonPageLeft, .AdvancedContentSearchResult .CommonPageBottom\n" +
            "{\n" +
            "    width: auto;\n" +
            "}\n" +
            "/*AdvancedContentSearchResult End*/\n" +
            "\n" +
            "\n" +
            "\n" +
            ".MainDivCenter .Default\n" +
            "{\n" +
            "    width: inherit;\n" +
            "}\n" +
            "\n" +
            "#uxValidSummary\n" +
            "{\n" +
            "    margin-left: 10px;\n" +
            "}\n" +
            "#at20mc form\n" +
            "{\n" +
            "    background-image: none;\n" +
            "}\n" +
            "\n" +
            ".PriceRequireLoginMessage\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    background-color: #F9F9F9;\n" +
            "    border: solid 1px #CCCCCC;\n" +
            "    color: #666666;\n" +
            "    font-size: 10px;\n" +
            "    font-weight: normal;\n" +
            "    margin-bottom: 1em;\n" +
            "    overflow: hidden;\n" +
            "    padding: 5px 0;\n" +
            "    width: 100%;\n" +
            "}\n" +
            "/*RecentlyViewList Begin*/\n" +
            ".RecentlyViewedList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".RecentlyViewedList a\n" +
            "{\n" +
            "    padding: 3px 0px;\n" +
            "    width: inherit;\n" +
            "    vertical-align: middle;\n" +
            "    display: block;\n" +
            "    color: #000;\n" +
            "    text-decoration: none;\n" +
            "    white-space: normal;\n" +
            "}\n" +
            "\n" +
            ".RecentlyViewedList a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".RecentlyViewedList .ImageRecentPost\n" +
            "{\n" +
            "    width: 30%;\n" +
            "    display: table-cell;\n" +
            "}\n" +
            ".RecentlyViewedList .RecentlyItemImageDiv\n" +
            "{\n" +
            "    width: 90% !important;\n" +
            "    height: 50% !important;\n" +
            "    padding: 1px;\n" +
            "    border: solid 1px #ddd !important;\n" +
            "}\n" +
            ".RecentlyViewedList .RecentlyItemName\n" +
            "{\n" +
            "    color: #000;\n" +
            "    vertical-align: middle;\n" +
            "    border: none;\n" +
            "    font-size: 12px;\n" +
            "    text-decoration: none;\n" +
            "    display: table-cell;\n" +
            "    padding-left: 5px;\n" +
            "}\n" +
            ".RecentlyViewedList td\n" +
            "{\n" +
            "    padding-bottom: 10px;\n" +
            "}\n" +
            "/*RecentlyViewList End*/\n" +
            "/*CompareProductList Begin*/\n" +
            ".CompareProductList\n" +
            "{\n" +
            "    width: 95%;\n" +
            "    margin: 0 auto;\n" +
            "}\n" +
            "\n" +
            ".CompareProductListPopUpList .ProductListItemButtonDiv\n" +
            "{\n" +
            "    float: none;\n" +
            "    margin: 5px auto;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".CompareProductListPopUpList\n" +
            "{\n" +
            "    vertical-align: top;\n" +
            "    margin: 10px auto;\n" +
            "    background-color: #fff;\n" +
            "}\n" +
            ".ItemListTD\n" +
            "{\n" +
            "    width: 290px;\n" +
            "    vertical-align: top;\n" +
            "    border-bottom: solid 1px #ccc;\n" +
            "    padding: 5px;\n" +
            "}\n" +
            ".ItemList\n" +
            "{\n" +
            "    width: 290px;\n" +
            "    vertical-align: top;\n" +
            "    border: solid 1px #ccc;\n" +
            "}\n" +
            ".RowDiv\n" +
            "{\n" +
            "    display: table-row;\n" +
            "    border-top: solid 1px #ccc;\n" +
            "}\n" +
            "\n" +
            ".CompareListBoxViewAll\n" +
            "{\n" +
            "    margin: 10px 3px;\n" +
            "    float: left;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            "\n" +
            ".CompareListBoxClearAll\n" +
            "{\n" +
            "    margin: 10px 3px;\n" +
            "    float: right;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            "\n" +
            ".CompareListBoxViewAll:hover, .CompareListBoxClearAll:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            "\n" +
            ".CompareProductList td\n" +
            "{\n" +
            "    background: url( Images/Background/dot-line.jpg) repeat-x left bottom;\n" +
            "}\n" +
            ".CompareProductList a\n" +
            "{\n" +
            "    padding: 6px 0px;\n" +
            "    width: 90%;\n" +
            "    height: 100%;\n" +
            "    text-decoration: none;\n" +
            "    white-space: normal;\n" +
            "    float: left;\n" +
            "    font-size: 12px;\n" +
            "    color: #000;\n" +
            "}\n" +
            ".CompareProductList a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".CompareProductList a img\n" +
            "{\n" +
            "    width: 30px;\n" +
            "    height: 30px;\n" +
            "    border: 1px solid #f0f0f0;\n" +
            "    float: left;\n" +
            "    margin-right: 10px;\n" +
            "}\n" +
            ".CompareProductList a span\n" +
            "{\n" +
            "    line-height: 16px;\n" +
            "    width: 120px;\n" +
            "}\n" +
            ".CompareProductList .CompareProductDelete a\n" +
            "{\n" +
            "    float: right;\n" +
            "    margin-top: 7px;\n" +
            "    width: 10px;\n" +
            "    padding: 0;\n" +
            "    color: #ff7900;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            "/*CompareProductList End*/\n" +
            "/*Compareison List Popup Begin*/\n" +
            ".ComparePopupBody\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    margin: 0px;\n" +
            "    padding: 10px 30px;\n" +
            "}\n" +
            ".ComparePopupDiv\n" +
            "{\n" +
            "    margin: 0 auto;\n" +
            "}\n" +
            "\n" +
            ".CompareProductAddtoCart a\n" +
            "{\n" +
            "    float: none;\n" +
            "    width: 100px;\n" +
            "    margin: 10px auto;\n" +
            "}\n" +
            ".CompareName\n" +
            "{\n" +
            "    width: 295px;\n" +
            "    white-space: normal;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".CompareProductName\n" +
            "{\n" +
            "    height: 36px;\n" +
            "    line-height: 18px;\n" +
            "}\n" +
            ".CompareProductName .hidecallout\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".CompareProductName .showcallout\n" +
            "{\n" +
            "    background-color: #ccc; /*shadow color*/\n" +
            "    color: inherit;\n" +
            "    margin-left: 4px;\n" +
            "    margin-top: 4px;\n" +
            "    position: absolute;\n" +
            "    z-index: 100;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductName .showcallout .shadow, .showcallout .content\n" +
            "{\n" +
            "    position: relative;\n" +
            "    bottom: 2px;\n" +
            "    right: 2px;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductName .showcallout .shadow\n" +
            "{\n" +
            "    background-color: #555; /*shadow color*/\n" +
            "    color: inherit;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductName .showcallout .content\n" +
            "{\n" +
            "    background-color: #fff; /*background color of content*/\n" +
            "    color: #000; /*text color of content*/\n" +
            "    border: 1px solid #000; /*border color*/\n" +
            "    padding: .5em 2ex;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductShortDes\n" +
            "{\n" +
            "    height: 45px;\n" +
            "}\n" +
            ".CompareProductShortDes .hidecallout\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".CompareProductShortDes .showcallout\n" +
            "{\n" +
            "    background-color: #ccc; /*shadow color*/\n" +
            "    color: inherit;\n" +
            "    margin-left: 4px;\n" +
            "    margin-top: 4px;\n" +
            "    position: absolute;\n" +
            "    z-index: 100;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductShortDes .showcallout .shadow, .showcallout .content\n" +
            "{\n" +
            "    position: relative;\n" +
            "    bottom: 2px;\n" +
            "    right: 2px;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductShortDes .showcallout .shadow\n" +
            "{\n" +
            "    background-color: #555; /*shadow color*/\n" +
            "    color: inherit;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductShortDes .showcallout .content\n" +
            "{\n" +
            "    background-color: #fff; /*background color of content*/\n" +
            "    color: #000; /*text color of content*/\n" +
            "    border: 1px solid #000; /*border color*/\n" +
            "    padding: .5em 2ex;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductLongDes\n" +
            "{\n" +
            "    height: 70px;\n" +
            "    overflow: hidden;\n" +
            "}\n" +
            ".CompareProductLongDes .hidecallout\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".CompareProductLongDes .showcallout\n" +
            "{\n" +
            "    background-color: #ccc; /*shadow color*/\n" +
            "    color: inherit;\n" +
            "    margin-left: 4px;\n" +
            "    margin-top: 4px;\n" +
            "    position: absolute;\n" +
            "    z-index: 100;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductLongDes .showcallout .shadow, .showcallout .content\n" +
            "{\n" +
            "    position: relative;\n" +
            "    bottom: 2px;\n" +
            "    right: 2px;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductLongDes .showcallout .shadow\n" +
            "{\n" +
            "    background-color: #555; /*shadow color*/\n" +
            "    color: inherit;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductLongDes .showcallout .content\n" +
            "{\n" +
            "    background-color: #fff; /*background color of content*/\n" +
            "    color: #000; /*text color of content*/\n" +
            "    border: 1px solid #000; /*border color*/\n" +
            "    padding: .5em 2ex;\n" +
            "    width: 280px;\n" +
            "}\n" +
            "\n" +
            ".CompareProductSku\n" +
            "{\n" +
            "    height: 20px;\n" +
            "}\n" +
            ".CompareProductSku .hidecallout\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".CompareProductSku .showcallout\n" +
            "{\n" +
            "    background-color: #ccc; /*shadow color*/\n" +
            "    color: inherit;\n" +
            "    margin-left: 4px;\n" +
            "    margin-top: 4px;\n" +
            "    position: absolute;\n" +
            "    z-index: 100;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductSku .showcallout .shadow, .showcallout .content\n" +
            "{\n" +
            "    position: relative;\n" +
            "    bottom: 2px;\n" +
            "    right: 2px;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductSku .showcallout .shadow\n" +
            "{\n" +
            "    background-color: #555; /*shadow color*/\n" +
            "    color: inherit;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductSku .showcallout .content\n" +
            "{\n" +
            "    background-color: #fff; /*background color of content*/\n" +
            "    color: #000; /*text color of content*/\n" +
            "    border: 1px solid #000; /*border color*/\n" +
            "    padding: .5em 2ex;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductRetailPrice\n" +
            "{\n" +
            "    height: 20px;\n" +
            "}\n" +
            ".CompareProductPrice\n" +
            "{\n" +
            "    height: 20px;\n" +
            "}\n" +
            ".CompareProductModel\n" +
            "{\n" +
            "    height: 20px;\n" +
            "}\n" +
            ".CompareProductModel .hidecallout\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".CompareProductModel .showcallout\n" +
            "{\n" +
            "    background-color: #ccc; /*shadow color*/\n" +
            "    color: inherit;\n" +
            "    margin-left: 4px;\n" +
            "    margin-top: 4px;\n" +
            "    position: absolute;\n" +
            "    z-index: 100;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductModel .showcallout .shadow, .showcallout .content\n" +
            "{\n" +
            "    position: relative;\n" +
            "    bottom: 2px;\n" +
            "    right: 2px;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductModel .showcallout .shadow\n" +
            "{\n" +
            "    background-color: #555; /*shadow color*/\n" +
            "    color: inherit;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductModel .showcallout .content\n" +
            "{\n" +
            "    background-color: #fff; /*background color of content*/\n" +
            "    color: #000; /*text color of content*/\n" +
            "    border: 1px solid #000; /*border color*/\n" +
            "    padding: .5em 2ex;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductSpecification\n" +
            "{\n" +
            "    height: 36px;\n" +
            "    line-height: 18px;\n" +
            "}\n" +
            ".CompareProductUPC\n" +
            "{\n" +
            "    height: 20px;\n" +
            "}\n" +
            ".CompareProductWeight\n" +
            "{\n" +
            "    height: 20px;\n" +
            "}\n" +
            ".CompareProductManufacturerPartNumber\n" +
            "{\n" +
            "    height: 20px;\n" +
            "}\n" +
            ".CompareProductManufacturer\n" +
            "{\n" +
            "    height: 20px;\n" +
            "}\n" +
            ".CompareProductManufacturer .hidecallout\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".CompareProductManufacturer .showcallout\n" +
            "{\n" +
            "    background-color: #ccc; /*shadow color*/\n" +
            "    color: inherit;\n" +
            "    margin-left: 4px;\n" +
            "    margin-top: 4px;\n" +
            "    position: absolute;\n" +
            "    z-index: 100;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductManufacturer .showcallout .shadow, .showcallout .content\n" +
            "{\n" +
            "    position: relative;\n" +
            "    bottom: 2px;\n" +
            "    right: 2px;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductManufacturer .showcallout .shadow\n" +
            "{\n" +
            "    background-color: #555; /*shadow color*/\n" +
            "    color: inherit;\n" +
            "    width: 280px;\n" +
            "}\n" +
            ".CompareProductManufacturer .showcallout .content\n" +
            "{\n" +
            "    background-color: #fff; /*background color of content*/\n" +
            "    color: #000; /*text color of content*/\n" +
            "    border: 1px solid #000; /*border color*/\n" +
            "    padding: .5em 2ex;\n" +
            "    width: 280px;\n" +
            "}\n" +
            "\n" +
            ".CompareProductNameLink\n" +
            "{\n" +
            "    text-align: left;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    text-decoration: none;\n" +
            "    font-size: 11px;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".CompareProductImage\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    height: 65px;\n" +
            "}\n" +
            ".CompareLabel\n" +
            "{\n" +
            "    text-align: left;\n" +
            "    font-weight: normal;\n" +
            "    float: left;\n" +
            "}\n" +
            ".CompareProductImage img\n" +
            "{\n" +
            "    max-height: 65px;\n" +
            "    height: auto !important;\n" +
            "    height: 65px;\n" +
            "}\n" +
            ".ComparePopupGridView\n" +
            "{\n" +
            "    background-color: #fff;\n" +
            "    margin: 20px auto;\n" +
            "}\n" +
            "/*Compareison List Popup End*/\n" +
            "/*Onepage Checkout Begin*/\n" +
            ".OnePageCheckout\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    float: left;\n" +
            "}\n" +
            ".OnePageCheckout .CommonPageTop\n" +
            "{\n" +
            "    color: black;\n" +
            "    width: 100%;\n" +
            "    min-height: 35px;\n" +
            "    line-height: 25px;\n" +
            "    vertical-align: middle;\n" +
            "    text-align: left;\n" +
            "    font-size: 140%;\n" +
            "    font-weight: normal;\n" +
            "    text-transform: uppercase;\n" +
            "    padding: 4px 0px 10px;\n" +
            "    float: right;\n" +
            "}\n" +
            ".OnePageCheckout .CommonPageTopTitle\n" +
            "{\n" +
            "    font-size: inherit;\n" +
            "}\n" +
            "\n" +
            ".OnePageCheckoutRightControl\n" +
            "{\n" +
            "    width: 25%;\n" +
            "    float: right;\n" +
            "}\n" +
            ".OnePageCheckoutRightControl .MiniShoppingCart\n" +
            "{\n" +
            "    background: none;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin-bottom: 15px;\n" +
            "    padding: 5px 4% 10px;\n" +
            "    width: 90%;\n" +
            "}\n" +
            ".OnePageCheckoutRightControl .MiniShoppingCart .MiniShoppingCartSidebarTopTitle\n" +
            "{\n" +
            "    font-size: 14px;\n" +
            "    color: #333;\n" +
            "    margin: 0;\n" +
            "    padding: 0;\n" +
            "}\n" +
            ".OnePageCheckoutRightControl .MiniShoppingCart .SidebarTop\n" +
            "{\n" +
            "    background: none;\n" +
            "}\n" +
            ".OnePageCheckoutRightControl .MiniShoppingCart .SidebarLeft\n" +
            "{\n" +
            "    border: 0;\n" +
            "}\n" +
            ".OnePageCheckoutRightControl .MiniShoppingCart .SidebarTopImgLeft, .OnePageCheckoutRightControl .MiniShoppingCart .SidebarTopImgRight, .OnePageCheckoutRightControl .MiniShoppingCart .SidebarBottom, .OnePageCheckoutRightControl .MiniShoppingCart .MiniShoppingCartShowHidePanel, .OnePageCheckoutRightControl .MiniShoppingCart .MiniShoppingCartRecentlyPanel, .OnePageCheckoutRightControl .MiniShoppingCart .MiniShoppingCartButton\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".OnePageCheckoutRightControl .ShoppingCartGiftCouponInputCodeTextBox\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            "/*Onepage Checkout End*/\n" +
            "\n" +
            "\n" +
            "\n" +
            "/*ProductReturn Start */\n" +
            "\n" +
            ".ProductReturnSelectItem\n" +
            "{\n" +
            "    width: 25px;\n" +
            "}\n" +
            "\n" +
            ".ProductReturnQuantityItem\n" +
            "{\n" +
            "    width: 15%;\n" +
            "}\n" +
            "\n" +
            ".ProductReturnUnitPriceItem\n" +
            "{\n" +
            "    width: 15%;\n" +
            "}\n" +
            "\n" +
            ".ProductReturnDiv\n" +
            "{\n" +
            "    float: left;\n" +
            "    clear: left;\n" +
            "    margin-top: 10px;\n" +
            "    border: solid 1px #E1E1E1;\n" +
            "    padding: 10px 2%;\n" +
            "    width: 96%;\n" +
            "}\n" +
            "\n" +
            ".ProductReturnDropDown\n" +
            "{\n" +
            "    margin-bottom: 5px;\n" +
            "    border: solid 1px #ccc;\n" +
            "    width: 320px;\n" +
            "}\n" +
            "\n" +
            ".ProductReturnTextBox\n" +
            "{\n" +
            "    margin-bottom: 5px;\n" +
            "    border: solid 1px #ccc;\n" +
            "    width: 320px;\n" +
            "}\n" +
            "\n" +
            ".ProductReturnData\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 350px;\n" +
            "    margin-right: 30px;\n" +
            "    padding-top: 4px;\n" +
            "    padding-bottom: 4px;\n" +
            "}\n" +
            "\n" +
            ".ProductReturnAddButtonDiv\n" +
            "{\n" +
            "    float: right;\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            ".ProductReturnValidate\n" +
            "{\n" +
            "    width: 320px;\n" +
            "}\n" +
            "/*ProductReturn End */\n" +
            "/*RmaHistory Begin*/\n" +
            ".RmaHistoryGridView\n" +
            "{\n" +
            "    border: solid 1px #e4e4e4;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".RmaHistoryHeaderID, .RmaHistoryHeaderStatus, .RmaHistoryHeaderOrderID\n" +
            "{\n" +
            "    width: 15%;\n" +
            "}\n" +
            ".RmaHistoryGridViewRowStyle, .RmaHistoryGridViewAlternatingRowStyle\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".RmaHistoryHeaderName, .RmaHistoryName\n" +
            "{\n" +
            "    text-align: left;\n" +
            "}\n" +
            "\n" +
            "/*RmaHistory End*/\n" +
            "/*RmaDetail Begin*/\n" +
            ".RmaDetailDiv\n" +
            "{\n" +
            "    margin: 0px;\n" +
            "    width: 100%;\n" +
            "    clear: left;\n" +
            "}\n" +
            ".RmaDetailOrderIDLink\n" +
            "{\n" +
            "    text-decoration: none;\n" +
            "    border-bottom: dotted 1px #ccc;\n" +
            "}\n" +
            "\n" +
            ".RmaDetailOrderIDLink:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    border-bottom: dotted 1px rgb(155, 10 ,222);\n" +
            "}\n" +
            "\n" +
            "/*RmaDetail End*/\n" +
            "/*Product Kit Start*/\n" +
            ".ProductKitItemDetailsTop\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    margin-bottom: 5px;\n" +
            "}\n" +
            ".ProductKitGroupItemStyle .ProductKitItemDetailsTop\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-right: 5px;\n" +
            "    margin-top: -2px;\n" +
            "}\n" +
            "\n" +
            ".ProductKitGroupItemStyle .hidecallout\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "\n" +
            ".ProductKitGroupItemStyle .showcallout\n" +
            "{\n" +
            "    background-color: #ccc; /*shadow color*/\n" +
            "    color: inherit;\n" +
            "    position: absolute;\n" +
            "    z-index: 100;\n" +
            "    width: 200px;\n" +
            "    left: 100px;\n" +
            "}\n" +
            "\n" +
            ".ProductKitGroupItemStyle .showcallout .shadow\n" +
            "{\n" +
            "    background-color: #555; /*shadow color*/\n" +
            "    color: inherit;\n" +
            "    position: relative;\n" +
            "    bottom: 2px;\n" +
            "    right: 2px;\n" +
            "}\n" +
            "\n" +
            ".ProductKitGroupItemStyle .showcallout .content\n" +
            "{\n" +
            "    background-color: #fff; /*background color of content*/\n" +
            "    color: #000; /*text color of content*/\n" +
            "    border: 1px solid #000; /*border color*/\n" +
            "    padding: .5em 2ex;\n" +
            "    text-align: left;\n" +
            "    position: relative;\n" +
            "    bottom: 2px;\n" +
            "    right: 2px;\n" +
            "}\n" +
            "\n" +
            ".ProductKitGroupItem tr.quantityTR\n" +
            "{\n" +
            "    vertical-align: top;\n" +
            "}\n" +
            ".ProductKitGroupItem td.quantityTD\n" +
            "{\n" +
            "    width: 70px;\n" +
            "    float: left;\n" +
            "    padding: 5px 0;\n" +
            "    font-size: 14px;\n" +
            "}\n" +
            ".ProductKitGroupItem td.quantityTD input\n" +
            "{\n" +
            "    margin-bottom: 0;\n" +
            "    color: #4d4d4d;\n" +
            "    margin-top: 0;\n" +
            "}\n" +
            ".ProductKitGroupItem .quantityLabel\n" +
            "{\n" +
            "    width: 95%;\n" +
            "    text-align: right;\n" +
            "    float: left;\n" +
            "}\n" +
            ".ProductKitGroupItemQuantityText\n" +
            "{\n" +
            "    text-align: right;\n" +
            "    width: 40px;\n" +
            "}\n" +
            ".ProductKitGroupItem .quantityLabelRadio\n" +
            "{\n" +
            "    width: 75%;\n" +
            "    text-align: right;\n" +
            "    float: left;\n" +
            "    margin-top: 8px;\n" +
            "}\n" +
            ".ProductKitGroupItemQuantityTextRadio\n" +
            "{\n" +
            "    text-align: right;\n" +
            "    width: 40px;\n" +
            "    margin-top: 8px;\n" +
            "}\n" +
            ".ProductKitGroupItem .OptionRadioItemRadioButtonList tr\n" +
            "{\n" +
            "    display: table-row;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ProductKitOption .BtnStyle3\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin: auto;\n" +
            "    cursor: pointer;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ProductKitOptionPanel\n" +
            "{\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            "/*Product Kit End*/\n" +
            "\n" +
            "/* NewArrival for category Begin*/\n" +
            "/*NewArrivalCategoryItem Begin*/\n" +
            ".NewArrivalCategory .SidebarLeft\n" +
            "{\n" +
            "    border-top: 1px solid #DDDDDD;\n" +
            "}\n" +
            ".NewArrivalCategoryList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".NewArrivalCategoryList div.CommonProductImage\n" +
            "{\n" +
            "    width: 99%;\n" +
            "    max-height: 200px;\n" +
            "    padding: 0;\n" +
            "    margin-bottom: 0px;\n" +
            "    text-align: center;\n" +
            "    padding-top: 5px;\n" +
            "}\n" +
            ".NewArrivalCategoryList .QuickViewButtonPanel\n" +
            "{\n" +
            "    height: 330px !important;\n" +
            "    right: 1px;\n" +
            "    position: relative;\n" +
            "}\n" +
            ".NewArrival .QuickViewButtonPanel\n" +
            "{\n" +
            "    height: 363px !important;\n" +
            "}\n" +
            ".NewArrival .QuickViewButtonBorder\n" +
            "{\n" +
            "    height: 344px !important;\n" +
            "}\n" +
            ".NewArrival .CommonProductName\n" +
            "{\n" +
            "    margin-left: 15px;\n" +
            "}\n" +
            ".CommonProductItemStyle .NewArrivalCategoryItem\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    vertical-align: top;\n" +
            "    min-height: 370px;\n" +
            "    position: relative;\n" +
            "    display: table;\n" +
            "}\n" +
            ".NewArrivalCategoryItem .QuickViewButtonPanel\n" +
            "{\n" +
            "    height: 363px !important;\n" +
            "}\n" +
            "/*NewArrivalCategoryItem End*/\n" +
            "/* Content Layout Begin */\n" +
            ".ContactUsLink a\n" +
            "{\n" +
            "    height: 18px;\n" +
            "    line-height: 18px;\n" +
            "    padding: 0 10px;\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            ".ContactUsLink a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            "/* Content Layout End */\n" +
            "\n" +
            ".WarningMessage\n" +
            "{\n" +
            "    background-color: yellow;\n" +
            "    width: 100%;\n" +
            "    padding: 5px 0;\n" +
            "    font-weight: normal;\n" +
            "    color: Gray;\n" +
            "    font-size: 10px;\n" +
            "}\n" +
            ".WarningMessage .HeaderMenuStyle\n" +
            "{\n" +
            "    line-height: 20px;\n" +
            "    margin: 0 auto;\n" +
            "    vertical-align: middle;\n" +
            "    width: 940px;\n" +
            "}\n" +
            ".WarningMessage select\n" +
            "{\n" +
            "    margin-right: 90px;\n" +
            "    background-color: #fff;\n" +
            "}\n" +
            "/* ---------- MyAccount Master Begin --------- */\n" +
            ".account-center-col\n" +
            "{\n" +
            "    border-left: solid 1px #f1f1f1;\n" +
            "}\n" +
            "\n" +
            "/* MyAccountMenuList Begin */\n" +
            ".MyAccountMenuList .SidebarTop\n" +
            "{\n" +
            "    border-bottom: 0;\n" +
            "    background: url(Images/Bullet/account_icon.jpg) no-repeat left center;\n" +
            "    min-height: 50px;\n" +
            "    padding-left: 50px;\n" +
            "}\n" +
            ".MyAccountMenuList .SidebarTopTitle\n" +
            "{\n" +
            "    padding-left: 0;\n" +
            "    display: inline-block;\n" +
            "    font-size: 19px;\n" +
            "    color: #000;\n" +
            "    line-height: 20px;\n" +
            "    clear: left;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".MyAccountMenuList .MyAccountMenuListLoginName\n" +
            "{\n" +
            "    font-style: italic;\n" +
            "    font-size: 95%;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".MyAccountMenuList .NameLabel\n" +
            "{\n" +
            "}\n" +
            ".MyAccountMenuList .SidebarRight\n" +
            "{\n" +
            "    padding: 15px 0;\n" +
            "}\n" +
            "\n" +
            ".MyAccountMenuTableList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".MyAccountMenuTableList td\n" +
            "{\n" +
            "    padding: 15px 10px 15px 15px;\n" +
            "    border-bottom: solid 1px #f1f1f1;\n" +
            "}\n" +
            ".MyAccountMenuTableList a\n" +
            "{\n" +
            "    color: #000;\n" +
            "    padding-left: 30px;\n" +
            "    background: url(Images/Bullet/accountbullet.png) no-repeat left center;\n" +
            "}\n" +
            ".MyAccountMenuTableList a:hover, .MyAccountMenuTableList a:active\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    padding-left: 30px;\n" +
            "    background: url(Images/Bullet/accountbulletactive.jpg) no-repeat left center;\n" +
            "}\n" +
            "/* MyAccountMenuList End */\n" +
            "\n" +
            "/* MyAccountDashboard Begin */\n" +
            ".MyAccountDashboardDiv\n" +
            "{\n" +
            "    margin: 0px;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".MyAccountInfoPanel, .MyAccountMessagePanel\n" +
            "{\n" +
            "    margin: 0 0 20px 0;\n" +
            "    float: left;\n" +
            "    clear: left;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".MyAccountRecentOrder\n" +
            "{\n" +
            "    margin: 10px 0;\n" +
            "    float: left;\n" +
            "    clear: left;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".MyAccountRecentOrderDiv\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".MyAccountInfoPanel .Title\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    font-size: 16px;\n" +
            "    font-weight: normal;\n" +
            "    margin: 5px 0 15px;\n" +
            "    padding: 5px 0;\n" +
            "    line-height: 30px;\n" +
            "    color: #000;\n" +
            "    text-transform: uppercase;\n" +
            "    border-bottom: dotted 2px #f1f1f1;\n" +
            "}\n" +
            ".MyAccountInfoPanel .MyAccountInfoSubmitButton\n" +
            "{\n" +
            "    float: right;\n" +
            "    margin-top: 5px;\n" +
            "}\n" +
            ".MyAccountInfoPanel .MyAccountInfoSubmitButton a.BtnStyle4\n" +
            "{\n" +
            "    background: url(Images/Icon/down.gif) no-repeat right center;\n" +
            "    line-height: 20px;\n" +
            "    padding: 0 20px 0 0;\n" +
            "    font-size: 11px;\n" +
            "    text-transform: uppercase;\n" +
            "    border: 0;\n" +
            "    color: #5B5B5B;\n" +
            "    text-decoration: underline;\n" +
            "}\n" +
            ".MyAccountInfoPanel .Value\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    padding: 3px 0;\n" +
            "    font-size: 11px;\n" +
            "    color: #000;\n" +
            "}\n" +
            ".MyAccountRecentOrderDiv .SubmitButton\n" +
            "{\n" +
            "    float: right;\n" +
            "    clear: left;\n" +
            "    margin: 10px 0 0;\n" +
            "}\n" +
            ".MyAccountMessagePanel .Title\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    font-size: 16px;\n" +
            "    font-weight: normal;\n" +
            "    margin: 5px 0;\n" +
            "    line-height: 25px;\n" +
            "    color: #000;\n" +
            "}\n" +
            ".MyAccountMessagePanel .Value\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    font-size: 11px;\n" +
            "    line-height: 22px;\n" +
            "    color: #000;\n" +
            "}\n" +
            ".MyAccountTitle\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    font-size: 16px;\n" +
            "    margin: 5px 0 15px;\n" +
            "    font-weight: normal;\n" +
            "    padding: 5px 0;\n" +
            "    line-height: 30px;\n" +
            "    color: #000;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".MyAccountInfoPanel .AffiliateSubmitButton\n" +
            "{\n" +
            "    float: right;\n" +
            "    clear: left;\n" +
            "    margin: 60px 0 0;\n" +
            "}\n" +
            ".ShippingAddressBookPanel .Title\n" +
            "{\n" +
            "    margin: 0;\n" +
            "}\n" +
            ".MyAccountChangePasswordLink\n" +
            "{\n" +
            "    clear: left;\n" +
            "}\n" +
            ".MyAccountChangePasswordLink:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            "/* MyAccountDashboard End */\n" +
            "\n" +
            "/*ShippingAddressBook Begin*/\n" +
            ".ShippingAddressBookList\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    border-bottom: dotted 2px #f0f0f0;\n" +
            "}\n" +
            ".ShippingAddressBookList tr\n" +
            "{\n" +
            "    display: table-cell;\n" +
            "    width: 48%;\n" +
            "    margin-right: 2%;\n" +
            "    float: left;\n" +
            "}\n" +
            ".AccountDetailsShippingItemInfoPanel\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 10px 0 20px;\n" +
            "}\n" +
            ".ShippingAliasNameTitle\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 55%;\n" +
            "    font-size: 14px;\n" +
            "    font-weight: normal;\n" +
            "    line-height: 25px;\n" +
            "    color: #000;\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            ".ShippingAddress\n" +
            "{\n" +
            "    float: right;\n" +
            "    width: 40%;\n" +
            "}\n" +
            ".ShippingAddressData\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    padding: 2px 0;\n" +
            "    font-size: 11px;\n" +
            "    color: #000;\n" +
            "}\n" +
            ".ShippingAddressLabel\n" +
            "{\n" +
            "}\n" +
            ".ShippingAddressShippingResidentialPanel\n" +
            "{\n" +
            "}\n" +
            ".ShippingAddressLinkPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 55%;\n" +
            "    margin: 10px 0;\n" +
            "}\n" +
            ".ShippingAddressLinkPanel .BtnStyle2\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    display: block;\n" +
            "    padding: 0;\n" +
            "    margin: 10px 0;\n" +
            "    font-size: 12px;\n" +
            "}\n" +
            ".ShippingAddressBookButtonDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: right;\n" +
            "    padding: 20px;\n" +
            "}\n" +
            ".ShippingAddressBookButtonDiv .BtnStyle1\n" +
            "{\n" +
            "    background-color: #ff8112;\n" +
            "    padding: 0 30px;\n" +
            "}\n" +
            ".ShippingAddressBookButtonDiv .BtnStyle1:hover\n" +
            "{\n" +
            "    background-color: #000;\n" +
            "}\n" +
            "/*ShippingAddressBook End*/\n" +
            "\n" +
            "/*PasswordDetails Begin*/\n" +
            ".PasswordDetails\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin-top: 20px;\n" +
            "}\n" +
            ".PasswordDetailsDiv\n" +
            "{\n" +
            "}\n" +
            ".PasswordDetailsTable\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".PasswordDetailsTable td\n" +
            "{\n" +
            "    padding: 5px 0;\n" +
            "}\n" +
            ".PasswordDetailsLabelColumn\n" +
            "{\n" +
            "    width: 47%;\n" +
            "}\n" +
            ".PasswordDetailsInputColumn\n" +
            "{\n" +
            "    width: 47%;\n" +
            "}\n" +
            ".PasswordDetailsInputColumn .CommonAsterisk\n" +
            "{\n" +
            "    width: 6%;\n" +
            "}\n" +
            ".PasswordDetailsButtonDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: right;\n" +
            "    margin: 20px 4% 20px 0;\n" +
            "}\n" +
            ".PasswordDetailsSubmitLinkButtonImage\n" +
            "{\n" +
            "    border: 0;\n" +
            "}\n" +
            ".PasswordDetailsSubmitLinkButton\n" +
            "{\n" +
            "    background-color: #ff7200;\n" +
            "    display: block;\n" +
            "    float: left;\n" +
            "    font-size: 12px;\n" +
            "    line-height: 24px;\n" +
            "    margin: 0px 5px 2px 0px;\n" +
            "    padding: 0px 15px;\n" +
            "    text-decoration: none;\n" +
            "    vertical-align: middle;\n" +
            "    text-align: center;\n" +
            "    color: white;\n" +
            "}\n" +
            ".PasswordDetailsSubmitLinkButton:hover\n" +
            "{\n" +
            "    background-color: #000;\n" +
            "    color: white;\n" +
            "}\n" +
            ".PasswordDetailsTextBox\n" +
            "{\n" +
            "    margin: 5px 0;\n" +
            "    width: 90% !important;\n" +
            "}\n" +
            ".PasswordValidateDiv\n" +
            "{\n" +
            "    width: 90%;\n" +
            "}\n" +
            "/*PasswordDetails End*/\n" +
            "\n" +
            "\n" +
            "/*OrderHistory Begin*/\n" +
            "\n" +
            ".OrderHistoryGridviewDiv\n" +
            "{\n" +
            "    clear: both;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".OrderHistoryGridView th, .OrderHistoryGridView td\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    padding: 3px 1%;\n" +
            "}\n" +
            ".OrderHistoryItemsPerPageDiv .OptionControlTitle\n" +
            "{\n" +
            "    margin-right: 0;\n" +
            "}\n" +
            ".OrderHistoryGridOrderIDHeaderStyle\n" +
            "{\n" +
            "    width: 12%;\n" +
            "}\n" +
            ".OrderHistoryGridOrderDateHeaderStyle\n" +
            "{\n" +
            "    width: 18%;\n" +
            "}\n" +
            ".OrderHistoryGridTotalHeaderStyle\n" +
            "{\n" +
            "    width: 18%;\n" +
            "}\n" +
            ".OrderHistoryGridTrackingHeaderStyle\n" +
            "{\n" +
            "}\n" +
            ".OrderHistoryGridStatusHeaderStyle\n" +
            "{\n" +
            "    width: 13%;\n" +
            "}\n" +
            "/*OrderHistory End*/\n" +
            "\n" +
            "/*RewardPoint Begin*/\n" +
            ".RewardPointItemsPerPageDiv .OptionControlTitle\n" +
            "{\n" +
            "    margin-right: 0;\n" +
            "}\n" +
            ".RewardPointGridOrderIDHeaderStyle, .RewardPointGridOrderIDItemStyle, .RewardPointGridTotalFooterStyle\n" +
            "{\n" +
            "    text-align: left;\n" +
            "    padding-left: 20px;\n" +
            "    width: 30%;\n" +
            "}\n" +
            ".RewardPointGridTotalFooterStyle, .RewardPointGridPointFooterStyle, .RewardPointGridReferenceHeaderStyle\n" +
            "{\n" +
            "    text-align: left;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".RewardPointGridOrderDateHeaderStyle, .RewardPointGridPointItemStyle, .RewardPointGridPointItemStyle\n" +
            "{\n" +
            "    text-align: left;\n" +
            "    width: 15%;\n" +
            "}\n" +
            "/*RewardPoint End*/\n" +
            "\n" +
            "/*ContentSubscription Begin*/\n" +
            ".ContentSubscriptionGridviewDiv\n" +
            "{\n" +
            "    clear: both;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            ".ContentSubscriptionGridView td\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            "/*ContentSubscription End*/\n" +
            "\n" +
            "/*WishList Begin*/\n" +
            ".WishListGridView\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    color: #000;\n" +
            "}\n" +
            ".WishListGridViewRowStyle\n" +
            "{\n" +
            "    border-bottom: solid 1px #f0f0f0;\n" +
            "    background-color: #fff;\n" +
            "}\n" +
            ".WishListGridView .ImageHeader\n" +
            "{\n" +
            "    width: 15%;\n" +
            "}\n" +
            ".WishListGridView .ImageItem\n" +
            "{\n" +
            "    text-align: left;\n" +
            "    border-right: solid 1px #f0f0f0;\n" +
            "}\n" +
            ".WishListGridView .ImageItemDiv\n" +
            "{\n" +
            "    margin: 10px 5%;\n" +
            "    width: 90%;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".WishListGridView .DeleteHeader\n" +
            "{\n" +
            "    width: 5%;\n" +
            "}\n" +
            ".WishListGridView .DeleteItem\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    border-left: solid 1px #f0f0f0;\n" +
            "}\n" +
            ".WishListGridView .NameHeader\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".WishListGridView .NameItem a\n" +
            "{\n" +
            "    text-decoration: none;\n" +
            "    font-size: 14px;\n" +
            "    font-weight: normal;\n" +
            "    display: block;\n" +
            "    color: #000;\n" +
            "}\n" +
            ".WishListGridView .NameItem a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".WishListGridView .NameItem\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".WishListGridView .PriceHeader\n" +
            "{\n" +
            "    width: 17%;\n" +
            "}\n" +
            ".WishListGridView .PriceItem\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    border-left: solid 1px #f0f0f0;\n" +
            "    font-size: 14px;\n" +
            "}\n" +
            ".WishListGridView .QuantityHeader\n" +
            "{\n" +
            "    width: 13%;\n" +
            "}\n" +
            ".WishListGridView .QuantityItem\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    border-left: solid 1px #f0f0f0;\n" +
            "}\n" +
            ".WishListGridView .AddToCartHeader\n" +
            "{\n" +
            "    width: 17%;\n" +
            "}\n" +
            ".WishListGridView .AddToCartItem\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    border-left: solid 1px #f0f0f0;\n" +
            "    padding: 5px 1.5%;\n" +
            "}\n" +
            ".WishListGridView .AddToCartItem a\n" +
            "{\n" +
            "    margin: auto;\n" +
            "}\n" +
            ".WishListButtonDiv\n" +
            "{\n" +
            "    clear: both;\n" +
            "    margin: 10px auto 0;\n" +
            "    float: right;\n" +
            "}\n" +
            ".WishListContinueImageButton\n" +
            "{\n" +
            "    background-color: #ff7200;\n" +
            "    display: block;\n" +
            "    float: left;\n" +
            "    font-size: 12px;\n" +
            "    line-height: 24px;\n" +
            "    margin: 0px 5px 2px 0px;\n" +
            "    padding: 0px 15px;\n" +
            "    text-decoration: none;\n" +
            "    vertical-align: middle;\n" +
            "    text-align: center;\n" +
            "    color:White;\n" +
            "}\n" +
            "\n" +
            ".WishListContinueImageButton:hover\n" +
            "{\n" +
            "    color:White;\n" +
            "}\n" +
            "/*WishList End*/\n" +
            "\n" +
            "/*CompareList Begin*/\n" +
            ".CompareListGridView\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    color: #000;\n" +
            "}\n" +
            ".CompareListGridViewRowStyle\n" +
            "{\n" +
            "    border-bottom: solid 1px #f0f0f0;\n" +
            "    background-color: #fff;\n" +
            "}\n" +
            ".CompareListGridView .ImageHeader\n" +
            "{\n" +
            "    width: 15%;\n" +
            "}\n" +
            ".CompareListGridView .ImageItem\n" +
            "{\n" +
            "    text-align: left;\n" +
            "    border-right: solid 1px #f0f0f0;\n" +
            "}\n" +
            ".CompareListGridView .ImageItemDiv\n" +
            "{\n" +
            "    margin: 10px 5%;\n" +
            "    width: 90%;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".CompareListGridView .DeleteHeader\n" +
            "{\n" +
            "    width: 5%;\n" +
            "}\n" +
            ".CompareListGridView .DeleteItem\n" +
            "{\n";
    static String css4 =
            "    text-align: center;\n" +
            "    border-left: solid 1px #f0f0f0;\n" +
            "}\n" +
            ".CompareListGridView .NameHeader\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".CompareListGridView .NameItem\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".CompareListGridView .NameItem a\n" +
            "{\n" +
            "    text-decoration: none;\n" +
            "    font-size: 14px;\n" +
            "    font-weight: normal;\n" +
            "    display: block;\n" +
            "    color: #000;\n" +
            "}\n" +
            ".CompareListGridView .NameItem a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".CompareListGridView .NameItem\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".CompareListGridView .PriceHeader\n" +
            "{\n" +
            "    width: 17%;\n" +
            "}\n" +
            ".CompareListGridView .PriceItem\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    border-left: solid 1px #f0f0f0;\n" +
            "    font-size: 14px;\n" +
            "}\n" +
            ".CompareListGridView .AddToCartHeader\n" +
            "{\n" +
            "    width: 17%;\n" +
            "}\n" +
            ".CompareListGridView .AddToCartItem\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    border-left: solid 1px #f0f0f0;\n" +
            "    padding: 5px 1.5%;\n" +
            "}\n" +
            ".CompareListGridView .AddToCartItem a\n" +
            "{\n" +
            "    margin: auto;\n" +
            "}\n" +
            ".CompareListButtonDiv\n" +
            "{\n" +
            "    clear: both;\n" +
            "    margin: 10px auto 0;\n" +
            "    float: right;\n" +
            "}\n" +
            "/*CompareList End*/\n" +
            "\n" +
            "/*CustomerRegister Address Begin*/\n" +
            ".CustomerRegister\n" +
            "{\n" +
            "    width: 78%;\n" +
            "}\n" +
            ".CustomerRegister .ajax__htmleditor_editor_container\n" +
            "{\n" +
            "    width: 580px !important;\n" +
            "}\n" +
            ".AccountMainDiv .CustomerRegister\n" +
            "{\n" +
            "    width: 99%;\n" +
            "}\n" +
            ".CustomerRegisterShippingInfoPanel .Title\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    font-size: 19px;\n" +
            "    margin: 5px 0 15px;\n" +
            "    font-weight: normal;\n" +
            "    padding: 5px 0;\n" +
            "    line-height: 30px;\n" +
            "    color: #000;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".CustomerRegisterLeft, .CustomerRegisterRight, .CheckoutAddressLeft, .CheckoutAddressRight\n" +
            "{\n" +
            "    width: 48%;\n" +
            "    float: left;\n" +
            "    padding: 2px 0px;\n" +
            "    margin-right: 2%;\n" +
            "    margin-bottom: 4px;\n" +
            "}\n" +
            "\n" +
            ".CustomerRegisterLeftLabel, .CustomerRegisterRightLabel, .CheckoutAddressLeftLabel, .CheckoutAddressRightLabel\n" +
            "{\n" +
            "    width: 35%;\n" +
            "    float: left;\n" +
            "    padding: 2px 0px;\n" +
            "    margin-right: 2%;\n" +
            "    color: #000;\n" +
            "    clear: left;\n" +
            "    font-size: 13px;\n" +
            "    line-height: 25px;\n" +
            "    margin-left: 2.8%;\n" +
            "}\n" +
            ".CustomerRegisterLeft, .CheckoutAddressLeft\n" +
            "{\n" +
            "    clear: left;\n" +
            "}\n" +
            ".CustomerRegisterLeftData, .CustomerRegisterRightData, .CheckoutAddressLeftData, .CheckoutAddressRightData\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 60%;\n" +
            "    padding-top: 2px;\n" +
            "    padding-bottom: 2px;\n" +
            "}\n" +
            ".CustomerRegisterLeft .CustomerRegisterTextBox, .CustomerRegisterRight .CustomerRegisterTextBox, .CheckoutAddressLeft .CheckoutAddressTextBox, .CheckoutAddressRight .CheckoutAddressTextBox\n" +
            "{\n" +
            "    margin-bottom: 1px;\n" +
            "    width: 90%;\n" +
            "}\n" +
            ".CustomerRegisterLabel, .CheckoutAddressLabel\n" +
            "{\n" +
            "    width: 35%;\n" +
            "    float: left;\n" +
            "    padding: 2px 0px;\n" +
            "    margin-right: 2%;\n" +
            "    clear: left;\n" +
            "}\n" +
            ".CustomerRegisterLeftLabel2\n" +
            "{\n" +
            "    width: 35%;\n" +
            "    float: left;\n" +
            "    padding: 2px 0px;\n" +
            "    margin-right: 2%;\n" +
            "    clear: left;\n" +
            "}\n" +
            ".ClientCityStatePanel, .CustomerRegisterCityStatePanel\n" +
            "{\n" +
            "    width: 88%;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    padding: 3px 0px;\n" +
            "    margin-right: 2%;\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            ".CustomerRegisterPanel .ClientCityStatePanel .CustomerRegisterLabel\n" +
            "{\n" +
            "    margin-right: 2.2%;\n" +
            "}\n" +
            ".CustomerRegisterPanel .ClientCityStatePanel .CountryAndStateListDropDown\n" +
            "{\n" +
            "    width: 29.5%;\n" +
            "}\n" +
            "\n" +
            ".CustomerRegisterPanel .ClientCityStatePanel .CountryAndStateListDropDown\n" +
            "{\n" +
            "    margin-right: 0.6%;\n" +
            "}\n" +
            "\n" +
            ".CustomerRegisterShippingInfoPanel .CustomerRegisterCityStatePanel .CountryAndStateListDropDown\n" +
            "{\n" +
            "    width: 29.5%;\n" +
            "    margin-right: 0.6%;\n" +
            "}\n" +
            "\n" +
            ".CustomerRegisterShippingInfoPanel .CustomerRegisterCityStatePanel .CustomerRegisterLabel\n" +
            "{\n" +
            "    margin-right: 2.2%;\n" +
            "}\n" +
            "\n" +
            ".CustomerRegisterPanel .CommonFormLabel\n" +
            "{\n" +
            "}\n" +
            "\n" +
            ".ClientCityStatePanel .CustomerRegisterLabel, .CustomerRegisterCityStatePanel .CustomerRegisterLabel, .ClientCityStatePanel .CheckoutAddressLabel\n" +
            "{\n" +
            "    width: 18%;\n" +
            "    line-height: 25px;\n" +
            "    color: #000;\n" +
            "    margin-left: 1.5%;\n" +
            "}\n" +
            ".AccountDetailsDiv .CountryAndStateListDropDown, .CustomerRegisterCityStatePanel .CountryAndStateListDropDown, .ClientCityStatePanel .CountryAndStateListDropDown\n" +
            "{\n" +
            "    width: 30%;\n" +
            "    float: left;\n" +
            "    padding: 2px 0px;\n" +
            "    color: #79868c;\n" +
            "    border: solid 1px #eee;\n" +
            "    margin: 5px 1% 5px 0;\n" +
            "    font-size: 12px;\n" +
            "}\n" +
            ".AccountDetailsDiv .CountryAndStateListCountryTextBox, .AccountDetailsDiv .CountryAndStateListStateTextBox, .CustomerRegisterCityStatePanel .CountryAndStateListStateTextBox, .ClientCityStatePanel .CountryAndStateListCountryTextBox, .ClientCityStatePanel .CountryAndStateListStateTextBox, .CustomerRegisterShippingInfoPanel .CountryAndStateListCountryTextBox, ustomerRegisterShippingInfoPanel .CountryAndStateListStateTextBox\n" +
            "{\n" +
            "    width: 30%;\n" +
            "    float: left;\n" +
            "    margin: 5px 0;\n" +
            "}\n" +
            ".CountryAndStateListValidationPanel\n" +
            "{\n" +
            "    float: left;\n" +
            "    padding-top: 7px;\n" +
            "}\n" +
            ".CustomerRegisterLinkButtonDiv\n" +
            "{\n" +
            "    clear: both;\n" +
            "    float: right;\n" +
            "    margin: 20px 5.7% 20px 0;\n" +
            "}\n" +
            ".CustomerRegisterLinkButtonDiv .BtnStyle1\n" +
            "{\n" +
            "    background-color: #ff7200;\n" +
            "}\n" +
            ".CustomerRegisterLinkButtonDiv .BtnStyle1:hover\n" +
            "{\n" +
            "    background-color: #000;\n" +
            "}\n" +
            ".CustomerRegisterNote\n" +
            "{\n" +
            "    color: #ff0000;\n" +
            "    margin-top: 5px;\n" +
            "    margin-bottom: 5px;\n" +
            "    font-size: 80%;\n" +
            "}\n" +
            ".CustomerRegisterCheckBox\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 0 0 15px 18.5%;\n" +
            "}\n" +
            ".CustomerRegisterCheckBox label\n" +
            "{\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            ".CustomerRegisterPanelCountryValidatorText\n" +
            "{\n" +
            "    margin-left: 18%;\n" +
            "    width: 30%;\n" +
            "    clear: left;\n" +
            "}\n" +
            ".UseBillingCheckbox\n" +
            "{\n" +
            "    margin-bottom: 0;\n" +
            "}\n" +
            ".UseBillingCheckbox label\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            "/*CustomerRegister Address End*/\n" +
            "/* ---------- MyAccount Master End --------- */\n" +
            "/* CheckoutIndicator Begin */\n" +
            ".CheckoutIndicatorPanel\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    text-align: center;\n" +
            "    vertical-align: top;\n" +
            "    margin-bottom: 60px;\n" +
            "}\n" +
            "\n" +
            ".CheckoutIndicatorTable\n" +
            "{\n" +
            "    margin: 0;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".CheckoutIndicatorTable .CurrentPageTitle\n" +
            "{\n" +
            "    color: #000;\n" +
            "    width: 100%;\n" +
            "    min-height: 35px;\n" +
            "    line-height: 25px;\n" +
            "    vertical-align: middle;\n" +
            "    text-align: left;\n" +
            "    font-size: 19px;\n" +
            "    font-weight: normal;\n" +
            "    text-transform: uppercase;\n" +
            "    padding: 0 0 10px;\n" +
            "    border-bottom: 3px dotted rgb(184, 184, 184);\n" +
            "}\n" +
            ".CheckoutIndicatorTable td\n" +
            "{\n" +
            "    width: 21.667%;\n" +
            "}\n" +
            ".CheckoutIndicatorTable .LoginOn, .CheckoutIndicatorTable .LoginPassed, .CheckoutIndicatorTable .SummaryOff, .CheckoutIndicatorTable .SummaryOn\n" +
            "{\n" +
            "    width: 17.5%;\n" +
            "}\n" +
            "\n" +
            ".CheckoutIndicatorTable a\n" +
            "{\n" +
            "    display: block;\n" +
            "    width: 100%;\n" +
            "    height: 40px;\n" +
            "    line-height: 37px;\n" +
            "    text-align: center;\n" +
            "    padding-top: 30px;\n" +
            "    color: #000;\n" +
            "    font-size: 11px;\n" +
            "    font-weight: lighter;\n" +
            "    margin-top: 25px;\n" +
            "}\n" +
            ".CheckoutIndicatorTable a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".CheckoutIndicatorTable .LoginOn a\n" +
            "{\n" +
            "    background: url(Images/CheckoutPanel/LoginOn.jpg) no-repeat right center;\n" +
            "    padding-right: 10%;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".CheckoutIndicatorTable .LoginPassed a\n" +
            "{\n" +
            "    background: url(Images/CheckoutPanel/LoginOn.jpg) no-repeat right center;\n" +
            "    padding-right: 10%;\n" +
            "}\n" +
            ".CheckoutIndicatorTable .AddressOff a\n" +
            "{\n" +
            "    background: url(Images/CheckoutPanel/AddressOff.jpg) no-repeat center center;\n" +
            "}\n" +
            ".CheckoutIndicatorTable .AddressOn a\n" +
            "{\n" +
            "    background: url(Images/CheckoutPanel/AddressOn.jpg) no-repeat center center;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".CheckoutIndicatorTable .AddressPassed a\n" +
            "{\n" +
            "    background: url(Images/CheckoutPanel/AddressOn.jpg) no-repeat center center;\n" +
            "}\n" +
            ".CheckoutIndicatorTable .ShippingOff a\n" +
            "{\n" +
            "    background: url(Images/CheckoutPanel/ShippingOff.jpg) no-repeat center center;\n" +
            "}\n" +
            ".CheckoutIndicatorTable .ShippingOn a\n" +
            "{\n" +
            "    background: url(Images/CheckoutPanel/ShippingOn.jpg) no-repeat center center;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".CheckoutIndicatorTable .ShippingPassed a\n" +
            "{\n" +
            "    background: url(Images/CheckoutPanel/ShippingOn.jpg) no-repeat center center;\n" +
            "}\n" +
            ".CheckoutIndicatorTable .PaymentOff a\n" +
            "{\n" +
            "    background: url(Images/CheckoutPanel/PaymentOff.jpg) no-repeat center center;\n" +
            "}\n" +
            ".CheckoutIndicatorTable .PaymentOn a\n" +
            "{\n" +
            "    background: url(Images/CheckoutPanel/PaymentOn.jpg) no-repeat center center;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".CheckoutIndicatorTable .PaymentPassed a\n" +
            "{\n" +
            "    background: url(Images/CheckoutPanel/PaymentOn.jpg) no-repeat center center;\n" +
            "}\n" +
            ".CheckoutIndicatorTable .SummaryOff a\n" +
            "{\n" +
            "    background: url(Images/CheckoutPanel/SummaryOff.jpg) no-repeat left center;\n" +
            "    padding-left: 10%;\n" +
            "}\n" +
            ".CheckoutIndicatorTable .SummaryOn a\n" +
            "{\n" +
            "    background: url(Images/CheckoutPanel/SummaryOn.jpg) no-repeat left center;\n" +
            "    padding-left: 10%;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            "/* CheckoutIndicator End */\n" +
            "\n" +
            "/*Override CommonLoginPage for checkout Begin*/\n" +
            ".CheckoutLogin\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".CheckoutLogin .CommonLoginPage\n" +
            "{\n" +
            "    width: 90%;\n" +
            "    margin: 0 5%;\n" +
            "}\n" +
            ".CheckoutLogin .CommonLoginPageRight\n" +
            "{\n" +
            "    padding: 0;\n" +
            "    width: 100%;\n" +
            "}\n" +
            "/*Override CommonLoginPage End*/\n" +
            "\n" +
            "/* OrderSummaryRightMenu Begin */\n" +
            ".OrderSummaryRightMenu\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    margin-top: -12px;\n" +
            "}\n" +
            ".OrderSummaryRightMenu .SidebarRight\n" +
            "{\n" +
            "    padding: 20px 0;\n" +
            "}\n" +
            ".OrderSummaryRightMenu .ShoppingCartDetail\n" +
            "{\n" +
            "    line-height: 20px;\n" +
            "    font-size: 11px;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".OrderSummaryRightMenu .TotalDetail\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    margin-top: 10px;\n" +
            "    font-weight: normal;\n" +
            "    font-size: 16px;\n" +
            "    background: url(Images/Background/dot-line.jpg) repeat-x left top;\n" +
            "    line-height: 35px;\n" +
            "}\n" +
            ".OrderSummaryRightMenu .Label\n" +
            "{\n" +
            "    padding: 2px 0 2px 8%;\n" +
            "    width: 58%;\n" +
            "    float: left;\n" +
            "}\n" +
            ".OrderSummaryRightMenu .Value\n" +
            "{\n" +
            "    padding: 2px 8% 2px 0;\n" +
            "    width: 42%;\n" +
            "    float: left;\n" +
            "}\n" +
            "/* OrderSummaryRightMenu End */\n" +
            "\n" +
            "/* GiftCouponDetailRightMenu Begin */\n" +
            ".GiftCouponDetailBox .SidebarRight\n" +
            "{\n" +
            "    padding: 25px 8%;\n" +
            "}\n" +
            ".GiftCouponDetailRightMenu\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    margin-top: 30px;\n" +
            "}\n" +
            ".GiftCouponDetailRightMenuTable\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".GiftCouponDetailRightMenuTable .InputTextBox\n" +
            "{\n" +
            "    width: 70%;\n" +
            "    float: left;\n" +
            "    margin-bottom: 2px;\n" +
            "}\n" +
            ".GiftCouponDetailRightMenuTable a.GiftCouponDetailButton\n" +
            "{\n" +
            "    width: 30%;\n" +
            "    float: right;\n" +
            "    padding: 0;\n" +
            "    margin: 0;\n" +
            "}\n" +
            ".GiftCouponDetailValidateDiv\n" +
            "{\n" +
            "    width: 70%;\n" +
            "    clear: both;\n" +
            "}\n" +
            ".GiftCouponDetailRightMenuTable .GiftCouponDetailValidatorText\n" +
            "{\n" +
            "    margin: 0;\n" +
            "}\n" +
            ".GiftCouponDetailRightMenuTable .CommonHyperLink\n" +
            "{\n" +
            "    text-decoration: underline;\n" +
            "}\n" +
            "/* GiftCouponDetailRightMenu End */\n" +
            "\n" +
            "/* Checkout - shipping address */\n" +
            "\n" +
            ".checkout-center-col .SidebarTop\n" +
            "{\n" +
            "    background: none;\n" +
            "    border-bottom: none;\n" +
            "}\n" +
            ".checkout-center-col .SidebarTop .CheckoutAddressTitle\n" +
            "{\n" +
            "    color: #000000;\n" +
            "    float: left;\n" +
            "    font-size: 19px;\n" +
            "    font-weight: normal;\n" +
            "    line-height: 30px;\n" +
            "    margin: 10px 0;\n" +
            "    padding: 5px 0;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".checkout-center-col .CheckoutShippingInfoPanel .SidebarTop .CheckoutAddressTitle\n" +
            "{\n" +
            "    color: #000000;\n" +
            "    float: left;\n" +
            "    font-size: 120%;\n" +
            "    font-weight: normal;\n" +
            "    line-height: 30px;\n" +
            "    margin: 10px 0;\n" +
            "    padding: 5px 0;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".checkout-center-col .OnePageCheckout .CheckoutShippingInfoPanel .SidebarTop .CheckoutAddressTitle\n" +
            "{\n" +
            "    margin-left: 0 !important;\n" +
            "}\n" +
            ".checkout-center-col .SidebarTop .CheckoutAddressTitle\n" +
            "{\n" +
            "    color: #000000;\n" +
            "    float: none;\n" +
            "    font-size: 16px;\n" +
            "    font-weight: normal;\n" +
            "    line-height: 30px;\n" +
            "    margin: 10px 0;\n" +
            "    padding: 5px 0;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".checkout-center-col .CommonPageRight\n" +
            "{\n" +
            "    padding: 0;\n" +
            "}\n" +
            ".Checkout .CommonPageTop\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".Checkout .CustomerRegister\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".CheckoutAddressLeftDataSelectAddress\n" +
            "{\n" +
            "    float: left;\n" +
            "    line-height: 30px;\n" +
            "    margin: 10px 0 10px 25px;\n" +
            "    padding: 5px 0;\n" +
            "}\n" +
            ".CheckoutButtonDiv\n" +
            "{\n" +
            "    float: right;\n" +
            "    width: 15%;\n" +
            "}\n" +
            ".CheckoutButtonDiv a\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    margin: 0;\n" +
            "    padding: 0;\n" +
            "}\n" +
            ".CheckoutButtonDiv .BtnStyle1\n" +
            "{\n" +
            "    background-color: #ff7200;\n" +
            "}\n" +
            ".CheckoutButtonDiv .BtnStyle1:hover\n" +
            "{\n" +
            "    background-color: #000;\n" +
            "}\n" +
            "\n" +
            ".CheckoutSpecialRequestPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 80%;\n" +
            "}\n" +
            ".CheckoutAddressLong\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 72.7%;\n" +
            "    margin-left: 18.5%;\n" +
            "}\n" +
            ".CheckoutSpecialRequestPanel .CheckoutAddressLong\n" +
            "{\n" +
            "    margin: 0 0 15px 23.1%;\n" +
            "}\n" +
            ".CheckoutSpecialRequestPanel .CheckoutAddressLeft\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".CheckoutAddressLeftDataCheckbox\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 0 0 10px;\n" +
            "    width: 100%;\n" +
            "    line-height: 20px;\n" +
            "}\n" +
            ".CheckoutAddressLeftDataCheckbox input\n" +
            "{\n" +
            "    float: left;\n" +
            "}\n" +
            ".CheckoutAddressLeftDataCheckbox .CustomerRegisterCheckBox\n" +
            "{\n" +
            "    margin-left: 0;\n" +
            "}\n" +
            ".CheckoutAddressLeftDataCheckbox label\n" +
            "{\n" +
            "    font-size: 13px;\n" +
            "    margin-right: 10px;\n" +
            "}\n" +
            ".CheckoutInnerTitle\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    font-weight: normal;\n" +
            "    margin: 0 0 20px;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".CheckoutCompany\n" +
            "{\n" +
            "    float: left;\n" +
            "    clear: both;\n" +
            "    margin-bottom: 10px;\n" +
            "    margin-top: 10px;\n" +
            "    font-weight: bold;\n" +
            "}\n" +
            ".CheckoutRadioButtonList\n" +
            "{\n" +
            "    float: left;\n" +
            "    clear: both;\n" +
            "    margin-left: 20px;\n" +
            "}\n" +
            ".Shipping .CheckoutInnerTitle\n" +
            "{\n" +
            "    float: none;\n" +
            "}\n" +
            ".CheckoutShippingInfoPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 0 0 15px;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".CheckoutSpecialRequestPanel .CheckoutAddressLeftDataCheckbox label\n" +
            "{\n" +
            "    margin-left: 4px;\n" +
            "    margin-top: 3px;\n" +
            "}\n" +
            "\n" +
            "/* Checkout - Shipping method*/\n" +
            ".ShippingRadioList\n" +
            "{\n" +
            "    clear: left;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ShippingRadioList input\n" +
            "{\n" +
            "}\n" +
            ".ShippingRadioList tr\n" +
            "{\n" +
            "    display: table-cell;\n" +
            "    width: 50%;\n" +
            "    float: left;\n" +
            "    padding: 5px 0;\n" +
            "}\n" +
            ".ShippingRadioList label\n" +
            "{\n" +
            "    padding-left: 10px;\n" +
            "    vertical-align: top;\n" +
            "}\n" +
            ".ShippingButtonDiv\n" +
            "{\n" +
            "    clear: both;\n" +
            "    float: right;\n" +
            "    width: 35%;\n" +
            "    margin: 30px 10% 0px;\n" +
            "}\n" +
            ".ShippingButtonDiv .BtnStyle1\n" +
            "{\n" +
            "    width: 40%;\n" +
            "    margin-left: 5%;\n" +
            "}\n" +
            ".ShippingButtonDiv .BtnStyle1\n" +
            "{\n" +
            "    background-color: #ff7200;\n" +
            "}\n" +
            ".ShippingButtonDiv .BtnStyle1:hover\n" +
            "{\n" +
            "    background-color: #000;\n" +
            "}\n" +
            ".ShippingButtonDiv .BtnStyle2\n" +
            "{\n" +
            "    width: 40%;\n" +
            "    margin-left: 5%;\n" +
            "    text-transform: none;\n" +
            "    display: none;\n" +
            "}\n" +
            ".ShippingRestrictions\n" +
            "{\n" +
            "    clear: left;\n" +
            "    margin-left: 20px;\n" +
            "}\n" +
            ".ShippingValidatorText\n" +
            "{\n" +
            "    color: Red;\n" +
            "    font-size: 11px;\n" +
            "    float: left;\n" +
            "    clear: both;\n" +
            "}\n" +
            "\n" +
            "/*Checkout - Payment Begin*/\n" +
            ".PaymentDataList\n" +
            "{\n" +
            "    clear: left;\n" +
            "    width: 80%;\n" +
            "}\n" +
            ".PaymentItemDiv\n" +
            "{\n" +
            "}\n" +
            ".PaymentDataListItemStyle\n" +
            "{\n" +
            "    padding-bottom: 15px;\n" +
            "}\n" +
            ".PaymentItemNameDiv\n" +
            "{\n" +
            "    float: left;\n" +
            "    padding-right: 2%;\n" +
            "    background-color: #fff;\n" +
            "}\n" +
            ".PaymentItemImageDiv\n" +
            "{\n" +
            "    float: right;\n" +
            "    margin-right: 20%;\n" +
            "}\n" +
            ".PaymentItemDescriptionDiv\n" +
            "{\n" +
            "    margin-left: 25px;\n" +
            "    margin-top: 1px;\n" +
            "    color: #989a9c;\n" +
            "}\n" +
            ".PaymentItemTextboxDiv\n" +
            "{\n" +
            "    margin-left: 25px;\n" +
            "    margin-top: 5px;\n" +
            "}\n" +
            ".PaymentItemRadioButton\n" +
            "{\n" +
            "    position: relative;\n" +
            "    padding-right: 10px;\n" +
            "}\n" +
            ".PaymentItemRadioButton label\n" +
            "{\n" +
            "    position: relative;\n" +
            "    top: -4px;\n" +
            "    left: 5px;\n" +
            "}\n" +
            ".PaymentAgreeBox\n" +
            "{\n" +
            "    width: 80%;\n" +
            "    border: solid 1px #f0f0f0;\n" +
            "    padding: 10px;\n" +
            "}\n" +
            ".PaymentAgreeCheckBox\n" +
            "{\n" +
            "    margin: 10px 0;\n" +
            "}\n" +
            ".PaymentAgreeCheckBox label\n" +
            "{\n" +
            "    margin-left: 10px;\n" +
            "}\n" +
            ".PaymentButtonDiv\n" +
            "{\n" +
            "    clear: both;\n" +
            "    float: right;\n" +
            "    margin: 30px 8% 0;\n" +
            "    width: 15%;\n" +
            "}\n" +
            ".PaymentButtonDiv .BtnStyle1\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    background-color: #ff7200;\n" +
            "}\n" +
            ".PaymentButtonDiv .BtnStyle1:hover\n" +
            "{\n" +
            "    background-color: #000;\n" +
            "}\n" +
            ".PaymentPOPanel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    background-color: #fbfcfe;\n" +
            "    padding: 10px;\n" +
            "    border: solid 1px #f0f0f0;\n" +
            "}\n" +
            ".PaymentValidatorText\n" +
            "{\n" +
            "    clear: left;\n" +
            "    width: 50%;\n" +
            "}\n" +
            ".PaymentValidatorText1\n" +
            "{\n" +
            "    width: 80%;\n" +
            "}\n" +
            ".PaymentFrame\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    height: 400px;\n" +
            "    margin-right: 3px;\n" +
            "}\n" +
            ".DirectPaymentSaleContent .CommonTextBox\n" +
            "{\n" +
            "    width: 60%;\n" +
            "}\n" +
            ".DirectPaymentSaleContent .CommonValidateDiv\n" +
            "{\n" +
            "    width: 60%;\n" +
            "}\n" +
            ".DirectPaymentSaleButtonDiv\n" +
            "{\n" +
            "    padding-left: 11px;\n" +
            "    clear: both;\n" +
            "}\n" +
            ".DirectPaymentSaleImageButton\n" +
            "{\n" +
            "    margin-top: 30px;\n" +
            "    width: 12%;\n" +
            "    float: right;\n" +
            "    margin-right: 10%;\n" +
            "    background-color: #ff7200;\n" +
            "}\n" +
            ".DirectPaymentSaleImageButton:hover\n" +
            "{\n" +
            "    color: #ffffff;\n" +
            "    background-color: #000000;\n" +
            "}\n" +
            ".DirectPaymentSaleBillingDiv\n" +
            "{\n" +
            "    padding-left: 10px;\n" +
            "}\n" +
            ".DirectPaymentSaleBillingDiv .CountryAndStateListDropDown\n" +
            "{\n" +
            "    width: 36.4%;\n" +
            "    color: rgb(121, 134, 140);\n" +
            "}\n" +
            ".DirectPaymentSaleContent .CommonFormLabel\n" +
            "{\n" +
            "    font-weight: lighter;\n" +
            "}\n" +
            ".DirectPaymentSaleContent\n" +
            "{\n" +
            "    font-weight: lighter;\n" +
            "}\n" +
            ".DirectPaymentSaleContent .CommonDropDown\n" +
            "{\n" +
            "    color: rgb(121, 134, 140);\n" +
            "    height: 18px;\n" +
            "    width: 60.4%;\n" +
            "    margin-right: 0;\n" +
            "}\n" +
            ".MessageNormal\n" +
            "{\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            "\n" +
            ".CountryAndStateListDropDown\n" +
            "{\n" +
            "    border: solid 1px #ccc;\n" +
            "    float: left;\n" +
            "    margin-right: 5px;\n" +
            "    margin-top: 4px;\n" +
            "    margin-bottom: 4px;\n" +
            "    width: 142px;\n" +
            "}\n" +
            ".CountryAndStateList\n" +
            "{\n" +
            "}\n" +
            "\n" +
            "/*OrderSummary Begin*/\n" +
            ".OrderSummary .CommonPageRight\n" +
            "{\n" +
            "    padding: 0;\n" +
            "}\n" +
            ".OrderSummary .SidebarTop\n" +
            "{\n" +
            "    margin-bottom: 20px;\n" +
            "    border: none;\n" +
            "    padding-left: 3px;\n" +
            "}\n" +
            ".OrderSummaryTable\n" +
            "{\n" +
            "    clear: left;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryFormViewDiv\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    margin: auto;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryShippingFromFormView\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    clear: left;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryShippingFromFormViewRowStyle .CommonGridView .CommonGridViewHeaderStyle\n" +
            "{\n" +
            "    background-color: white;\n" +
            "    border: none;\n" +
            "}\n" +
            ".OrderSummaryShippingDetailsTable\n" +
            "{\n" +
            "    width: 49%;\n" +
            "    float: right;\n" +
            "    margin-top: 0;\n" +
            "    clear: none;\n" +
            "}\n" +
            ".OrderSummaryBillingDetailsTable\n" +
            "{\n" +
            "    width: 50%;\n" +
            "    float: left;\n" +
            "    margin-top: 0;\n" +
            "    clear: none;\n" +
            "    color: #747474;\n" +
            "}\n" +
            ".OrderSummaryOfferDetailsTable\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    margin-top: 30px;\n" +
            "    border: 1px solid #f0f0f0;\n" +
            "    border-top: 0;\n" +
            "}\n" +
            ".OrderSummaryOfferDetailsTable .CommonGridViewHeaderStyle\n" +
            "{\n" +
            "    border-bottom: solid 1px #f0f0f0;\n" +
            "    padding: 3px 2%;\n" +
            "}\n" +
            ".OrderSummaryShippingDetailsHeaderColumn\n" +
            "{\n" +
            "    background-color: #fbfcfe;\n" +
            "    border-bottom: solid 1px #f0f0f0;\n" +
            "    padding: 0px;\n" +
            "    height: 28px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryShippingDetailsLabelColumn\n" +
            "{\n" +
            "    width: 20%;\n" +
            "    font-weight: lighter;\n" +
            "    padding: 2px 0px 2px 10px;\n" +
            "    text-align: left;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryShippingDetailsDataColumn\n" +
            "{\n" +
            "    padding: 2px 2%;\n" +
            "    text-align: left;\n" +
            "    font-size: 14px;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryInnerTable\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    border: 0;\n" +
            "    margin: 0;\n" +
            "    margin-top: 25px;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryGridView\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".OrderSummaryGridView th\n" +
            "{\n" +
            "    padding: 3px 2%;\n" +
            "}\n" +
            ".OrderSummaryInnerGridViewColumn\n" +
            "{\n" +
            "    padding: 0px 0px;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryInnerSummaryColumn\n" +
            "{\n" +
            "    padding: 0px;\n" +
            "}\n" +
            "\n" +
            ".OrderSummarySubtotalHeaderStyle\n" +
            "{\n" +
            "    width: 16%;\n" +
            "    text-align: right;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryQuantityHeaderStyle\n" +
            "{\n" +
            "    width: 20%;\n" +
            "    text-align: right;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryQuantityItemStyle\n" +
            "{\n" +
            "    text-align: right;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryUnitPriceHeaderStyle\n" +
            "{\n" +
            "    width: 18%;\n" +
            "    text-align: left;\n" +
            "}\n" +
            "\n" +
            ".OrderSummarySubtotalItemStyle\n" +
            "{\n" +
            "    text-align: right;\n" +
            "}\n" +
            ".OrderSummarySummaryTable\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    border: solid 1px #f0f0f0;\n" +
            "    border-top: 0;\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".OrderSummarySummaryTable td\n" +
            "{\n" +
            "    padding: 3px 2%;\n" +
            "}\n" +
            ".OrderSummarySummaryValue\n" +
            "{\n" +
            "    width: 16%;\n" +
            "    text-align: right;\n" +
            "    border-left: solid 1px #f0f0f0;\n" +
            "}\n" +
            ".OrderSummarySummaryLabel\n" +
            "{\n" +
            "    height: 25px;\n" +
            "    text-align: right;\n" +
            "}\n" +
            "\n" +
            ".OrderSummarySummaryTotalLabel\n" +
            "{\n" +
            "    text-align: right;\n" +
            "    color: #ff7200;\n" +
            "    height: 35px;\n" +
            "    font-weight: normal;\n" +
            "    font-size: 14px;\n" +
            "    border-top: solid 1px #f0f0f0;\n" +
            "}\n" +
            "\n" +
            "\n" +
            ".OrderSummarySummaryTotalValue\n" +
            "{\n" +
            "    text-align: right;\n" +
            "    color: #ff7200;\n" +
            "    font-weight: normal;\n" +
            "    font-size: 130%;\n" +
            "    border-top: solid 1px #f0f0f0;\n" +
            "    border-left: solid 1px #f0f0f0;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryCommentTable\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "    width: 100%;\n" +
            "    border: solid 1px #f0f0f0;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryCommentLabelColumn\n" +
            "{\n" +
            "    width: 20%;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryCommentValueColumn\n" +
            "{\n" +
            "    padding: 10px;\n" +
            "    width: 80%;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryButtonDiv\n" +
            "{\n" +
            "    text-align: right;\n" +
            "    width: 100%;\n" +
            "    margin-top: 40px;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryDescriptionLabel\n" +
            "{\n" +
            "    display: block;\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryFinishImageButton\n" +
            "{\n" +
            "    clear: both;\n" +
            "    float: right;\n" +
            "    background-color: #ff7200;\n" +
            "    display: block;\n" +
            "    font-size: 12px;\n" +
            "    line-height: 24px;\n" +
            "    margin: 10px 5px 2px 0px;\n" +
            "    padding: 0px 15px;\n" +
            "    text-decoration: none;\n" +
            "    vertical-align: middle;\n" +
            "    text-align: center;\n" +
            "    color: rgb(255, 255, 255);\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryFinishImageButton:hover\n" +
            "{\n" +
            "    color: #ffffff;\n" +
            "    background-color: #000000;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryBackLinkDiv\n" +
            "{\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryWarningMessageDiv\n" +
            "{\n" +
            "    color: red;\n" +
            "    width: 400px;\n" +
            "    margin: 10px 0 10px 50px;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryWarningMessageDiv ul\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryStockMessageDiv\n" +
            "{\n" +
            "    color: Red;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryQuantityMessageDiv\n" +
            "{\n" +
            "    color: Red;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryNameItemStyle\n" +
            "{\n" +
            "    padding-left: 2.5%;\n" +
            "    border-right: 1px solid rgb(221,221,221);\n" +
            "}\n" +
            "\n" +
            "\n" +
            "\n" +
            ".OrderSummaryNameItemStyle .ProductNameDetails\n" +
            "{\n" +
            "    position: relative;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryNameItemStyle .ProductRecurringNotice\n" +
            "{\n" +
            "    margin-top: 5px;\n" +
            "    width: 80px;\n" +
            "    text-decoration: underline;\n" +
            "    color: #438bc5;\n" +
            "    cursor: default;\n" +
            "    z-index: 1;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryNameItemStyle .hidecallout\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryNameItemStyle .showcallout\n" +
            "{\n" +
            "    background-color: #ccc; /*shadow color*/\n" +
            "    color: inherit;\n" +
            "    position: absolute;\n" +
            "    z-index: 100;\n" +
            "    width: 200px;\n" +
            "    left: 100px;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryNameItemStyle .showcallout .shadow\n" +
            "{\n" +
            "    background-color: #555; /*shadow color*/\n" +
            "    color: inherit;\n" +
            "    position: relative;\n" +
            "    bottom: 2px;\n" +
            "    right: 2px;\n" +
            "}\n" +
            "\n" +
            ".OrderSummaryNameItemStyle .showcallout .content\n" +
            "{\n" +
            "    background-color: #fff; /*background color of content*/\n" +
            "    color: #000; /*text color of content*/\n" +
            "    border: 1px solid #000; /*border color*/\n" +
            "    padding: .5em 2ex;\n" +
            "    text-align: left;\n" +
            "    position: relative;\n" +
            "    bottom: 2px;\n" +
            "    right: 2px;\n" +
            "}\n" +
            ".OrderSummary .CheckoutAddressTitle\n" +
            "{\n" +
            "    margin-right: 25px;\n" +
            "    font-size: 19px;\n" +
            "}\n" +
            "\n" +
            ".BillingAddressDiv\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 48%;\n" +
            "    margin-left: 2%;\n" +
            "}\n" +
            "\n" +
            ".ShippingAddressDiv\n" +
            "{\n" +
            "    float: right;\n" +
            "    width: 48%;\n" +
            "    margin-right: 2%;\n" +
            "    text-align: right;\n" +
            "}\n" +
            "\n" +
            ".BillingAddressDiv .CommonPageInnerTitle, .ShippingAddressDiv .CommonPageInnerTitle\n" +
            "{\n" +
            "    font-size: 14px;\n" +
            "    font-weight: normal;\n" +
            "    text-transform: capitalize;\n" +
            "    margin: 0;\n" +
            "}\n" +
            "\n" +
            ".ShippingAddressDiv .CommonPageInnerTitle\n" +
            "{\n" +
            "    float: right;\n" +
            "}\n" +
            ".CommonAddressDetail\n" +
            "{\n" +
            "    clear: left;\n" +
            "}\n" +
            "\n" +
            ".BillingAddressDiv .CommonAddressRow\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    font-size: 11px;\n" +
            "    font-weight: lighter;\n" +
            "    color: #747474;\n" +
            "}\n" +
            ".ShippingAddressDiv .CommonAddressRow\n" +
            "{\n" +
            "    clear: both;\n" +
            "    float: right;\n" +
            "    font-size: 11px;\n" +
            "    font-weight: lighter;\n" +
            "    color: #747474;\n" +
            "}\n" +
            "\n" +
            "/*OrderSummary End*/\n" +
            "/* CheckoutComplete Begin */\n" +
            ".CheckoutComplete h4\n" +
            "{\n" +
            "    color: #000000;\n" +
            "    font-size: 16px;\n" +
            "    width: 100%;\n" +
            "    font-weight: normal;\n" +
            "    line-height: 30px;\n" +
            "    margin: 10px 0;\n" +
            "    padding: 5px 0;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            "\n" +
            ".CheckoutComplete td\n" +
            "{\n" +
            "    height: 24px;\n" +
            "}\n" +
            ".CheckoutCompleteText\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin-right: 5px;\n" +
            "}\n" +
            ".CheckoutCompleteOrderLink\n" +
            "{\n" +
            "}\n" +
            ".CheckoutCompleteOrderLink:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            "\n" +
            ".CheckoutCompleteCustomerTable\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".CheckoutCompleteTable\n" +
            "{\n" +
            "    clear: both;\n" +
            "}\n" +
            "/* CheckoutComplete End */\n" +
            "/*ShoppingCart Begin*/\n" +
            ".ShoppingCartCheckoutLink, .ShoppingCartGiftRegistryLink\n" +
            "{\n" +
            "    float: right;\n" +
            "    font-size: 16px;\n" +
            "    line-height: 28px;\n" +
            "    margin: 3px 0;\n" +
            "    width: 31%;\n" +
            "    text-transform: uppercase;\n" +
            "    padding-top: 0.5%;\n" +
            "    padding-bottom: 0.5%;\n" +
            "    background-color: #ff8112;\n" +
            "    text-shadow: none;\n" +
            "    color: rgb(255, 255, 255);\n" +
            "    padding-right: 15px;\n" +
            "    text-decoration: none;\n" +
            "    vertical-align: middle;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ShoppingCartCheckoutLink:hover, .ShoppingCartGiftRegistryLink:hover\n" +
            "{\n" +
            "    background-color: #000000;\n" +
            "    color: #ffffff;\n" +
            "}\n" +
            ".ShoppingCartMessage\n" +
            "{\n" +
            "    padding: 0 3%;\n" +
            "    width: 94%;\n" +
            "    margin-top: 25px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ShoppingCartBackHomeLinkDiv\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    margin-top: 20px;\n" +
            "    margin-bottom: 20px;\n" +
            "}\n" +
            ".ShoppingCartBackHomeLinkDiv a\n" +
            "{\n" +
            "    font-size: 12px;\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            ".ShoppingCartBackHomeLinkDiv a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    text-decoration: none;\n" +
            "}\n" +
            ".ShoppingCartEmpty\n" +
            "{\n" +
            "    background-color: #F8F8F8;\n" +
            "    border: 1px dashed #FFDDDD;\n" +
            "    color: red;\n" +
            "    padding: 10px;\n" +
            "    text-align: center;\n" +
            "    margin-bottom: 13px;\n" +
            "    padding-left: 23px;\n" +
            "    font-size: 12px;\n" +
            "}\n" +
            ".ShoppingCartTable\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ShoppingCartPanel h3\n" +
            "{\n" +
            "    color: #2a353c;\n" +
            "    font-size: 19px;\n" +
            "    font-weight: normal;\n" +
            "    margin: 0;\n" +
            "    border-bottom: dotted 2px #bebebe;\n" +
            "    padding: 10px 0;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".ShoppingCartGridView .NameItem\n" +
            "{\n" +
            "    text-align: left;\n" +
            "    padding-left: 8px;\n" +
            "}\n" +
            ".ShoppingCartGridView .CommonGridViewRowStyle .ImageItem, .ShoppingCartGridView .CommonGridViewRowStyle > td .NameItem\n" +
            "{\n" +
            "    border-right: none;\n" +
            "}\n" +
            ".ShoppingCartGridView .CommonGridViewHeaderStyle th\n" +
            "{\n" +
            "    border-left: none;\n" +
            "}\n" +
            ".ShoppingCartGridView .ImageHeader\n" +
            "{\n" +
            "    width: 14%;\n" +
            "    text-align: left;\n" +
            "    background-color: #fbfcfe;\n" +
            "    border-bottom: 1px solid #f0f0f0;\n" +
            "}\n" +
            ".ShoppingCartGridView .ImageItem\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ShoppingCartGridView .ImageItemDiv\n" +
            "{\n" +
            "    margin: 5%;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ShoppingCartGridView .DeleteHeader\n" +
            "{\n" +
            "    width: 7.5%;\n" +
            "    background-color: #fbfcfe;\n" +
            "}\n" +
            ".ShoppingCartGridView .DeleteItem\n" +
            "{\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ShoppingCartGridView .NameHeader\n" +
            "{\n" +
            "    text-align: left;\n" +
            "    background-color: #fbfcfe;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            ".ShoppingCartGridView .NameItem\n" +
            "{\n" +
            "}\n" +
            ".ShoppingCartGridView .NameItem a\n" +
            "{\n" +
            "    font-size: 14px;\n" +
            "    text-decoration: none;\n" +
            "    text-align: center;\n" +
            "    color: black;\n" +
            "}\n" +
            ".ShoppingCartGridView .PriceHeader\n" +
            "{\n" +
            "    width: 14.5%;\n" +
            "    text-align: center;\n" +
            "    background-color: #fbfcfe;\n" +
            "}\n" +
            ".ShoppingCartGridView .PriceItem\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    color: #000;\n" +
            "    font-size: 14px;\n" +
            "}\n" +
            ".ShoppingCartGridView .QuantityHeader\n" +
            "{\n" +
            "    width: 8%;\n" +
            "    text-align: center;\n" +
            "    background-color: #fbfcfe;\n" +
            "}\n" +
            ".ShoppingCartGridView .QuantityItem\n" +
            "{\n" +
            "    font-weight: normal;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ShoppingCartButton .ShoppingCartContinueShopping\n" +
            "{\n" +
            "    background-color: #ff7200;\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            ".ShoppingCartButton .ShoppingCartContinueShopping:hover\n" +
            "{\n" +
            "    background-color: #000;\n" +
            "}\n" +
            ".ShoppingCartButton .ShoppingCartClearCart, .ShoppingCartButton .ShoppingCartUpdateQuantity\n" +
            "{\n" +
            "    font-size: 13px;\n" +
            "    width: 140px;\n" +
            "}\n" +
            ".ShoppingCartCheckoutDiv .BtnStyle2\n" +
            "{\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            ".ShoppingCart .CommonPageTop\n" +
            "{\n" +
            "    margin-left: 10px;\n" +
            "}\n" +
            ".ShoppingCartGridView .QuantityItem input\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    padding: 0px;\n" +
            "    margin: 0px;\n" +
            "    font-size: 13px;\n" +
            "    width: 50%;\n" +
            "    color: black;\n" +
            "    border: none;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".ShoppingCartGridView .SubtotalHeader\n" +
            "{\n" +
            "    width: 13.5%;\n" +
            "    text-align: center;\n" +
            "    background-color: #fbfcfe;\n" +
            "}\n" +
            ".ShoppingCartGridView .SubtotalItem\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    color: #000;\n" +
            "    font-size: 14px;\n" +
            "}\n" +
            ".ShoppingCartButton\n" +
            "{\n" +
            "    padding-top: 15px;\n" +
            "}\n" +
            ".ShoppingCartUpdateQuantity\n" +
            "{\n" +
            "    float: right;\n" +
            "    background-color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".ShoppingCartContinueShopping\n" +
            "{\n" +
            "    float: left;\n" +
            "    text-transform: none;\n" +
            "}\n" +
            ".CheckoutCompleteBackLinkDiv .ShoppingCartContinueShopping\n" +
            "{\n" +
            "    background-color: #ff7200;\n" +
            "}\n" +
            ".CheckoutCompleteBackLinkDiv .ShoppingCartContinueShopping:hover\n" +
            "{\n" +
            "    color: #ffffff;\n" +
            "    background-color: #000000;\n" +
            "}\n" +
            ".ShoppingCartClearCart\n" +
            "{\n" +
            "    float: right;\n" +
            "    margin-right: 20px;\n" +
            "    background-color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".ShoppingCartCheckoutDiv\n" +
            "{\n" +
            "    padding: 35px 0;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ShoppingCartCouponDiv\n" +
            "{\n" +
            "    width: 32%;\n" +
            "    float: left;\n" +
            "    margin-right: 2%;\n" +
            "}\n" +
            ".ShoppingCartNoteDiv\n" +
            "{\n" +
            "    width: 31%;\n" +
            "    float: left;\n" +
            "    margin-right: 3.5%;\n" +
            "}\n" +
            ".ShoppingCartOrderTotal\n" +
            "{\n" +
            "    width: 31%;\n" +
            "    float: right;\n" +
            "    border: solid 1px #f0f0f0;\n" +
            "    padding: 30px 1%;\n" +
            "    margin-bottom: 2%;\n" +
            "    margin-top: 4%;\n" +
            "}\n" +
            ".ShoppingCartNoteDiv .NoteDetail\n" +
            "{\n" +
            "    color: #000;\n" +
            "    margin-top: 10%;\n" +
            "    clear: left;\n" +
            "    padding-bottom: 10px;\n" +
            "    font-size: 13px;\n" +
            "}\n" +
            ".ShoppingCartNoteDiv .ShippingDiv\n" +
            "{\n" +
            "    padding: 0 0 10px;\n" +
            "}\n" +
            ".ShoppingCartTableColumn1\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 55%;\n" +
            "    padding: 7px 0;\n" +
            "    text-align: right;\n" +
            "    line-height: 25px;\n" +
            "}\n" +
            ".ShoppingCartTableColumn2\n" +
            "{\n" +
            "    float: right;\n" +
            "    text-align: right;\n" +
            "    width: 45%;\n" +
            "    padding: 7px 0;\n" +
            "    line-height: 25px;\n" +
            "}\n" +
            ".ShoppingCartTableDiscountRow, .ShoppingCartTableTotal\n" +
            "{\n" +
            "}\n" +
            ".ShoppingCartTableTotalAmountRow\n" +
            "{\n" +
            "    color: #000;\n" +
            "}\n" +
            ".ShoppingCartTableTaxIncludeColumn\n" +
            "{\n" +
            "    color: Red;\n" +
            "    font-size: 10px;\n" +
            "    float: right;\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            ".ShoppingCartTableAlternativePaymentsDiv\n" +
            "{\n" +
            "    text-align: center;\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    margin-top: 10px;\n" +
            "    color: #646464;\n" +
            "}\n" +
            ".ShoppingCartTableExpressPaymentButtonColumn\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    text-align: center;\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            ".ShoppingCartTableRecurringPaymentWarningColumn\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    text-align: center;\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            ".ShoppingCartGridView .NameItem .ProductNameDetails\n" +
            "{\n" +
            "    position: relative;\n" +
            "}\n" +
            ".ShoppingCartGridView .NameItem .ProductRecurringNotice\n" +
            "{\n" +
            "    margin-top: 5px;\n" +
            "    text-decoration: underline;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "    cursor: default;\n" +
            "    z-index: 2;\n" +
            "    font-size: 8px;\n" +
            "}\n" +
            ".ShoppingCartGridView .ProductNameDetails .hidecallout\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".ShoppingCartGridView .ProductNameDetails .showcallout\n" +
            "{\n" +
            "    background-color: #bbb; /*shadow color*/\n" +
            "    color: inherit;\n" +
            "    position: absolute;\n" +
            "    z-index: 100;\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            ".ShoppingCartGridView .ProductNameDetails .showcallout .shadow\n" +
            "{\n" +
            "    color: inherit;\n" +
            "    position: relative;\n" +
            "    bottom: 2px;\n" +
            "    right: 2px;\n" +
            "}\n" +
            "\n" +
            ".ShoppingCartGridView .ProductNameDetails .showcallout .content\n" +
            "{\n" +
            "    background-color: #fff; /*background color of content*/\n" +
            "    color: #333; /*text color of content*/\n" +
            "    border: 1px solid #dcdcdc; /*border color*/\n" +
            "    padding: 15px;\n" +
            "    text-align: left;\n" +
            "    position: relative;\n" +
            "    bottom: 2px;\n" +
            "    right: 2px;\n" +
            "    font-weight: normal;\n" +
            "}\n" +
            ".ShoppingCartTableTaxIncludeColumn .TaxNotice\n" +
            "{\n" +
            "    margin-top: 5px;\n" +
            "    width: 80px;\n" +
            "    text-decoration: underline;\n" +
            "    color: Red;\n" +
            "    cursor: default;\n" +
            "    z-index: 1;\n" +
            "    position: relative;\n" +
            "}\n" +
            ".ShoppingCartTableTaxIncludeColumn .hidecallout\n" +
            "{\n" +
            "    display: none;\n" +
            "}\n" +
            ".ShoppingCartTableTaxIncludeColumn .showcallout\n" +
            "{\n" +
            "    background-color: #ccc; /*shadow color*/\n" +
            "    color: inherit;\n" +
            "    margin-left: 4px;\n" +
            "    margin-top: 4px;\n" +
            "    position: absolute;\n" +
            "    z-index: 100;\n" +
            "    width: 150px;\n" +
            "}\n" +
            ".ShoppingCartTableTaxIncludeColumn .showcallout .shadow, .showcallout .content\n" +
            "{\n" +
            "    position: relative;\n" +
            "    bottom: 2px;\n" +
            "    right: 2px;\n" +
            "}\n" +
            ".ShoppingCartTableTaxIncludeColumn .showcallout .shadow\n" +
            "{\n" +
            "    background-color: #646464; /*shadow color*/\n" +
            "    color: inherit;\n" +
            "}\n" +
            ".ShoppingCartTableTaxIncludeColumn .showcallout .content\n" +
            "{\n" +
            "    background-color: #fff; /*background color of content*/\n" +
            "    color: #000; /*text color of content*/\n" +
            "    border: 1px solid #000; /*border color*/\n" +
            "    padding: .5em 2ex;\n" +
            "}\n" +
            ".DefaultGreenButtonStyle\n" +
            "{\n" +
            "    background-color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".ShoppingCartTotalAmount\n" +
            "{\n" +
            "    font-size: 18px;\n" +
            "    font-weight: lighter;\n" +
            "    color: #ff7200;\n" +
            "}\n" +
            ".ShoppingCartTotalAmountLabel\n" +
            "{\n" +
            "    font-size: 20px;\n" +
            "    font-weight: lighter;\n" +
            "}\n" +
            ".ShoppingCartTotal\n" +
            "{\n" +
            "    color: #25baa0;\n" +
            "}\n" +
            "\n" +
            ".ShoppingCartShippingEstimator .CountryAndStateListCountryTextBox\n" +
            "{\n" +
            "    width: 75% !important;\n" +
            "    margin: 4px 0;\n" +
            "}\n" +
            ".ShoppingCartShippingEstimator .CountryAndStateListStateTextBox\n" +
            "{\n" +
            "    width: 75% !important;\n" +
            "    margin-top: 4px !important;\n" +
            "    margin-bottom: 5px !important;\n" +
            "}\n" +
            "\n" +
            "\n" +
            "/*Shopping Cart End*/\n" +
            "/*ShippingEstimator Begin*/\n" +
            ".ShoppingCartShippingEstimator\n" +
            "{\n" +
            "    margin-top: 5%;\n" +
            "}\n" +
            ".ShoppingCartShippingEstimatorInput, .ShoppingCartShippingEstimator select\n" +
            "{\n" +
            "    margin-top: 5px;\n" +
            "    margin-bottom: 5px;\n" +
            "    width: 70%;\n" +
            "    float: right;\n" +
            "}\n" +
            "\n" +
            ".ShoppingCartShippingEstimatorInput input\n" +
            "{\n" +
            "    width: 140px;\n" +
            "}\n" +
            ".ShoppingCartShippingEstimatorLabel\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 25%;\n" +
            "    clear: left;\n" +
            "    margin-top: 7px;\n" +
            "    color: #000;\n" +
            "    padding-bottom: 20px;\n" +
            "}\n" +
            ".ShoppingCartShippingEstimatorButton\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: right;\n" +
            "}\n" +
            ".ShoppingCartShippingEstimatorShippingList\n" +
            "{\n" +
            "    clear: both;\n" +
            "    padding: 5px 0 15px;\n" +
            "}\n" +
            ".ShoppingCartShippingEstimatorShippingList input\n" +
            "{\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            ".ShippingEstimatorValidatorText\n" +
            "{\n" +
            "    margin-left: 7%;\n" +
            "}\n" +
            ".ShippingEstimatorValidateDiv\n" +
            "{\n" +
            "    width: 156px;\n" +
            "}\n" +
            ".ShoppingCartShippingEstimatorMessage\n" +
            "{\n" +
            "    clear: left;\n" +
            "    padding-top: 15px;\n" +
            "    margin-bottom: -13px;\n" +
            "    float: right;\n" +
            "    width: 100%;\n" +
            "}\n" +
            "/*ShippingEstimator End*/\n" +
            "/*ShoppingCartGiftCoupon Begin*/\n" +
            ".ShoppingCartClearButton\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 10px 0;\n" +
            "}\n" +
            ".ShoppingCartClearButton .CommonHyperLink\n" +
            "{\n" +
            "    text-decoration: underline;\n" +
            "}\n" +
            ".ShoppingCartGiftCoupon\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ShoppingCartGiftCouponTable\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    margin-bottom: 10%;\n" +
            "}\n" +
            ".GiftCouponDiv .GiftCouponDiv\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin: 5px 15px;\n" +
            "    width: 88%;\n" +
            "}\n" +
            ".ShoppingCartGiftCouponInputCenter\n" +
            "{\n" +
            "    color: #000;\n" +
            "    margin: 42px 10% 0;\n" +
            "    font-size: 14px;\n" +
            "}\n" +
            ".ShoppingCartGiftCouponInputCenter input\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ShoppingCartGiftCoupon .CouponMessageDisplay\n" +
            "{\n" +
            "}\n" +
            ".ShoppingCartGiftCouponButton\n" +
            "{\n" +
            "    float: right;\n" +
            "    width: 25%;\n" +
            "}\n" +
            ".ShoppingCartGiftCouponButton a\n" +
            "{\n" +
            "    margin-right: 0;\n" +
            "    background-color: rgb(155, 10 ,222);\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ShoppingCartGiftCoupon .GiftCouponDetailValidatorText\n" +
            "{\n" +
            "    width: 62%;\n" +
            "    margin: 0;\n" +
            "    clear: both;\n" +
            "    float: left;\n" +
            "    margin-left: 11%;\n" +
            "}\n" +
            ".ShoppingCartGiftCouponTextInfo\n" +
            "{\n" +
            "    clear: both;\n" +
            "    float: left;\n" +
            "    margin: 5px 0;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".ShoppingCartGiftCouponLabel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    width: 50%;\n" +
            "}\n" +
            ".ShoppingCartGiftCouponPointLabel\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "}\n" +
            ".ShoppingCartGiftCouponInput\n" +
            "{\n" +
            "    color: #25baa0;\n" +
            "    float: left;\n" +
            "    width: 40%;\n" +
            "    margin-left: 5px;\n" +
            "}\n" +
            ".ShoppingCartGiftCouponInputCodeTextBox\n" +
            "{\n" +
            "    width: 75% !important;\n" +
            "    float: left;\n" +
            "    margin: 0;\n" +
            "}\n" +
            ".ShoppingCartGiftCouponValidateText\n" +
            "{\n" +
            "    width: 70%;\n" +
            "}\n" +
            "/*ShoppingCartGiftCoupon End*//*GiftCouponDetail Begin*/\n" +
            ".GiftCouponDetail\n" +
            "{\n" +
            "    margin-top: 15px;\n" +
            "    clear: both;\n" +
            "    float: right;\n" +
            "    padding: 5px 0px;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".GiftCouponDetailTable\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".GiftCouponDetailTable ul\n" +
            "{\n" +
            "    margin-top: 5px;\n" +
            "    margin-bottom: 5px;\n" +
            "}\n" +
            ".GiftCouponDetailTable table\n" +
            "{\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".GiftCouponDetailSpecialRequestTable\n" +
            "{\n" +
            "}\n" +
            ".GiftCouponDetailSearchTermText\n" +
            "{\n" +
            "    padding: 4px;\n" +
            "    font-weight: normal;\n" +
            "    width: 150px;\n" +
            "    vertical-align: top;\n" +
            "}\n" +
            ".GiftCouponDetailInputCenter\n" +
            "{\n" +
            "    width: 160px;\n" +
            "    margin: 0 10px;\n" +
            "}\n" +
            ".GiftCouponDetailInputCodeTextBox\n" +
            "{\n" +
            "    width: 120px;\n" +
            "}\n" +
            ".GiftCouponDetailLabel\n" +
            "{\n" +
            "    text-align: left;\n" +
            "    width: 55%;\n" +
            "}\n" +
            ".GiftCouponDetailInput\n" +
            "{\n" +
            "    text-align: left;\n" +
            "    color: #00f;\n" +
            "}\n" +
            ".GiftCouponDetailSpecialRequestInput\n" +
            "{\n" +
            "    width: 290px;\n" +
            "}\n" +
            ".GiftCouponDetailSpecialRequestTextBox\n" +
            "{\n" +
            "    width: 290px;\n" +
            "    margin: 0 4px;\n" +
            "}\n" +
            ".GiftCouponDetailTextInfo\n" +
            "{\n" +
            "    clear: right;\n" +
            "    text-align: right;\n" +
            "}\n" +
            ".GiftCouponDetailMessage\n" +
            "{\n" +
            "    margin-top: 5px;\n" +
            "    text-align: right;\n" +
            "}\n" +
            ".GiftCouponDetailData\n" +
            "{\n" +
            "    margin-top: 5px;\n" +
            "    display: block;\n" +
            "    float: left;\n" +
            "}\n" +
            ".GiftCouponDetailTextInfo .CouponMessageDisplay\n" +
            "{\n" +
            "    text-align: left;\n" +
            "    width: 330px;\n" +
            "    float: right;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".GiftCouponDetailTextInfo .CouponMessageDisplayLabel\n" +
            "{\n" +
            "    margin: 0;\n" +
            "    text-align: right;\n" +
            "    margin-right: 10px;\n" +
            "}\n" +
            ".GiftCouponDetailTextInfo .CouponMessageDisplayData\n" +
            "{\n" +
            "    margin: 0;\n" +
            "}\n" +
            ".GiftCouponDetailValidatorText\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    margin: 0;\n" +
            "    clear: both;\n" +
            "    float: left;\n" +
            "    margin-left: 11%;\n" +
            "}\n" +
            "/*GiftCouponDetail End*/\n" +
            "/*NewsNavList Begin*/\n" +
            ".NewsNavList .SidebarTop\n" +
            "{\n" +
            "    line-height: 38px;\n" +
            "    min-height: 45px;\n" +
            "}\n" +
            ".NewsNavList .SidebarTopTitle\n" +
            "{\n" +
            "    line-height: 38px;\n" +
            "    padding: 8px 0;\n" +
            "}\n" +
            "\n" +
            ".zoom img\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    border-width: 0px;\n" +
            "}\n" +
            "\n" +
            ".ProductDetailsImageRowOverlayArea\n" +
            "{\n" +
            "    margin: auto;\n" +
            "    position: relative;\n" +
            "}\n" +
            "/*NewsNavList End*/\n" +
            "/*VendorProduct Begin*/\n" +
            ".ProductDetailVendorName\n" +
            "{\n" +
            "    font-size: 12px;\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            "\n" +
            ".ProductDetailVendorName:hover\n" +
            "{\n" +
            "    color: #000;\n" +
            "}\n" +
            "\n" +
            ".ProductListVendorName\n" +
            "{\n" +
            "    font-size: 11px;\n" +
            "    color: #66767b;\n" +
            "}\n" +
            "\n" +
            ".ProductListVendorName:hover\n" +
            "{\n" +
            "    color: #000;\n" +
            "}\n" +
            "\n" +
            ".ProductListItemDetailsColumn .ProductListVendorName\n" +
            "{\n" +
            "    font-size: 11px;\n" +
            "    clear: left;\n" +
            "    line-height: 24px;\n" +
            "    margin-bottom: 5px;\n" +
            "}\n" +
            ".ProductListVendorName .CommonHyperLink\n" +
            "{\n" +
            "    color: #66767b;\n" +
            "}\n" +
            ".ProductListVendorName a:hover\n" +
            "{\n" +
            "    color: #000;\n" +
            "}\n" +
            "\n" +
            ".ProductListTableViewItem .ProductListVendorName\n" +
            "{\n" +
            "    font-size: 11px;\n" +
            "    color: #66767b;\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            ".ProductListTableViewItem .ProductListVendorName:hover\n" +
            "{\n" +
            "    color: #000;\n" +
            "}\n" +
            "\n" +
            ".ProductListItemColumn2DetailsColumn .VendorName\n" +
            "{\n" +
            "    float: none;\n" +
            "    background: none;\n" +
            "    height: 15px;\n" +
            "}\n" +
            "\n" +
            ".QuickViewPanel .ProductListVendorName\n" +
            "{\n" +
            "    font-size: 11px;\n" +
            "    color: #66767b;\n" +
            "    padding-bottom: 7px;\n" +
            "}\n" +
            "\n" +
            ".ProductListTableViewItem .CommonVendorName\n" +
            "{\n" +
            "    margin: 0px;\n" +
            "    text-align: center;\n" +
            "    margin-left: 4%;\n" +
            "}\n" +
            "\n" +
            ".ProductRowDataList .QuickViewPanel .ProductListVendorName\n" +
            "{\n" +
            "    float: left;\n" +
            "}\n" +
            "\n" +
            ".QuickViewPanel .ProductListVendorName:hover\n" +
            "{\n" +
            "    color: #000;\n" +
            "}\n" +
            "\n" +
            "/*VendorProduct End*/\n" +
            "/* VendorList */\n" +
            ".VendorList\n" +
            "{\n" +
            "    width: 100%;\n" +
            "    margin: 0;\n" +
            "}\n" +
            ".VendorListTitle\n" +
            "{\n" +
            "}\n" +
            ".VendorListItemStyle\n" +
            "{\n" +
            "    display: inline-block;\n" +
            "    width: 100%;\n" +
            "    padding: 15px 15px 25px;\n" +
            "    border-bottom: solid 1px #efefef;\n" +
            "}\n" +
            ".VendorListItemStyle .LogoImage\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 25%;\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".VendorListItemStyle .StoreName\n" +
            "{\n" +
            "    float: right;\n" +
            "    width: 75%;\n" +
            "    margin-top: 5px;\n" +
            "}\n" +
            ".VendorListItemStyle .StoreName a\n" +
            "{\n" +
            "    font-size: 18px;\n" +
            "    text-decoration: none;\n" +
            "    line-height: 30px;\n" +
            "    color: #000;\n" +
            "}\n" +
            ".VendorListItemStyle .StoreName a:hover\n" +
            "{\n" +
            "    color: rgb(155, 10 ,222);\n" +
            "}\n" +
            ".VendorListItemStyle .CompanyDescription\n" +
            "{\n" +
            "    float: right;\n" +
            "    width: 75%;\n" +
            "    clear: right;\n" +
            "    margin-top: 15px;\n" +
            "    line-height: 22px;\n" +
            "}\n" +
            ".VendorListSortingDiv\n" +
            "{\n" +
            "    float: right;\n" +
            "    line-height: 24px;\n" +
            "    padding-top: 2px;\n" +
            "}\n" +
            ".VendorListSortingDiv .OptionControlTitle\n" +
            "{\n" +
            "    font-size: 11px;\n" +
            "}\n" +
            ".VendorListSortingDiv select\n" +
            "{\n" +
            "    float: left;\n" +
            "    margin: 3px 5px;\n" +
            "}\n" +
            ".VendorListPagingDiv\n" +
            "{\n" +
            "    float: right;\n" +
            "}\n" +
            ".VendorListGoTopDiv\n" +
            "{\n" +
            "    clear: both;\n" +
            "    float: right;\n" +
            "    margin: 10px 0;\n" +
            "    background: url(Images/Bullet/top.gif) no-repeat left center;\n" +
            "    padding-left: 15px;\n" +
            "}\n" +
            ".VendorListSorted\n" +
            "{\n" +
            "    color: #313131;\n" +
            "    line-height: 22px;\n" +
            "}\n" +
            ".VendorList .ProductListDefaultPagingControl\n" +
            "{\n" +
            "    border: 0;\n" +
            "}\n" +
            ".VendorList .ProductListGridListItemPerPage\n" +
            "{\n" +
            "    float: left;\n" +
            "}\n" +
            "\n" +
            "/* VendorDetail */\n" +
            "/*--vendor information--*/\n" +
            ".VendorInfo .CommonPageTopTitle\n" +
            "{\n" +
            "    line-height: 30px;\n" +
            "}\n" +
            ".VendorInfo .CommonPageRight\n" +
            "{\n" +
            "    display: inline-block;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".VendorInfoDescription\n" +
            "{\n" +
            "    font-size: 13px;\n" +
            "    color: #555;\n" +
            "    display: inline-block;\n" +
            "    width: 100%;\n" +
            "    margin: 10px 0 20px;\n" +
            "    line-height: 22px;\n" +
            "}\n" +
            ".VendorInfo .LogoImage\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 23%;\n" +
            "    text-align: center;\n" +
            "    border: solid 1px #ededed;\n" +
            "    padding: 20px 0;\n" +
            "    margin: 10px 0 0;\n" +
            "}\n" +
            ".VendorInfo .GeneralInfo\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 70%;\n" +
            "    margin: 0 0 0 5%;\n" +
            "}\n" +
            ".VendorInfo .InfoContent\n" +
            "{\n" +
            "    width: 48%;\n" +
            "    float: left;\n" +
            "}\n" +
            "\n" +
            "/*--vendor product listS--*/\n" +
            ".VendorProductList\n" +
            "{\n" +
            "    margin-top: 30px;\n" +
            "}\n" +
            ".VendorProductListTop\n" +
            "{\n" +
            "    background-position: left top;\n" +
            "    min-height: 0;\n" +
            "    padding: 25px 0 15px;\n" +
            "}\n" +
            ".VendorProductList .CommonPageRight\n" +
            "{\n" +
            "    padding: 10px 0;\n" +
            "}\n" +
            ".VendorProductList .CategoryDescriptionDiv\n" +
            "{\n" +
            "    padding: 0;\n" +
            "    margin: 0;\n" +
            "}\n" +
            ".VendorProductListBackButton a.CommonHyperLink\n" +
            "{\n" +
            "    font-size: 12px;\n" +
            "}\n" +
            "\n" +
            "/* VendorSearchBox */\n" +
            ".VendorSearchBox\n" +
            "{\n" +
            "    clear: left;\n" +
            "    float: left;\n" +
            "    margin-bottom: 15px;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".VendorSearchBox .SidebarRight\n" +
            "{\n" +
            "    float: left;\n" +
            "    width: 100%;\n" +
            "    padding: 25px 15px;\n" +
            "}\n" +
            "input[type=\"text\"].VendorSearchTextBox\n" +
            "{\n" +
            "    width: 70%;\n" +
            "    float: left;\n" +
            "}\n" +
            ".VendorSearchBox .BtnStyle2\n" +
            "{\n" +
            "    width: 28%;\n" +
            "    padding: 0;\n" +
            "    margin: 0;\n" +
            "    float: left;\n" +
            "}\n" +
            "\n" +
            ".BannerPanel img\n" +
            "{\n" +
            "    text-align:center;  \n" +
            "}\n" +
            ".BannerPanel\n" +
            "{\n" +
            "    text-align:center;\n" +
            "}\n" +
            ".BannerHeader img\n" +
            "{\n" +
            "    max-width: 73%;\n" +
            "    max-height: 300px;\n" +
            "    margin-bottom: 5px;\n" +
            "    margin-top: 5px;\n" +
            "}\n" +
            ".BannerFooter img\n" +
            "{\n" +
            "    max-width: 73%;\n" +
            "    max-height: 300px;\n" +
            "    margin-bottom: 5px;\n" +
            "    margin-top: 5px;\n" +
            "}\n" +
            ".BannerLeft img\n" +
            "{\n" +
            "    margin-bottom: 5px;\n" +
            "    margin-top: 5px;\n" +
            "}\n" +
            ".BannerRight img\n" +
            "{\n" +
            "    margin-bottom: 5px;\n" +
            "    margin-top: 5px;\n" +
            "}\n" +
            "/*Custom Cupon store item*/\n" +
            ".NewArrivalItemStyle, .DummyCommonProductItemStyle {\n" +
            "    /*border: 2px solid rgb(155, 10,222) !important;armando*/\n" +
            "    display: block !important; /*\n" +
            "    border-bottom-style: dashed !important;\n" +
            "    border-top-style: dashed !important;\n" +
            "    border-left-style: dashed !important;\n" +
            "    border-right-style: dashed !important;\n" +
            "    background-color: #ededed !important;\n" +
            "    */\n" +
            "}\n" +
            "/**hide brand*/\n" +
            ".HeaderMenuRight ul :nth-child(3) {\n" +
            "    display: none;\n" +
            "}\n" +
            "/**login bar black*/\n" +
            ".header-container1 {\n" +
            "    background-color: black;\n" +
            "}\n" +
            ".HeaderLogin, .HeaderLogin a, .WishlistLink, .MyAccountLink {\n" +
            "    color: white !important;\n" +
            "}\n" +
            "/**botones prev next de new arrival*/\n" +
            ".NewArrival .next, .NewArrival .prev {\n" +
            "    height: 370px !important;\n" +
            "    top: 0px;\n" +
            "}\n" +
            ".NewArrival .prev {\n" +
            "    left: -12px;\n" +
            "}\n" +
            ".NewArrival .prev:hover {\n" +
            "    background: url(Ozumages/left-on.jpg) no-repeat 0 0;\n" +
            "}\n" +
            ".NewArrival .prev {\n" +
            "    background: url(Ozumages/left.jpg) no-repeat 0 0;\n" +
            "}\n" +
            ".NewArrival .next:hover {\n" +
            "    background: url(Ozumages/right-on.jpg) no-repeat 0 0;\n" +
            "}\n" +
            ".NewArrival .next {\n" +
            "    background: url(Ozumages/right.jpg) no-repeat 0 0;\n" +
            "}\n" +
            ".NewArrivalLabel {\n" +
            "    font-size: 10px;\n" +
            "}\n" +
            "/**footer*/\n" +
            ".copyright-footer {\n" +
            "    /**display: none;*/\n" +
            "}\n" +
            "/*\n" +
            ".LayoutFooterLicense .row ::after {\n" +
            "    content: 'Copyright © 2017 Ozu Perú. Todos los derechos reservados.';\n" +
            "    visibility: visible;\n" +
            "    display: block;\n" +
            "}*/\n" +
            "/**CenterBlockTop con subrayado, cambio de posicion*/\n" +
            ".CenterBlockTop {\n" +
            "    border-bottom: solid 3px #b8b8b8 !important;\n" +
            "}\n" +
            "\n" +
            ".IntroductionMessagePanel .CenterBlockTop {\n" +
            "    /**top: -460px;\n" +
            "    position: relative;*/\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            "/*Uniform vertical whitespace under coupon*/\n" +
            ".CommonProductItemStyle {\n" +
            "    height: 370px;\n" +
            "    border: 2px solid rgb(155, 10,222) !important;\n" +
            "    border-bottom-style: dashed !important;\n" +
            "    border-top-style: dashed !important;\n" +
            "    border-left-style: dashed !important;\n" +
            "    border-right-style: dashed !important;\n" +
            "    background-color: #ededed !important;\n" +
            "}\n";

    static String res1 = "\n" +
            "/*------------------ Custom Responsive Layout ------------------*/\n" +
            "@media only screen and (min-width: 980px) /*Screen width larger than 980 px ----------  For step 4 --------- */\n" +
            "{\n" +
            "    .ProductListDefaultDataList\n" +
            "    {\n" +
            "        width: 104%;\n" +
            "    }\n" +
            "    .PromotionGroupDataList .CommonProductItemStyle\n" +
            "    {\n" +
            "        margin: 20px 0 20px 1.85%;\n" +
            "        padding-right: 2%;\n" +
            "        width: 31%;\n" +
            "        border-right: dashed 1px #ebebeb;\n" +
            "    }\n" +
            "    .CategoryListDefault3 .CommonProductItemStyle\n" +
            "    {\n" +
            "        min-height: 380px;\n" +
            "    }\n" +
            "\n" +
            "    /* Header Menu */\n" +
            "    .HeaderMenu ul\n" +
            "    {\n" +
            "    }\n" +
            "    .HeaderMenu ul li\n" +
            "    {\n" +
            "        float: left;\n" +
            "    }\n" +
            "    .headerMenuNormal\n" +
            "    {\n" +
            "        display: block;\n" +
            "    }\n" +
            "    .headerMenuResponsive\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "\n" +
            "    /* Product List */\n" +
            "    .ProductColumn1DataList .CommonProductItemStyle, .ProductColumn2DataList .CommonProductItemStyle, .ProductColumn3DataList .CommonProductItemStyle\n" +
            "    {\n" +
            "        width: 30.875%;\n" +
            "        margin: 40px 2% 10px 0;\n" +
            "        display: inline-block;\n" +
            "    }\n" +
            "    .ProductRowDataList .CommonProductItemStyle\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        margin: 10px 0 25px;\n" +
            "        display: block;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .AdvancedSearchResult .ProductRowDataList .CommonProductItemStyle\n" +
            "    {\n" +
            "        width: 70%;\n" +
            "        margin: 10px 0 25px;\n" +
            "        display: block;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    /* Product detail */\n" +
            "    .ProductQuickInfoStock\n" +
            "    {\n" +
            "        float: left;\n" +
            "        position: relative;\n" +
            "    }\n" +
            "    .ProductQuickInfoRating\n" +
            "    {\n" +
            "        float: left;\n" +
            "        position: relative;\n" +
            "        width: 25%;\n" +
            "    }\n" +
            "    .ProductDetailsResponsiveOurPrice\n" +
            "    {\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .WriteReviewDiv .CommonHyperLink\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .QuantityDiscountPanel\n" +
            "    {\n" +
            "        text-transform: none;\n" +
            "        margin-right: 50px;\n" +
            "        margin-top: auto;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .FreeShippingLabel\n" +
            "    {\n" +
            "        background: #F9FBFD url(\"Images/Icon/icon-free-shipping.gif\") no-repeat scroll 10px center;\n" +
            "        float: none;\n" +
            "        clear: none;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .RelatedProductsTitleRight\n" +
            "    {\n" +
            "        border-bottom: 2px dotted #DDDDDD;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .RelatedProductsItemTable\n" +
            "    {\n" +
            "        border-bottom: 1px dotted #DDDDDD;\n" +
            "    }\n" +
            "    /*--- Option RadioList ---*/\n" +
            "    .ProductDetailsResponsive .OptionRadioItem\n" +
            "    {\n" +
            "        float: left;\n" +
            "        width: 380px;\n" +
            "        position: relative;\n" +
            "        bottom: 8px;\n" +
            "        left: 5px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .OptionRadioItemRadioButtonList label\n" +
            "    {\n" +
            "        width: auto;\n" +
            "    }\n" +
            "\n" +
            "    /* New Arrival for category Begin */\n" +
            "    .NewArrivalCategoryList\n" +
            "    {\n" +
            "        width: 103%;\n" +
            "    }\n" +
            "    .NewArrivalCategoryList .CommonProductItemStyle\n" +
            "    {\n" +
            "        width: 30.875%;\n" +
            "        margin: 20px 2% 10px 0;\n" +
            "        display: inline-block;\n" +
            "    }\n" +
            "    .NewArrivalCategory .SidebarRight\n" +
            "    {\n" +
            "        padding: 0;\n" +
            "    }\n" +
            "    .NewArrivalCategoryItem\n" +
            "    {\n" +
            "        position: relative;\n" +
            "    }\n" +
            "    .NewArrivalCategoryItem .CommonProductImage tr td\n" +
            "    {\n" +
            "        background-color: #fff;\n" +
            "    }\n" +
            "\n" +
            "    /* Breadcrumb Begin */\n" +
            "    .catalog-center-col .CatalogBreadcrumb\n" +
            "    {\n" +
            "        left: -30.5%;\n" +
            "        position: absolute;\n" +
            "        top: -20px;\n" +
            "    }\n" +
            "    .pdetail-row .CatalogBreadcrumb\n" +
            "    {\n" +
            "        position: absolute;\n" +
            "        top: -20px;\n" +
            "        margin-left: 5px;\n" +
            "    }\n" +
            "    .NewsMainDiv .CatalogBreadcrumb\n" +
            "    {\n" +
            "        position: absolute;\n" +
            "        top: -32px;\n" +
            "        margin-left: 0;\n" +
            "    }\n" +
            "\n" +
            "    /*PasswordDetails Begin*/\n" +
            "    .PasswordDetailsTable tr\n" +
            "    {\n" +
            "        display: table-cell;\n" +
            "        width: 48%;\n" +
            "        margin-right: 2%;\n" +
            "        float: left;\n" +
            "    }\n" +
            "\n" +
            "    /*Advanced Search Begin*/\n" +
            "    .SearchDropByCategory\n" +
            "    {\n" +
            "        width: 80%;\n" +
            "    }\n" +
            "    .AdvancedSearchInCategoryDrop, .AdvancedSearchInDepartmentDrop, .AdvancedSearchinmanufacturerDrop, .AdvancedSearchInVendorDrop\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .SearchDropByDepartment\n" +
            "    {\n" +
            "        width: 70%;\n" +
            "    }\n" +
            "    .SearchDropByVendor\n" +
            "    {\n" +
            "        width: 70%;\n" +
            "    }\n" +
            "    .SearchDropByManufacturer\n" +
            "    {\n" +
            "        width: 80%;\n" +
            "    }\n" +
            "\n" +
            "    /*-- Fix style for UserLogin MasterPage --*/\n" +
            "    .UserLogin .CommonUserLoginPanelUserName, .UserLogin .CommonUserLoginPanelPassword\n" +
            "    {\n" +
            "        width: 80%;\n" +
            "    }\n" +
            "    .UserLogin .CommonUserLoginPanelUserName label, .UserLogin .CommonUserLoginPanelPassword label\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        float: left;\n" +
            "        width: 31%;\n" +
            "    }\n" +
            "    .UserLogin .CommonUserLoginValidatorText\n" +
            "    {\n" +
            "        width: 48%;\n" +
            "    }\n" +
            "\n" +
            "    /* ShippingAddress Detail */\n" +
            "    .MainDiv .CustomerRegister .CustomerRegisterLinkButtonDiv\n" +
            "    {\n" +
            "        margin-right: 4%;\n" +
            "    }\n" +
            "    .AccountMainDiv .CustomerRegister .CustomerRegisterLinkButtonDiv\n" +
            "    {\n" +
            "        margin-right: 4%;\n" +
            "    }\n" +
            "    .AccountMainDiv .AccountDetailsCheckBoxDiv\n" +
            "    {\n" +
            "        margin-left: 40%;\n" +
            "        width: 90%;\n" +
            "    }\n" +
            "\n" +
            "    /* AccountDetails */\n" +
            "    .AccountDetailsButtonDiv\n" +
            "    {\n" +
            "        margin-right: 4%;\n" +
            "    }\n" +
            "    .CheckoutSaleTaxExemptPanel .CheckoutAddressLong .CheckoutAddressLeftData\n" +
            "    {\n" +
            "        margin-bottom: 10px;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel\n" +
            "    {\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CommonFormData\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        width: 50%;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CommonFormData .CustomerRegisterCheckBox\n" +
            "    {\n" +
            "        margin-left: 37%;\n" +
            "        width: 65%;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel\n" +
            "    {\n" +
            "        margin-right: 0;\n" +
            "        width: 48%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel .CommonFormLabel\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        color: #000000;\n" +
            "        float: left;\n" +
            "        font-size: 13px;\n" +
            "        line-height: 25px;\n" +
            "        margin-left: 2.8%;\n" +
            "        margin-right: 2%;\n" +
            "        padding: 2px 0;\n" +
            "        width: 35%;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel .CommonFormData\n" +
            "    {\n" +
            "        float: left;\n" +
            "        padding-bottom: 2px;\n" +
            "        padding-top: 2px;\n" +
            "        width: 60%;\n" +
            "        clear: none;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel .CommonFormData .CheckoutTextBox\n" +
            "    {\n" +
            "        width: 90% !important;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel .ClientCityStatePanel\n" +
            "    {\n" +
            "        margin-right: 0;\n" +
            "        width: 100%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel .ClientCityStatePanel .CountryAndStateListDropDown\n" +
            "    {\n" +
            "        width: 54%;\n" +
            "        clear: none;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel .ClientCityStatePanel .CountryAndStateListCountryTextBox\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        float: left;\n" +
            "        margin-left: 40%;\n" +
            "        width: 54%;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel .ClientCityStatePanel .CountryAndStateListStateTextBox\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        float: left;\n" +
            "        width: 54%;\n" +
            "        margin-left: 40%;\n" +
            "    }\n" +
            "}\n" +
            "@media only screen and (max-width: 979px) /*Screen width 768-980 px ---------- For step 3---------*/\n" +
            "{\n" +
            "    .HeaderLoginWishlist a, .HeaderLoginAccount a {\n" +
            "        color: white !important; /*armando*/\n" +
            "    }\n" +
            "    .top-bar ul > li.toggle-topbar {\n" +
            "        /*armando*/\n" +
            "        background: rgb(128, 0, 255); /* For browsers that do not support gradients */\n" +
            "        background: -webkit-linear-gradient(left, #939, #099); /* For Safari 5.1 to 6.0 */\n" +
            "        background: -o-linear-gradient(right, #939, #099); /* For Opera 11.1 to 12.0 */\n" +
            "        background: -moz-linear-gradient(right, #939, #099); /* For Firefox 3.6 to 15 */\n" +
            "        background: linear-gradient(to right, #939, #099); /* Standard syntax (must be last) */\n" +
            "    }\n" +
            "    .header-container3\n" +
            "    {\n" +
            "        /*background: none;armando*/\n" +
            "    }\n" +
            "\n" +
            "    /*Header */\n" +
            "    .Search\n" +
            "    {\n" +
            "        width: 80%;\n" +
            "    }\n" +
            "    /*--- HeaderMenu ---*/\n" +
            "    .HeaderMenu ul\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        border: 0;\n" +
            "    }\n" +
            "    .HeaderMenu ul li\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "        float: left;\n" +
            "        /*border-top: solid 1px white;/*rgb(189, 0, 222);*/\n" +
            "        /*border-bottom: solid 1px white;rgb(87, 17, 119);*/\n" +
            "    }\n" +
            "    .HeaderMenu ul li a\n" +
            "    {\n" +
            "        padding: 0;\n" +
            "        float: none !important;\n" +
            "    }\n" +
            "    .HeaderMenu ul li a.HyperLink, .HeaderMenu ul li a.ContentMenuNavListStaticMenuItem {\n" +
            "        padding: 2px 0;\n" +
            "        background-color: none;/*rgb(155, 10 ,222);armando*/\n" +
            "    }\n" +
            "    .HeaderMenu .ContentMenuNavList\n" +
            "    {\n" +
            "        float: none;\n" +
            "    }\n" +
            "    .headerMenuNormal\n" +
            "    {\n" +
            "        display: block;\n" +
            "    }\n" +
            "    .headerMenuResponsive\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "\n" +
            "    /*--- group style ---*/\n" +
            "    .nav-container ul\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        border: 0;\n" +
            "    }\n" +
            "    .nav-container ul.menu td\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "        float: left;\n" +
            "        display: inline-block;\n" +
            "    }\n" +
            "    .nav-container ul.menu li\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        background-color: rgb(155, 10 ,222);\n" +
            "        border-top: solid 1px rgb(189, 0, 222);\n" +
            "        border-bottom: solid 1px rgb(87, 17, 119);\n" +
            "    }\n" +
            "    .SubCategoryListStyle\n" +
            "    {\n" +
            "        width: 170px;\n" +
            "    }\n" +
            "    .nav-container ul.menu td.SubCategoryItemData\n" +
            "    {\n" +
            "        width: auto;\n" +
            "        float: none;\n" +
            "        display: table-cell;\n" +
            "    }\n" +
            "    .nav-container ul.menu .HeaderMenuNavItemLeft, .nav-container ul.menu .HeaderMenuNavItemRight\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .nav-container ul.menu li .CategoryPanel\n" +
            "    {\n" +
            "        min-width: 192px;\n" +
            "    }\n" +
            "    /*Common Product Item Style */\n" +
            "    .CommonProductItemStyle\n" +
            "    {\n" +
            "        width: 30.875%;\n" +
            "        margin: 20px 2% 10px 0;\n" +
            "    }\n" +
            "    .PromotionGroupDataList .CommonProductItemStyle\n" +
            "    {\n" +
            "        width: 46.25%;\n" +
            "        margin: 20px 0 10px 3.25%;\n" +
            "        padding-right: 2.5%;\n" +
            "        display: inline-block;\n" +
            "        border-right: dashed 1px #ddd;\n" +
            "    }\n" +
            "\n" +
            "    /* Product list & Category list */\n" +
            "    .CommonCategoryItemStyle\n" +
            "    {\n" +
            "        margin: 10px 2% 10px 0;\n" +
            "        width: 22.5%;\n" +
            "    }\n" +
            "    .ProductRowDataList\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .ProductColumn1DataList\n" +
            "    {\n" +
            "        width: 104%;\n" +
            "    }\n" +
            "    .ProductColumn2DataList\n" +
            "    {\n" +
            "        width: 104%;\n" +
            "    }\n" +
            "    .ProductListTableView\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .CommonCategoryItemStyle\n" +
            "    {\n" +
            "        margin: 10px 2% 10px 0;\n" +
            "        width: 22%;\n" +
            "    }\n" +
            "    .ProductColumn1DataList .CommonProductItemStyle, .ProductColumn2DataList .CommonProductItemStyle, .ProductColumn3DataList .CommonProductItemStyle\n" +
            "    {\n" +
            "        width: 46.333%;\n" +
            "        margin: 10px 3% 0 0;\n" +
            "        display: inline-block;\n" +
            "    }\n" +
            "\n" +
            "    /*--- Product Row Style ---*/\n" +
            "    .ProductRowDataList .CommonProductItemStyle\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        margin-top: 0;\n" +
            "    }\n" +
            "    .AdvancedSearchResult .ProductRowDataList .CommonProductItemStyle\n" +
            "    {\n" +
            "        width: 80%;\n" +
            "    }\n" +
            "    .ProductListItem .ProductListItemDetailsColumn\n" +
            "    {\n" +
            "        width: 66%;\n" +
            "        padding: 25px 4%;\n" +
            "        padding-right: 5px;\n" +
            "    }\n" +
            "    .ProductListItem .ProductListItemTellFriendPanel, .ProductListItem .ProductListItemAddtoWishListPanel, .ProductListItem .ProductListItemAddtoCompareListPanel\n" +
            "    {\n" +
            "        padding-left: 0px;\n" +
            "        margin-left: 5px;\n" +
            "    }\n" +
            "    .ProductListItem .CommonProductImage img\n" +
            "    {\n" +
            "        max-width: 170px;\n" +
            "    }\n" +
            "    .ProductListItem .ProductListItemSpecialLabel\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        float: left;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .ProductListItem .CommonProductImagePanel .QuickViewButtonBorder\n" +
            "    {\n" +
            "        top: -5px;\n" +
            "        width: 170px !important;\n" +
            "    }\n" +
            "    .ProductListItem .QuickViewButtonPanel\n" +
            "    {\n" +
            "        width: 170px !important;\n" +
            "    }\n" +
            "    a.QuickViewButton\n" +
            "    {\n" +
            "        width: 70%;\n" +
            "        left: 15%;\n" +
            "    }\n" +
            "    .ProductListItem div.CommonProductImage\n" +
            "    {\n" +
            "        width: 34%;\n" +
            "    }\n" +
            "    /*--- ProductList : Tabular style ---*/\n" +
            "    .AdvancedSearchResult .ProductListTableViewTopItem .Image, .AdvancedSearchResult .ProductListTableViewItem .Image\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "    }\n" +
            "    .AdvancedSearchResult .ProductListTableViewTopItem .Button, .AdvancedSearchResult .ProductListTableViewItem .Button\n" +
            "    {\n" +
            "        width: 21%;\n" +
            "    }\n" +
            "    .AdvancedSearchResul .ProductListTableViewTopItem .Sku, .ProductListTableViewItem .Sku\n" +
            "    {\n" +
            "        width: 17%;\n" +
            "    }\n" +
            "    .AdvancedSearchResult .ProductListTableViewTopItem .Price, .AdvancedSearchResult .ProductListTableViewItem .Price\n" +
            "    {\n" +
            "    }\n" +
            "    .ProductListTableViewItem .ImagePanel\n" +
            "    {\n" +
            "        width: auto;\n" +
            "    }\n" +
            "    .ProductListTableViewTopItem .Image, .ProductListTableViewItem .Image\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "    }\n" +
            "    .ProductListTableViewTopItem .Button, .ProductListTableViewItem .Button\n" +
            "    {\n" +
            "        width: 21%;\n" +
            "    }\n" +
            "    .ProductListTableViewTopItem .Sku, .ProductListTableViewItem .Sku\n" +
            "    {\n" +
            "        width: 17%;\n" +
            "    }\n" +
            "    /*.ProductListTableViewTopItem .Price, .ProductListTableViewItem .Price{width: 19%;  }*/\n" +
            "    .ProductListTableViewTopItem .Price, .ProductListTableViewItem .Price\n" +
            "    {\n" +
            "        width: 17%;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .ImagePanel\n" +
            "    {\n" +
            "        width: 90px;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .ImagePanel img\n" +
            "    {\n" +
            "        max-width: 90px;\n" +
            "        width: 90px;\n" +
            "        max-height: 90px;\n" +
            "        height: 90px;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .BtnStyle1\n" +
            "    {\n" +
            "        padding: 2px 0;\n" +
            "        width: 100%;\n" +
            "        text-align: center;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .FreeShippingLabel\n" +
            "    {\n" +
            "        line-height: normal;\n" +
            "    }\n" +
            "    .TableViewTellFriendPanel, .TableViewAddtoWishListPanel, .TableViewAddtoCompareListPanel\n" +
            "    {\n" +
            "        margin-left: 8%;\n" +
            "    }\n" +
            "    .TableViewAddtoWishListPanel\n" +
            "    {\n" +
            "        margin-top: 15px;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .Name\n" +
            "    {\n" +
            "        width: 20%;\n" +
            "    }\n" +
            "    .ProductListTableViewTopItem .Name\n" +
            "    {\n" +
            "        width: 20%;\n" +
            "    }\n" +
            "    .ProductTableDataList .QuickViewButtonBorder\n" +
            "    {\n" +
            "        top: 0px;\n" +
            "        width: 125px !important;\n" +
            "        height: 90px !important;\n" +
            "        left: 0;\n" +
            "        right: 0;\n" +
            "    }\n" +
            "    .AdvancedSearchResult .TableViewTellFriendPanel, .TableViewAddtoWishListPanel, .TableViewAddtoCompareListPanel\n" +
            "    {\n" +
            "        margin-left: 20%;\n" +
            "    }\n" +
            "    .AdvancedSearchResult .ProductListTableViewItem .BtnStyle1\n" +
            "    {\n" +
            "        margin: 0px 5px 0px 15%;\n" +
            "        padding: 2px 10px;\n" +
            "        width: auto;\n" +
            "    }\n" +
            "\n" +
            "    /* Product Detail */\n" +
            "    .ProductDetailsResponsive .WriteReviewDiv .CommonHyperLink\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ProductQuickInfoPriceTitle\n" +
            "    {\n" +
            "        margin-top: 15px;\n" +
            "    }\n" +
            "    .ProductQuickInfoSku\n" +
            "    {\n" +
            "        margin-top: 15px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsiveOurPrice\n" +
            "    {\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .QuantityDiscountPanel\n" +
            "    {\n" +
            "        text-transform: none;\n" +
            "        margin-right: 10px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .FreeShippingLabel\n" +
            "    {\n" +
            "        margin-top: 15px;\n" +
            "        float: none;\n" +
            "        background: #F9FBFD url(\"Images/Icon/icon-free-shipping.gif\") no-repeat scroll 10px center;\n" +
            "    }\n" +
            "    .ProductQuickInfoStock\n" +
            "    {\n" +
            "        margin-bottom: 15px;\n" +
            "        margin-top: 15px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .RelatedProductsTitleRight\n" +
            "    {\n" +
            "        margin-top: 40px;\n" +
            "        border-bottom: 2px dotted #DDDDDD;\n" +
            "    }\n" +
            "    .ProductQuickInfoPriceTitle\n" +
            "    {\n" +
            "        margin-top: 15px;\n" +
            "    }\n" +
            "    .ProductQuickInfoSku\n" +
            "    {\n" +
            "        margin-right: 30px;\n" +
            "        margin-top: 19px;\n" +
            "        width: auto;\n" +
            "    }\n" +
            "    .ProductQuickInfoStock\n" +
            "    {\n" +
            "        color: #66767B;\n" +
            "        margin-bottom: 15px;\n" +
            "        margin-right: 30px;\n" +
            "        margin-top: 15px;\n" +
            "        width: auto;\n" +
            "    }\n" +
            "\n" +
            "    .RelatedProductsDatalist tr\n" +
            "    {\n" +
            "        display: table-cell;\n" +
            "        border-bottom: 0px;\n" +
            "        float: left;\n" +
            "        width: 33%;\n" +
            "    }\n" +
            "    .RelatedProductsItemTable\n" +
            "    {\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .RelatedProductsItemTable tr\n" +
            "    {\n" +
            "        display: table-row;\n" +
            "        float: none;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .CommonTextBox\n" +
            "    {\n" +
            "        width: 20% !important;\n" +
            "    }\n" +
            "    .RelatedProductsDatalist tr\n" +
            "    {\n" +
            "        width: 33%;\n" +
            "        border-bottom: 0px;\n" +
            "    }\n" +
            "    .RelatedProductsItemTable\n" +
            "    {\n" +
            "        border-bottom: 0px;\n" +
            "    }\n" +
            "    .OptionRadioItemDiv\n" +
            "    {\n" +
            "        margin-top: -10px;\n" +
            "        margin-left: 3px;\n" +
            "    }\n" +
            "    .OptionRadioItemRadioButtonList tr\n" +
            "    {\n" +
            "        float: none;\n" +
            "        display: inherit;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .RelatedProductsDetailsPriceDiv\n" +
            "    {\n" +
            "        color: rgb(155, 10 ,222);\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .OptionRadioItemRadioButtonList label\n" +
            "    {\n" +
            "        width: auto;\n" +
            "    }\n" +
            "    .Product .AddToWishListButtonLinkButton, .Product .AddToCompareListButtonLinkButton, .Product .TellFriendLinkButton\n" +
            "    {\n" +
            "        margin: 0;\n" +
            "        padding-right: 15px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .QuantityDiscountGridView\n" +
            "    {\n" +
            "        margin-bottom: 20px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .ButtonDiv\n" +
            "    {\n" +
            "        line-height: 30px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .ProductQuickInfoName\n" +
            "    {\n" +
            "        margin-bottom: 15px;\n" +
            "    }\n" +
            "\n" +
            "    /* ----- ProductDetailsResponsive : Image management ----- */\n" +
            "    #easy_zoom, #easy_zoom1\n" +
            "    {\n" +
            "        left: 50% !important;\n" +
            "        top: 295px !important;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive div.ProductDetailsResponsiveImage\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        min-height: 360px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive table.ProductDetailsResponsiveImage\n" +
            "    {\n" +
            "        height: 360px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .ProductDetailsResponsiveImage img\n" +
            "    {\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .ProductDetailsResponsiveImagePanel\n" +
            "    {\n" +
            "        height: 360px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsiveImageThumbnail .ImageThumbnailItemStyle\n" +
            "    {\n" +
            "        margin-right: 2%;\n" +
            "        width: 22%;\n" +
            "        min-height: 75px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsiveImageThumbnail table.CommonCategoryImage\n" +
            "    {\n" +
            "        height: 75px;\n" +
            "    }\n" +
            "\n" +
            "    /* New Arrival for category Begin */\n" +
            "    .NewArrivalCategory .SidebarRight\n" +
            "    {\n" +
            "        border: 0;\n" +
            "        background-color: #fff;\n" +
            "        padding: 0;\n" +
            "    }\n" +
            "    .NewArrivalCategoryList\n" +
            "    {\n" +
            "        width: 104%;\n" +
            "    }\n" +
            "    .NewArrivalCategoryList .CommonProductItemStyle\n" +
            "    {\n" +
            "        width: 46.333%;\n" +
            "        margin: 10px 3% 0 0;\n" +
            "        display: inline-block;\n" +
            "    }\n" +
            "\n" +
            "    /* Breadcrumb Begin */\n" +
            "    .catalog-center-col .CatalogBreadcrumb\n" +
            "    {\n" +
            "        position: absolute;\n" +
            "        top: -20px;\n" +
            "        margin-left: -260px;\n" +
            "    }\n" +
            "    .pdetail-row .CatalogBreadcrumb\n" +
            "    {\n" +
            "        position: absolute;\n" +
            "        top: -20px;\n" +
            "        margin-left: 5px;\n" +
            "    }\n" +
            "    .NewsMainDiv .CatalogBreadcrumb\n" +
            "    {\n" +
            "        position: absolute;\n" +
            "        top: -30px;\n" +
            "        margin-left: 0;\n" +
            "    }\n" +
            "\n" +
            "    /* NewsEvent */\n" +
            "    .NewsDate\n" +
            "    {\n" +
            "        width: 35%;\n" +
            "    }\n" +
            "    .NewsTopic\n" +
            "    {\n" +
            "        width: 62%;\n" +
            "    }\n" +
            "\n" +
            "    /* NewArrival Carousel */\n" +
            "    .NewArrival .jcarousel-skin-tango .jcarousel-clip-horizontal\n" +
            "    {\n" +
            "        width: 714px;\n" +
            "    }\n" +
            "    /*CompareList Begin*/\n" +
            "    .CompareListGridView .ImageHeader\n" +
            "    {\n" +
            "        width: 18%;\n" +
            "    }\n" +
            "    .CompareListGridView .DeleteHeader\n" +
            "    {\n" +
            "        width: 8%;\n" +
            "    }\n" +
            "    .CompareListGridView .PriceHeader\n" +
            "    {\n" +
            "        width: 20%;\n" +
            "    }\n" +
            "    .CompareListGridView .AddToCartHeader\n" +
            "    {\n" +
            "        width: 21%;\n" +
            "    }\n" +
            "    .CompareListGridView .AddToCartItem a\n" +
            "    {\n" +
            "        display: table;\n" +
            "        margin: auto;\n" +
            "        float: none;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "\n" +
            "    /*WishListGridView Begin*/\n" +
            "    .WishListGridView .ImageHeader\n" +
            "    {\n" +
            "        width: 18%;\n" +
            "    }\n" +
            "    .WishListGridView .DeleteHeader\n" +
            "    {\n" +
            "        width: 8%;\n" +
            "    }\n" +
            "    .WishListGridView .PriceHeader\n" +
            "    {\n" +
            "        width: 20%;\n" +
            "    }\n" +
            "    .WishListGridView .AddToCartHeader\n" +
            "    {\n" +
            "        width: 21%;\n" +
            "    }\n" +
            "    .WishListGridView .AddToCartItem a\n" +
            "    {\n" +
            "        display: table;\n" +
            "        margin: auto;\n" +
            "        float: none;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "\n" +
            "    /*OrderHistory Begin*/\n" +
            "    .OrderHistoryGridView th, .OrderHistoryGridView td\n" +
            "    {\n" +
            "        padding: 3px 1%;\n" +
            "    }\n" +
            "\n" +
            "    /*PasswordDetails Begin*/\n" +
            "    .PasswordDetailsLabelColumn\n" +
            "    {\n" +
            "        width: 34%;\n" +
            "    }\n" +
            "    .PasswordDetailsInputColumn\n" +
            "    {\n" +
            "        width: 62%;\n" +
            "    }\n" +
            "    .PasswordDetailsButtonDiv\n" +
            "    {\n" +
            "        margin-right: 6%;\n" +
            "    }\n" +
            "\n" +
            "    /*ShippingAddressBook Begin*/\n" +
            "    .ShippingAddressBookList tr\n" +
            "    {\n" +
            "        width: 45%;\n" +
            "        margin-right: 5%;\n" +
            "        float: left;\n" +
            "    }\n" +
            "    .ShippingAliasNameTitle\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .ShippingAddress\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        float: left;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .ShippingAddressLinkPanel\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .ShippingAddressLinkPanel .BtnStyle2\n" +
            "    {\n" +
            "        margin: 0 0 5px;\n" +
            "    }\n" +
            "    .AccountMainDiv .CustomerRegisterLeft, .AccountMainDiv .CustomerRegisterRight\n" +
            "    {\n" +
            "        margin-left: 8%;\n" +
            "        margin-right: 0;\n" +
            "        width: 90%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .AccountMainDiv .CustomerRegisterLeftLabel, .AccountMainDiv .CustomerRegisterRightLabel\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .AccountMainDiv .CustomerRegisterLeftData, .AccountMainDiv .CustomerRegisterRightData\n" +
            "    {\n" +
            "        width: 70%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .AccountMainDiv .CustomerRegister .CustomerRegisterCityStatePanel\n" +
            "    {\n" +
            "        margin-left: 8%;\n" +
            "        width: 90%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .AccountMainDiv .CustomerRegister .CustomerRegisterCityStatePanel .CustomerRegisterLabel\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .AccountMainDiv .CustomerRegister .CustomerRegisterCityStatePanel .CountryAndStateListDropDown\n" +
            "    {\n" +
            "        width: 63%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .AccountMainDiv .CustomerRegister .CustomerRegisterCheckBox\n" +
            "    {\n" +
            "        margin-left: 30%;\n" +
            "        width: 65%;\n" +
            "    }\n" +
            "    .AccountMainDiv .CustomerRegister .CustomerRegisterCityStatePanel .CountryAndStateListCountryTextBox\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        float: left;\n" +
            "        margin-left: 25%;\n" +
            "        width: 63%;\n" +
            "    }\n" +
            "    .AccountMainDiv .CustomerRegister .CustomerRegisterCityStatePanel .CountryAndStateListStateTextBox\n" +
            "    {\n" +
            "        clear: none;\n" +
            "        float: right;\n" +
            "        margin-left: 0;\n" +
            "        margin-right: 12%;\n" +
            "        width: 63%;\n" +
            "    }\n" +
            "    .AccountMainDiv .CustomerRegister .CustomerRegisterLeft .AccountDetailsCheckBoxDiv\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        margin-left: 0;\n" +
            "        padding-bottom: 20px;\n" +
            "    }\n" +
            "    .AccountDetailsPanel .ClientCityStatePanel\n" +
            "    {\n" +
            "        margin-left: 8%;\n" +
            "        width: 90%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .AccountDetailsPanel .ClientCityStatePanel .CustomerRegisterLabel\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .AccountDetailsPanel .ClientCityStatePanel .CountryAndStateListDropDown\n" +
            "    {\n" +
            "        width: 63%;\n" +
            "        margin: 0;\n" +
            "        clear: none;\n" +
            "    }\n" +
            "    .AccountDetailsPanel .ClientCityStatePanel .CountryAndStateListCountryTextBox, .AccountDetailsPanel .ClientCityStatePanel .CountryAndStateListStateTextBox\n" +
            "    {\n" +
            "        clear: none;\n" +
            "        float: right;\n" +
            "        margin-left: 0;\n" +
            "        margin-right: 12%;\n" +
            "        width: 63%;\n" +
            "    }\n" +
            "    .AccountDetailsPanel .CustomerRegisterCheckBox\n" +
            "    {\n" +
            "        margin: 0 0 15px 30%;\n" +
            "    }\n" +
            "    .AccountDetailsPanel .ClientCityStatePanel .CommonAsterisk\n" +
            "    {\n" +
            "        margin-left: 5px;\n" +
            "    }\n" +
            "\n" +
            "    /* Customer Info - Billing Address Begin*/\n" +
            "    .AccountDetails .CustomerRegisterLeft, .AccountDetails .CustomerRegisterRight\n" +
            "    {\n" +
            "        margin-left: 8%;\n" +
            "        margin-right: 0;\n" +
            "        width: 90%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .AccountDetails .CustomerRegisterLeftLabel, .AccountDetails .CustomerRegisterRightLabel\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .AccountDetails .CustomerRegisterLeftData, .AccountDetails .CustomerRegisterRightData\n" +
            "    {\n" +
            "        width: 70%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .AccountDetails .AccountDetailsPanel .ClientCityStatePanel\n" +
            "    {\n" +
            "        margin-left: 8%;\n" +
            "        width: 90%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .AccountDetails .AccountDetailsPanel .ClientCityStatePanel .CustomerRegisterLabel\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .AccountDetails .AccountDetailsPanel .ClientCityStatePanel .CountryAndStateListDropDown\n" +
            "    {\n" +
            "        width: 63%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .AccountDetails .AccountDetailsPanel .CustomerRegisterCheckBox\n" +
            "    {\n" +
            "        margin-left: 30%;\n" +
            "        width: 65%;\n" +
            "    }\n" +
            "    .AccountDetails .AccountDetailsPanel .ClientCityStatePanel .CountryAndStateListCountryTextBox\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        float: left;\n" +
            "        margin-left: 25%;\n" +
            "        width: 63%;\n" +
            "    }\n" +
            "    .AccountDetails .AccountDetailsPanel .ClientCityStatePanel .CountryAndStateListStateTextBox\n" +
            "    {\n" +
            "        clear: none;\n" +
            "        float: right;\n" +
            "        margin-left: 0;\n" +
            "        margin-right: 12%;\n" +
            "        width: 63%;\n" +
            "    }\n" +
            "\n" +
            "    /* Advanced Search*/\n" +
            "    .SearchTextByKeyword input[type=\"text\"]\n" +
            "    {\n" +
            "        width: 30%;\n" +
            "    }\n" +
            "    .SearchByCategoryField\n" +
            "    {\n" +
            "        width: 50%;\n" +
            "    }\n" +
            "    .AdvancedSearchDrop\n" +
            "    {\n" +
            "        width: 35%;\n" +
            "    }\n" +
            "    .SearchTextByKeyword\n" +
            "    {\n" +
            "        width: 35%;\n" +
            "        margin-left: 10%;\n" +
            "    }\n" +
            "    .AdvancedSearchTypeCheckList\n" +
            "    {\n" +
            "        width: 90%;\n" +
            "    }\n" +
            "    .SearchByCategory .AdvancedSearchDrop\n" +
            "    {\n" +
            "        width: 80%;\n" +
            "    }\n" +
            "    .AdvancedSearchDrop select\n" +
            "    {\n" +
            "        width: 100% !important;\n" +
            "    }\n" +
            "    .AdvancedSearchManufacturerLabel, .AdvancedSearchDepartmentLabel, .AdvancedSearchVendorLabel\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "    }\n" +
            "    .SearchByManufacturer .AdvancedSearchDrop, .SearchByDepartment .AdvancedSearchDrop .SearchByVendor\n" +
            "    {\n" +
            "        width: 75%;\n" +
            "    }\n" +
            "    .AdvancedSearchResult .FreeShippingLabel\n" +
            "    {\n" +
            "        margin-left: 18%;\n" +
            "    }\n" +
            "\n" +
            "    /* UserLogin */\n" +
            "    .CommonUserLoginPanelUserName label, .CommonUserLoginPanelPassword label\n" +
            "    {\n" +
            "        width: 35%;\n" +
            "    }\n" +
            "    .CommonUserLoginPanelUserName input, .CommonUserLoginPanelPassword input\n" +
            "    {\n" +
            "        width: 50% !important;\n" +
            "    }\n" +
            "    .CommonUserLoginValidatorText\n" +
            "    {\n" +
            "        margin-left: 35%;\n" +
            "        width: 50%;\n" +
            "    }\n" +
            "    .CommonUserLoginPanelRemember\n" +
            "    {\n" +
            "        margin-left: 34%;\n" +
            "    }\n" +
            "    .CommonUserLoginPanelRemember label\n" +
            "    {\n" +
            "        width: 60%;\n" +
            "    }\n" +
            "    .CommonUserLoginPanelButton, .CommonUserLoginForgotPasswordDiv\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        margin-left: 35%;\n" +
            "        width: 50%;\n" +
            "        margin-bottom: 0;\n" +
            "    }\n" +
            "\n" +
            "    /* CheckoutIndicator Begin */\n" +
            "    .CheckoutIndicatorTable .LoginOn a, .CheckoutIndicatorTable .LoginPassed a, .CheckoutIndicatorTable .SummaryOff a, .CheckoutIndicatorTable .SummaryOn a\n" +
            "    {\n" +
            "        background-position: center center;\n" +
            "    }\n" +
            "    .CheckoutAddressRight\n" +
            "    {\n" +
            "        clear: left;\n" +
            "    }\n" +
            "\n" +
            "    /* Checkout */\n" +
            "    .CheckoutLogin .CommonLoginPage\n" +
            "    {\n" +
            "        width: 96%;\n" +
            "        margin: 0 2%;\n" +
            "    }\n" +
            "    .checkout-right-col\n" +
            "    {\n" +
            "        width: 35%;\n" +
            "    }\n" +
            "\n" +
            "    /*Checkout - Payment Begin*/\n" +
            "    .PaymentDataList\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .PaymentAgreeBox\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .PaymentValidatorText1\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .PaymentFrame .CountryAndStateList .CountryAndStateListDropDown\n" +
            "    {\n" +
            "        clear: both;\n" +
            "    }\n" +
            "    .PaymentFrame .CommonFormData\n" +
            "    {\n" +
            "        width: auto;\n" +
            "    }\n" +
            "    .PaymentButtonDiv\n" +
            "    {\n" +
            "        width: 22%;\n" +
            "        margin-right: 0;\n" +
            "    }\n" +
            "    .PaymentItemImageDiv\n" +
            "    {\n" +
            "        margin-right: 15%;\n" +
            "    }\n" +
            "\n" +
            "    /*Checkout - CustomerRegister Address Begin*/\n" +
            "    .MainDiv .CustomerRegister\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegister\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterLeft, .Checkout .CustomerRegisterRight\n" +
            "    {\n" +
            "        margin-left: 8%;\n" +
            "        margin-right: 0;\n" +
            "        width: 90%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterLeftLabel, .Checkout .CustomerRegisterRightLabel\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterLeftData, .Checkout .CustomerRegisterRightData\n" +
            "    {\n" +
            "        width: 70%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .Checkout .ClientCityStatePanel\n" +
            "    {\n" +
            "        margin-left: 8%;\n" +
            "        width: 90%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterPanel .ClientCityStatePanel .CustomerRegisterLabel\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .Checkout .ClientCityStatePanel .CountryAndStateListDropDown\n" +
            "    {\n" +
            "        width: 63%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterPanel .CustomerRegisterCheckBox\n" +
            "    {\n" +
            "        margin-left: 30%;\n" +
            "        width: 65%;\n" +
            "    }\n" +
            "    .Checkout .ClientCityStatePanel .CountryAndStateListCountryTextBox\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        float: left;\n" +
            "        margin-left: 25%;\n" +
            "        width: 63%;\n" +
            "    }\n" +
            "    .Checkout .ClientCityStatePanel .CountryAndStateListStateTextBox\n" +
            "    {\n" +
            "        clear: none;\n" +
            "        float: right;\n" +
            "        margin-left: 0;\n" +
            "        margin-right: 12%;\n" +
            "        width: 63%;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerRegisterCityStatePanel\n" +
            "    {\n" +
            "        margin-left: 8%;\n" +
            "        width: 90%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerRegisterCityStatePanel .CustomerRegisterLabel\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerRegisterCityStatePanel .CountryAndStateListDropDown\n" +
            "    {\n" +
            "        width: 63%;\n" +
            "        margin: 0;\n" +
            "        clear: none;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerRegisterCheckBox\n" +
            "    {\n" +
            "        margin-left: 30%;\n" +
            "        width: 65%;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerRegisterCityStatePanel .CountryAndStateListCountryTextBox\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        float: left;\n" +
            "        margin-left: 25%;\n" +
            "        width: 63%;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerRegisterCityStatePanel .CountryAndStateListStateTextBox\n" +
            "    {\n" +
            "        clear: none;\n" +
            "        float: right;\n" +
            "        margin-left: 0;\n" +
            "        margin-right: 12%;\n" +
            "        width: 63%;\n" +
            "    }\n" +
            "    /*--- TaxExempt ---*/\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CommonFormData\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CommonFormData .CustomerRegisterCheckBox\n" +
            "    {\n" +
            "        margin-left: 30%;\n" +
            "        width: 65%;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel\n" +
            "    {\n" +
            "        margin-left: 8%;\n" +
            "        margin-right: 0;\n" +
            "        width: 90%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel .CommonFormLabel\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel .CommonFormData\n" +
            "    {\n" +
            "        clear: none;\n" +
            "        margin: 0;\n" +
            "        width: 70%;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel .CommonFormData .CheckoutTextBox\n" +
            "    {\n" +
            "        width: 90% !important;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel .ClientCityStatePanel .CountryAndStateListCountryTextBox\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        float: left;\n" +
            "        margin-left: 25%;\n" +
            "        width: 65%;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel .ClientCityStatePanel .CountryAndStateListStateTextBox\n" +
            "    {\n" +
            "        clear: none;\n" +
            "        float: right;\n" +
            "        margin-left: 0;\n" +
            "        margin-right: 10%;\n" +
            "        width: 65%;\n" +
            "    }\n" +
            "\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel .ClientCityStatePanel\n" +
            "    {\n" +
            "        margin: 0;\n" +
            "        width: 100%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .CheckoutAddressLong\n" +
            "    {\n" +
            "        margin-left: 29%;\n" +
            "        width: 70%;\n" +
            "    }\n" +
            "    .CheckoutSpecialRequestPanel .CheckoutAddressLong\n" +
            "    {\n" +
            "        margin-left: 36.25%;\n" +
            "        width: 62%;\n" +
            "    }\n" +
            "    .CheckoutSpecialRequestPanel .GiftCouponDetailSpecialRequestTextBox\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        margin-top: 20px;\n" +
            "    }\n" +
            "    .Checkout .CheckoutAddressLeft, .Checkout .CheckoutAddressRight\n" +
            "    {\n" +
            "        margin-left: 8%;\n" +
            "        margin-right: 0;\n" +
            "        width: 90%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .Checkout .CheckoutAddressLeftLabel, .Checkout .CheckoutAddressRightLabel\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .Checkout .CheckoutAddressLeftData, .Checkout .CheckoutAddressRightData\n" +
            "    {\n" +
            "        width: 70%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .CheckoutAddressLeftDataCheckbox .CustomerRegisterCheckBox\n" +
            "    {\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .CheckoutSaleTaxExemptPanel .CheckoutAddressLong\n" +
            "    {\n" +
            "        margin-bottom: 10px;\n" +
            "    }\n" +
            "    .Checkout .ClientCityStatePanel .CheckoutAddressLabel\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "\n" +
            "    /*--- TaxExempt ---*/\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CommonFormData\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CommonFormData .CustomerRegisterCheckBox\n" +
            "    {\n" +
            "        margin-left: 30%;\n" +
            "        width: 65%;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel\n" +
            "    {\n" +
            "        margin-left: 8%;\n" +
            "        margin-right: 0;\n" +
            "        width: 90%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel .CommonFormLabel\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel .CommonFormData\n" +
            "    {\n" +
            "        clear: none;\n" +
            "        margin: 0;\n" +
            "        width: 70%;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel .CommonFormData .CheckoutTextBox\n" +
            "    {\n" +
            "        width: 90% !important;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel .ClientCityStatePanel .CountryAndStateListDropDown\n" +
            "    {\n" +
            "        width: 63%;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel .ClientCityStatePanel .CountryAndStateListCountryTextBox\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        float: left;\n" +
            "        margin-left: 25%;\n" +
            "        width: 65%;\n" +
            "    }\n" +
            "    .Checkout .CustomerRegisterShippingInfoPanel .CustomerTaxExemptPanel .ClientCityStatePanel .CountryAndStateListStateTextBox\n" +
            "    {\n" +
            "        clear: none;\n" +
            "        float: right;\n" +
            "        margin-left: 0;\n" +
            "        margin-right: 10%;\n" +
            "        width: 65%;\n" +
            "    }\n" +
            "\n" +
            "    /* Order summary */\n" +
            "    .OrderSummaryUnitPriceHeaderStyle\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "    }\n" +
            "    .OrderSummaryQuantityHeaderStyle\n" +
            "    {\n" +
            "        width: 23%;\n" +
            "    }\n" +
            "    .OrderSummarySubtotalHeaderStyle\n" +
            "    {\n" +
            "        width: 20%;\n" +
            "    }\n" +
            "    .OrderSummarySummaryLabel\n" +
            "    {\n" +
            "        width: 80%;\n" +
            "    }\n" +
            "    .OrderSummarySummaryValue\n" +
            "    {\n" +
            "        width: 20%;\n" +
            "    }\n" +
            "    .OrderSummaryShippingDetailsLabelColumn\n" +
            "    {\n" +
            "        width: 30%;\n" +
            "    }\n" +
            "\n" +
            "    /*Shopping Cart*/\n" +
            "    .ShoppingCartGiftCouponInputCenter\n" +
            "    {\n" +
            "        margin: 35px 0 0 0;\n" +
            "    }\n" +
            "    .ShoppingCartOrderTotal\n" +
            "    {\n" +
            "        padding: 40px 0.5% 35px 0.5%;\n" +
            "        margin-top: 5.5%;\n" +
            "    }\n" +
            "    .ShoppingCartGiftCouponTable\n" +
            "    {\n" +
            "        margin-bottom: 9%;\n" +
            "    }\n" +
            "    .ShoppingCartGridView .ImageHeader\n" +
            "    {\n" +
            "        width: 14%;\n" +
            "    }\n" +
            "    .ShoppingCartGridView .PriceHeader\n" +
            "    {\n" +
            "        width: 14%;\n" +
            "    }\n" +
            "    .ShoppingCartGridView .QuantityHeader\n" +
            "    {\n" +
            "        width: 8.5%;\n" +
            "    }\n" +
            "    .ShoppingCartGridView .SubtotalHeader\n" +
            "    {\n" +
            "        width: 15%;\n" +
            "    }\n" +
            "    .ShoppingCartGridView .DeleteHeader\n" +
            "    {\n" +
            "        width: 9%;\n" +
            "    }\n" +
            "    .GiftCouponDetailValidatorText\n" +
            "    {\n" +
            "        margin-left: 0px;\n" +
            "        width: 75%;\n" +
            "    }\n" +
            "    .ShoppingCartGiftCoupon .GiftCouponDetailValidatorText\n" +
            "    {\n" +
            "        margin-left: 0px;\n" +
            "        width: 75%;\n" +
            "    }\n" +
            "    .ShoppingCartTotalAmountLabel\n" +
            "    {\n" +
            "        font-size: 16px;\n" +
            "    }\n" +
            "    .ShoppingCartTotalAmount\n" +
            "    {\n" +
            "        font-size: 16px;\n" +
            "    }\n" +
            "    .ShoppingCartCheckoutLink\n" +
            "    {\n" +
            "        padding: 0.5% 5px;\n" +
            "    }\n" +
            "\n" +
            "    /*CustomerReview*/\n" +
            "    .CustomerReviewContent\n" +
            "    {\n" +
            "        float: right;\n" +
            "        width: 60%;\n" +
            "        padding-top: 10px;\n" +
            "        margin-left: 2%;\n" +
            "    }\n" +
            "    .CustomerReviewProductDetail\n" +
            "    {\n" +
            "        float: left;\n" +
            "        width: 35%;\n" +
            "        padding: 10px;\n" +
            "    }\n" +
            "    .CustomerReviewProductDetail .ProductImage\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        clear: left;\n" +
            "        display: inline-block;\n" +
            "        margin-bottom: 15px;\n" +
            "        text-align: center;\n" +
            "    }\n" +
            "    .CustomerReviewProductDetail .ProductImage img\n" +
            "    {\n" +
            "        max-height: 150px;\n" +
            "        height: auto !important;\n" +
            "        width: auto !important;\n" +
            "        max-width: 150px;\n" +
            "    }\n" +
            "    .CustomerReviewProductDetail .ProductInfo\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "\n" +
            "\n" +
            "    /* UserLogin */\n" +
            "    .UserLogin .CommonLoginPageRight\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "\n" +
            "    /*ContentLayout Begin*/\n" +
            "    .ContentMainDiv .common-center-col\n" +
            "    {\n" +
            "        float: right;\n" +
            "    }\n" +
            "    .ContentMainDiv .common-rightside-col\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        float: left !important;\n" +
            "        padding: 0 0 0 20px;\n" +
            "    }\n" +
            "\n" +
            "    /* Promotion List */\n" +
            "    .PromotionGroupListItemImageDiv\n" +
            "    {\n" +
            "        width: 160px;\n" +
            "    }\n" +
            "    .PromotionGroupListItemImageDiv img\n" +
            "    {\n" +
            "        max-height: 160px;\n" +
            "        height: auto !important;\n" +
            "        height: 160px;\n" +
            "        max-width: 160px;\n" +
            "        width: auto !important;\n" +
            "        width: 160px;\n" +
            "    }\n" +
            "\n" +
            "    /* Promotion Product Item List */\n" +
            "    .PromotionItem .ProductDetailsDefaultLikeButtonDiv\n" +
            "    {\n" +
            "        width: 35%;\n" +
            "    }\n" +
            "    .PromotionProductItem .ProductImage\n" +
            "    {\n" +
            "        left: 12%;\n" +
            "    }\n" +
            "    .PromotionProductGroupDataList .ProductGroupCombineItem\n" +
            "    {\n" +
            "        width: 28px;\n" +
            "    }\n" +
            "    .PromotionProductGroupDataList .ProductGroupCombineItem div\n" +
            "    {\n" +
            "        width: 28px;\n" +
            "    }\n" +
            "    .PromotionItem .PromotionDetailsDefaultImageTellFriendImage\n" +
            "    {\n" +
            "        width: 85%;\n" +
            "    }\n" +
            "    .PromotionProductGroupDataList .ProductGroupProductItemStyle\n" +
            "    {\n" +
            "        width: 135px;\n" +
            "    }\n" +
            "    .PromotionProductGroupDataList .PromotionProductItem\n" +
            "    {\n" +
            "        min-height: 180px;\n" +
            "    }\n" +
            "\n" +
            "    /* Contact Us */\n" +
            "    .ContactUsCaptcha\n" +
            "    {\n" +
            "        width: 75%;\n" +
            "    }\n" +
            "\n" +
            "    /* Tell a friend */\n" +
            "    .TellFriendFormData\n" +
            "    {\n" +
            "        width: 70%;\n" +
            "    }\n" +
            "\n" +
            "    /*Register*/\n" +
            "    .Register .CustomerRegister .CustomerRegisterLinkButtonDiv\n" +
            "    {\n" +
            "        margin-right: 4%;\n" +
            "    }\n" +
            "\n" +
            "    /* GiftCertificate */\n" +
            "    .GiftCertificateTextBox\n" +
            "    {\n" +
            "        width: 45% !important;\n" +
            "    }\n" +
            "}\n" +
            "@media only screen and (max-width: 767px) /*Screen width 480-767 px -------------- For step 2 ------------ */\n" +
            "{\n" +
            "    .HeaderLoginWishlist .WishlistLink {\n" +
            "        color: white !important; /*armando*/\n" +
            "    }\n" +
            "    .HeaderLoginWishlist a, .HeaderLoginAccount a {\n" +
            "        color: black !important; /*armando*/\n" +
            "    }\n" +
            "    .header-container3 {\n" +
            "        background: none; /*armando*/\n" +
            "    }\n" +
            "    .GiftRegistryDetailDiv input[type=\"text\"]\n" +
            "    {\n" +
            "        width: 90%;\n" +
            "    }\n" +
            "    .CountryAndStateListDropDown\n" +
            "    {\n" +
            "        width: 60%;\n" +
            "    }\n" +
            "    .HeaderLogin\n" +
            "    {\n" +
            "        padding-left: 10px;\n" +
            "    }\n" +
            "    .HeaderLogo img\n" +
            "    {\n" +
            "        padding-left: 10px;\n" +
            "    }\n" +
            "    .FrontMasterMiddle\n" +
            "    {\n" +
            "        width: 93%;\n" +
            "        margin: 20px auto;\n" +
            "    }\n" +
            "    .FrontMasterMiddle\n" +
            "    {\n" +
            "        margin-top: 5px;\n" +
            "    }\n" +
            "    .header-container1 .columns\n" +
            "    {\n" +
            "        line-height: 40px;\n" +
            "    }\n" +
            "    .header-container3 .row\n" +
            "    {\n" +
            "        background-color: rgb(155, 10 ,222);\n" +
            "    }\n" +
            "    .MainDivLeft\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ShoppingCartShippingEstimatorInput, .ShoppingCartShippingEstimator select\n" +
            "    {\n" +
            "        width: 65%;\n" +
            "        clear: right;\n" +
            "    }\n" +
            "\n" +
            "    /*Register */\n" +
            "    .MainDiv .CustomerRegister\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "\n" +
            "    /* Footer*/\n" +
            "    .four.MenuFooter\n" +
            "    {\n" +
            "        width: 31.5%;\n" +
            "    }\n" +
            "    .four.MenuFooter.CustomerMenu\n" +
            "    {\n" +
            "        width: 37%;\n" +
            "    }\n" +
            "    .LayoutFooter .MenuItemTitleOuter, .LayoutFooter a.MenuItemTitleOuter, .LayoutFooter .MenuItemTitle\n" +
            "    {\n" +
            "        width: auto;\n" +
            "    }\n" +
            "    .LayoutFooter .CustomerMenu .MenuItemTitleOuter\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .LayoutFooterLicense\n" +
            "    {\n" +
            "        line-height: 20px;\n" +
            "        padding: 10px 0;\n" +
            "    }\n" +
            "    .poweredby-footer\n" +
            "    {\n" +
            "        position: relative;\n" +
            "        right: auto;\n" +
            "        top: auto;\n" +
            "        clear: both;\n" +
            "        display: table;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .MenuItemTitleInner\n" +
            "    {\n" +
            "        padding-right: 22px;\n" +
            "        padding-bottom: 5px;\n" +
            "    }\n" +
            "    .MenuItemTitleOuter\n" +
            "    {\n" +
            "        background: url(Images/Bullet/footer-toggle-show.gif) no-repeat right 8px;\n" +
            "        line-height: 22px;\n" +
            "    }\n" +
            "    .MenuItemTitleOuterHide\n" +
            "    {\n" +
            "        background: url(Images/Bullet/footer-toggle-hide.gif) no-repeat right 8px;\n" +
            "    }\n" +
            "\n" +
            "    .LayoutFooter .MenuItemTitleInner\n" +
            "    {\n" +
            "        border-bottom: solid 1px #262626;\n" +
            "    }\n" +
            "    .LayoutFooter .MenuItemTitleOuter\n" +
            "    {\n" +
            "        border-bottom: solid 1px #404040;\n" +
            "    }\n" +
            "\n" +
            "    /*Common Product Item Style */\n" +
            "    .CommonProductItemStyle\n" +
            "    {\n" +
            "        width: 46%;\n" +
            "        margin: 20px 3% 20px 0;\n" +
            "        display: inline-block;\n" +
            "    }\n" +
            "\n" +
            "    /* NewArrival Carousel */\n" +
            "    .NewArrival .jcarousel-skin-tango .jcarousel-clip-horizontal\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "\n" +
            "    /*--- Product Row Style ---*/\n" +
            "    .ProductRowDataList .CommonProductItemStyle\n" +
            "    {\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .ProductListItem .CommonProductImage\n" +
            "    {\n" +
            "        width: 30.5%;\n" +
            "    }\n" +
            "    .ProductListItem .ProductListItemDetailsColumn\n" +
            "    {\n" +
            "        width: 69.5%;\n" +
            "        padding: 25px 3%;\n" +
            "    }\n" +
            "    .AdvancedSearchResult .ProductListItem .ProductListItemDetailsColumn\n" +
            "    {\n" +
            "        width: 69.5%;\n" +
            "        padding: 30px 5%;\n" +
            "    }\n" +
            "    .ProductListItem .CommonProductImage img\n" +
            "    {\n" +
            "        max-width: 145px;\n" +
            "    }\n" +
            "    .AdvancedSearchResult .ProductRowDataList .CommonProductItemStyle\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    /*--- ProductList : Tabular style ---*/\n" +
            "    .AdvancedSearchResult .ProductListTableViewTopItem .Image, .AdvancedSearchResult .ProductListTableViewItem .Image\n" +
            "    {\n" +
            "        width: 21%;\n" +
            "    }\n" +
            "    .AdvancedSearchResult .ProductListTableViewTopItem .Button, .AdvancedSearchResult .ProductListTableViewItem .Button\n" +
            "    {\n" +
            "    }\n" +
            "    .ProductListTableViewItem .ImagePanel\n" +
            "    {\n" +
            "        width: 80px;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .ImagePanel img\n" +
            "    {\n" +
            "        max-width: 80px;\n" +
            "        width: 80px;\n" +
            "        max-height: 80px;\n" +
            "        height: 80px;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .PriceDiscountLabel\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .CommonProductName\n" +
            "    {\n" +
            "        margin: 10px 0;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .AdvancedSearchResult .TableViewTellFriendPanel, .TableViewAddtoWishListPanel, .TableViewAddtoCompareListPanel\n" +
            "    {\n" +
            "        margin-left: 0;\n" +
            "    }\n" +
            "\n" +
            "    /*Default */\n" +
            "    .RandomProductDataList, .ProductBestSellingDataList\n" +
            "    {\n" +
            "        width: 105%;\n" +
            "    }\n" +
            "    .NewsEventItemStyle\n" +
            "    {\n" +
            "        width: 46%;\n" +
            "        margin: 20px 3% 20px 0;\n" +
            "    }\n" +
            "    .NewsEventList\n" +
            "    {\n" +
            "        width: 105%;\n" +
            "    }\n" +
            "\n" +
            "    /* Header */\n" +
            "    .MyAccountSection\n" +
            "    {\n" +
            "        display: table-header-group;\n" +
            "    }\n" +
            "    .SearchSection\n" +
            "    {\n" +
            "        display: table-footer-group;\n" +
            "    }\n" +
            "    .SwitchLanguage, .CurrencyControl\n" +
            "    {\n" +
            "        display: table-row-group;\n" +
            "        margin-top: 10px;\n" +
            "    }\n" +
            "    /*--- MiniCart ---*/\n" +
            "    .HeaderShoppingCart\n" +
            "    {\n" +
            "        margin-top: 15px;\n" +
            "        height: 23px;\n" +
            "    }\n" +
            "    .HeaderShoppingCart .HeaderShoppingCartDiv\n" +
            "    {\n" +
            "        float: right;\n" +
            "        margin-bottom: 10px;\n" +
            "        padding: 0 5px;\n" +
            "    }\n" +
            "    .HeaderShoppingCart .HeaderShoppingCartCheckout\n" +
            "    {\n" +
            "        float: right;\n" +
            "        clear: right;\n" +
            "    }\n" +
            "    /*--- Search ---*/\n" +
            "    .Search\n" +
            "    {\n" +
            "        clear: both;\n" +
            "        width: 115%;\n" +
            "        margin: 15px 40% 15px 0;\n" +
            "        position: relative;\n" +
            "    }\n" +
            "    .QuickSearchDropDownDiv\n" +
            "    {\n" +
            "        width: 18%;\n" +
            "    }\n" +
            "    .QuickSearchSelectedDropDownDiv\n" +
            "    {\n" +
            "        width: 35%;\n" +
            "    }\n" +
            "    .QuickSearch input[type=\"text\"].QuickSearchText\n" +
            "    {\n" +
            "    }\n" +
            "    .QuickSearch input[type=\"text\"].QuickSearchSelectedText\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "    }\n" +
            "    /*--- Header Login ---*/\n" +
            "    .header-container1 .columns, .header-container3 .columns, .header-container4 .columns\n" +
            "    {\n" +
            "        padding: 0;\n" +
            "    }\n" +
            "    /*--- Header Menu ---*/\n" +
            "    .header-container3\n" +
            "    {\n" +
            "        padding: 0;\n" +
            "    }\n" +
            "    .HeaderMenu\n" +
            "    {\n" +
            "        padding: 0;\n" +
            "    }\n" +
            "    .HeaderMenu ul\n" +
            "    {\n" +
            "        border-left: solid 1px rgb(87, 17, 119);\n" +
            "        border-right: solid 1px rgb(189, 0, 222);\n" +
            "        border-bottom: solid 1px rgb(87, 17, 119);\n" +
            "        border-top: 0;\n" +
            "        float: none;\n" +
            "    }\n" +
            "    .HeaderMenu ul li\n" +
            "    {\n" +
            "        display: inline-block;\n" +
            "        width: 50%;\n" +
            "        border-top: solid 1px white;/*rgb(189, 0, 222);Armando*/\n" +
            "        border-bottom: solid 1px white;/*rgb(87, 17, 119);*/\n" +
            "        border-right: solid 1px white;/*rgb(87, 17, 119);*/\n" +
            "        border-left: solid 1px white;/*rgb(189, 0, 222);*/\n" +
            "    }\n" +
            "    .HeaderMenu ul li table.ContentMenuNavMenuList, .ContentMenuNavList\n" +
            "    {\n" +
            "        width: 100% !important;\n" +
            "    }\n" +
            "    .HeaderMenu ul li table.ContentMenuNavMenuList a, .HeaderMenu ul li a.HyperLink, .HeaderMenu a.ContentMenuNavListStaticMenuItem\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        margin: 0;\n" +
            "        padding: 0px 20px;\n" +
            "        text-align: left;\n" +
            "        border: 0;\n" +
            "        line-height: 22px;\n" +
            "        height: 22px;\n" +
            "    }\n" +
            "    .HeaderMenu ul li table.ContentMenuNavMenuList a:hover, .HeaderMenu ul li a.HyperLink:hover, .HeaderMenu a.ContentMenuNavListStaticMenuItem:hover\n" +
            "    {\n" +
            "        background-color: #eee;\n" +
            "        color: #555;\n" +
            "        border-radius: 0;\n" +
            "    }\n" +
            "    .HeaderMenu ul ul, .HeaderMenu ul li ul li\n" +
            "    {\n" +
            "        border: 0;\n" +
            "    }\n" +
            "\n" +
            "    .headerMenuNormal\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .headerMenuResponsive\n" +
            "    {\n" +
            "        display: block;\n" +
            "    }\n" +
            "\n" +
            "    /*--- Category & Product Item ---*/\n" +
            "    .ContentMenuNavMenuListDynamicMenuStyle\n" +
            "    {\n" +
            "        display: none !important;\n" +
            "    }\n" +
            "    .QuickViewButtonBorder, a.QuickViewButton\n" +
            "    {\n" +
            "        display: none !important;\n" +
            "    }\n" +
            "    .CategoryDescription\n" +
            "    {\n" +
            "        font-size: 11px;\n" +
            "    }\n" +
            "\n" +
            "    /* ----- ProductDetailsResponsive ----- */\n" +
            "    .ProductDetailsResponsive .WriteReviewDiv .CommonHyperLink\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .StarRatingSummaryTable\n" +
            "    {\n" +
            "        position: relative;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .pdetail-sec-four .StarRatingSummaryButtonColumn\n" +
            "    {\n" +
            "        right: 0;\n" +
            "        position: absolute;\n" +
            "        top: 1px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .CommonTextBox\n" +
            "    {\n" +
            "        margin-top: 20px;\n" +
            "        width: 12% !important;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .ProductDetailsResponsiveQuantitySpan\n" +
            "    {\n" +
            "        margin-top: 25px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .ProductDetailsResponsiveOptionDiv\n" +
            "    {\n" +
            "        margin-top: auto;\n" +
            "        float: left;\n" +
            "        width: 50%;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .QuantityDiscountPanel\n" +
            "    {\n" +
            "        margin-right: 45px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .FreeShippingLabel\n" +
            "    {\n" +
            "        float: none;\n" +
            "        clear: none;\n" +
            "        background: #F9FBFD url(\"Images/Icon/icon-free-shipping.gif\") no-repeat scroll 10px center;\n" +
            "    }\n" +
            "    .RelatedProductsDatalist tr\n" +
            "    {\n" +
            "        width: 50%;\n" +
            "        border-bottom: 0px;\n" +
            "        float: left;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .RelatedProductsTitleRight\n" +
            "    {\n" +
            "        text-align: center;\n" +
            "        border-bottom: 2px dotted #DDDDDD;\n" +
            "    }\n" +
            "    .RelatedProductsItemTable tr\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .CommonTextBox\n" +
            "    {\n" +
            "        margin-top: 0;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .ProductDetailsResponsiveQuantitySpan\n" +
            "    {\n" +
            "        margin-top: 10px;\n" +
            "    }\n" +
            "    .RelatedProductsDetailsColumn, .RelatedProductsImageColumn\n" +
            "    {\n" +
            "        padding-bottom: 0;\n" +
            "        padding-right: 10px;\n" +
            "        padding-top: 30px;\n" +
            "    }\n" +
            "    .ProductQuickInfoSku, .ProductQuickInfoStock, .ProductQuickInfoRating\n" +
            "    {\n" +
            "        float: left;\n" +
            "        width: auto;\n" +
            "        margin-right: 10%;\n" +
            "        margin-top: 15px;\n" +
            "    }\n" +
            "    .ProductQuickInfoRating .StarRating\n" +
            "    {\n" +
            "        margin-top: 5px;\n" +
            "        min-width: 62px;\n" +
            "    }\n" +
            "    .ProductQuickInfoPrice\n" +
            "    {\n" +
            "        float: left;\n" +
            "        width: 50%;\n" +
            "        margin: 10px 0 20px;\n" +
            "    }\n" +
            "    .Product .AddToWishListButtonLinkButton, .Product .AddToCompareListButtonLinkButton, .Product .TellFriendLinkButton\n" +
            "    {\n" +
            "        margin: 5px 0 5px 3%;\n" +
            "        padding: 0 4% 0 22px;\n" +
            "        background-position: 0 center;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .RelatedProductsDetailsPriceDiv\n" +
            "    {\n" +
            "        color: rgb(155, 10 ,222);\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .OptionRadioItemRadioButtonList label\n" +
            "    {\n" +
            "        width: auto;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .ProductQuickInfoName\n" +
            "    {\n" +
            "        margin: 10px 0;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .ProductQuickInfoShortDescription\n" +
            "    {\n" +
            "        margin: 10px 0;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .ProductQuickInfoVendor\n" +
            "    {\n" +
            "        margin-top: 20px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .OptionRadioItemRadioButtonList label\n" +
            "    {\n" +
            "        width: auto;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .OptionRadioItemRadioButtonList tr\n" +
            "    {\n" +
            "        display: table-row;\n" +
            "        float: none;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .ButtonDiv\n" +
            "    {\n" +
            "        line-height: 40px;\n" +
            "        padding: 0;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .AddToCartDiv\n" +
            "    {\n" +
            "        clear: both;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .ProductDetailsResponsiveQuantityDiv\n" +
            "    {\n" +
            "        margin-left: 0;\n" +
            "    }\n" +
            "\n" +
            "    /* ----- ProductDetailsResponsive : Image management ----- */\n" +
            "    .zoom_len, #easy_zoom, #easy_zoom1\n" +
            "    {\n" +
            "        display: none !important;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive div.ProductDetailsResponsiveImage\n" +
            "    {\n" +
            "        width: 80%;\n" +
            "        min-height: 350px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive table.ProductDetailsResponsiveImage\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        height: 350px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .ProductDetailsResponsiveImage img\n" +
            "    {\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .ProductDetailsResponsiveImagePanel\n" +
            "    {\n" +
            "        height: 350px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsiveImageThumbnail\n" +
            "    {\n" +
            "        width: 80%;\n" +
            "        margin: 0 10%;\n" +
            "    }\n" +
            "    .ProductDetailsResponsiveImageThumbnail .ImageThumbnailItemStyle\n" +
            "    {\n" +
            "        margin-right: 1%;\n" +
            "        width: 23%;\n" +
            "        min-height: 90px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsiveImageThumbnail table.CommonCategoryImage\n" +
            "    {\n" +
            "        height: 90px;\n" +
            "    }\n" +
            "\n" +
            "    .ProductListItem div.CommonProductImage\n" +
            "    {\n" +
            "        width: 30%;\n" +
            "    }\n" +
            "\n" +
            "    /*--- Footer Menu ---*/\n" +
            "    .LayoutFooter .MenuItemTitleInner\n" +
            "    {\n" +
            "        border-bottom: solid 1px #262626;\n" +
            "    }\n" +
            "    .LayoutFooter .MenuItemTitleOuter\n" +
            "    {\n" +
            "        border-bottom: solid 1px #404040;\n" +
            "    }\n" +
            "    ul.MenuItem li\n" +
            "    {\n" +
            "        font-size: 14px;\n" +
            "    }\n" +
            "\n" +
            "    /* Breadcrumb Begin */\n" +
            "    .catalog-center-col .CatalogBreadcrumb, .pdetail-row .CatalogBreadcrumb\n" +
            "    {\n" +
            "        position: relative;\n" +
            "        top: 0;\n" +
            "        margin-left: 0;\n" +
            "        display: table;\n" +
            "        min-height: 30px;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .NewsMainDiv .CatalogBreadcrumb\n" +
            "    {\n" +
            "        position: relative;\n" +
            "        margin-left: 0px;\n" +
            "        top: 0;\n" +
            "    }\n" +
            "\n" +
            "    /* Newsletter */\n" +
            "    .Newsletter\n" +
            "    {\n" +
            "        margin-top: 0;\n" +
            "    }\n" +
            "\n" +
            "    /* MyAccount Menu list */\n" +
            "    .account-left-col\n" +
            "    {\n" +
            "        border: 0;\n" +
            "    }\n" +
            "    .MyAccountMenuTableList\n" +
            "    {\n" +
            "        border-top: solid 1px #f1f1f1;\n" +
            "        border-left: solid 1px #f1f1f1;\n" +
            "    }\n" +
            "    .MyAccountMenuTableList tr\n" +
            "    {\n" +
            "        display: inline-block;\n" +
            "        width: 50%;\n" +
            "        border-bottom: solid 1px #f1f1f1;\n" +
            "        border-right: solid 1px #f1f1f1;\n" +
            "        float: left;\n" +
            "    }\n" +
            "    .MyAccountMenuTableList td\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        border: 0;\n" +
            "    }\n" +
            "    .MyAccountInfoPanel .MyAccountInfoSubmitButton\n" +
            "    {\n" +
            "    }\n" +
            "\n" +
            "    /*CompareList Begin*/\n" +
            "    .CompareListGridView .ImageHeader\n" +
            "    {\n" +
            "        width: 18%;\n" +
            "    }\n" +
            "    .CompareListGridView .DeleteHeader\n" +
            "    {\n" +
            "        width: 6%;\n" +
            "    }\n" +
            "    .CompareListGridView .PriceHeader\n" +
            "    {\n" +
            "        width: 18%;\n" +
            "    }\n" +
            "    .CompareListGridView .AddToCartHeader\n" +
            "    {\n" +
            "        width: 20%;\n" +
            "    }\n" +
            "    .CompareListGridView .AddToCartItem a\n" +
            "    {\n" +
            "        display: table;\n" +
            "        margin: auto;\n" +
            "        float: none;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "\n" +
            "    /*WishListGridView Begin*/\n" +
            "    .WishListGridView .ImageHeader\n" +
            "    {\n" +
            "        width: 18%;\n" +
            "    }\n" +
            "    .WishListGridView .DeleteHeader\n" +
            "    {\n" +
            "        width: 6%;\n" +
            "    }\n" +
            "    .WishListGridView .PriceHeader\n" +
            "    {\n" +
            "        width: 18%;\n" +
            "    }\n" +
            "    .WishListGridView .AddToCartHeader\n" +
            "    {\n" +
            "        width: 20%;\n" +
            "    }\n" +
            "    .WishListGridView .QuantityHeader\n" +
            "    {\n" +
            "        width: 15%;\n" +
            "    }\n" +
            "    .WishListGridView .AddToCartItem a\n" +
            "    {\n" +
            "        display: table;\n" +
            "        margin: auto;\n" +
            "        float: none;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "\n" +
            "    /*Advanced Search Begin*/\n" +
            "    .AdvancedSearchLabel\n" +
            "    {\n" +
            "        width: 15%;\n" +
            "    }\n" +
            "    .SearchByKeyword\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .AdvancedSearchDrop\n" +
            "    {\n" +
            "        width: 38%;\n" +
            "    }\n" +
            "    .SearchTextByKeyword\n" +
            "    {\n" +
            "        width: 43%;\n" +
            "        margin-left: 3%;\n" +
            "    }\n" +
            "    .SearchTextByPrice, .SearchTextByPriceTo\n" +
            "    {\n" +
            "        width: 37%;\n" +
            "    }\n" +
            "    .SearchByCategory\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        float: left;\n" +
            "        margin-top: 15px;\n" +
            "    }\n" +
            "    .SearchDropByCategory\n" +
            "    {\n" +
            "        width: 40%;\n" +
            "    }\n" +
            "    .AdvancedSearchTypeCheckList\n" +
            "    {\n" +
            "        width: 82%;\n" +
            "        margin-top: 10px;\n" +
            "        margin-left: 14%;\n" +
            "    }\n" +
            "    .SearchByPrice\n" +
            "    {\n" +
            "        margin: 20px 0px 0px 0px;\n" +
            "        margin-left: 30px;\n" +
            "    }\n" +
            "    .AdvancedSearchPanel\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        margin-left: 0px;\n" +
            "        float: left;\n" +
            "    }\n" +
            "    .SearchByCategory .AdvancedSearchDrop\n" +
            "    {\n" +
            "        width: 38%;\n" +
            "    }\n" +
            "    .AdvancedSearchResult .ProductListTableViewItem .BtnStyle1\n" +
            "    {\n" +
            "        padding: 2px 0px;\n" +
            "        width: 90%;\n" +
            "        text-align: center;\n" +
            "        margin-left: 5%;\n" +
            "    }\n" +
            "    .AdvancedSearchResult .ProductListTableViewItem .AddToWishListButtonLinkButton\n" +
            "    {\n" +
            "        margin-bottom: 15px;\n" +
            "    }\n" +
            "    .AdvancedSearchResult .FreeShippingLabel\n" +
            "    {\n" +
            "        margin-left: 18%;\n" +
            "    }\n" +
            "\n" +
            "    /* contact us */\n" +
            "    .ContactUsCaptcha\n" +
            "    {\n" +
            "        width: 115%;\n" +
            "    }\n" +
            "    .ContactUsCommentBox\n" +
            "    {\n" +
            "        width: 180%;\n" +
            "    }\n" +
            "    .ContactUsButtonDiv\n" +
            "    {\n" +
            "        margin-right: 20%;\n" +
            "    }\n" +
            "    .ContactUsCompanyInfo\n" +
            "    {\n" +
            "        padding-right: 0;\n" +
            "    }\n" +
            "    .ContactMap\n" +
            "    {\n" +
            "        width: 80%;\n" +
            "    }\n" +
            "\n" +
            "    /* checkout */\n" +
            "    .OrderSummaryRightMenu\n" +
            "    {\n" +
            "        width: 48%;\n" +
            "        margin-right: 4%;\n" +
            "        margin-top: 30px;\n" +
            "    }\n" +
            "    .GiftCouponDetailRightMenu\n" +
            "    {\n" +
            "        width: 48%;\n" +
            "        clear: none;\n" +
            "        margin: 30px 0 0;\n" +
            "    }\n" +
            "    .CountryAndStateListDropDown\n" +
            "    {\n" +
            "        clear: both;\n" +
            "    }\n" +
            "\n" +
            "    /*checkout - shipping */\n" +
            "    .ClientCityStatePanel .CheckoutAddressLabel\n" +
            "    {\n" +
            "        width: 28%;\n" +
            "    }\n" +
            "    .ClientCityStatePanel .CountryAndStateListDropDown\n" +
            "    {\n" +
            "        clear: none;\n" +
            "    }\n" +
            "\n" +
            "    /* shipping method */\n" +
            "    .ShippingRadioList tr\n" +
            "    {\n" +
            "        display: table-row;\n" +
            "        width: 100%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .checkout-center-col .Shipping .CommonAsterisk\n" +
            "    {\n" +
            "        float: right;\n" +
            "        margin-right: 15%;\n" +
            "    }\n" +
            "\n" +
            "    /*Shopping Cart*/\n" +
            "    .ShoppingCartGridView .ImageHeader\n" +
            "    {\n" +
            "        width: 20%;\n" +
            "    }\n" +
            "    .ShoppingCartGridView .PriceHeader\n" +
            "    {\n" +
            "        width: 17%;\n" +
            "    }\n" +
            "    .ShoppingCartGridView .QuantityHeader\n" +
            "    {\n" +
            "        width: 13%;\n" +
            "    }\n" +
            "    .ShoppingCartGridView .SubtotalHeader\n" +
            "    {\n" +
            "        width: 17%;\n" +
            "    }\n" +
            "    .ShoppingCartGridView .DeleteHeader\n" +
            "    {\n" +
            "        width: 11%;\n" +
            "    }\n" +
            "    .ShoppingCartNoteDiv\n" +
            "    {\n" +
            "        width: 48%;\n" +
            "        margin: 0 2% 0 0;\n" +
            "    }\n" +
            "    .ShoppingCartCouponDiv\n" +
            "    {\n" +
            "        width: 48%;\n" +
            "        margin: 0 0 0 2%;\n" +
            "    }\n" +
            "    .ShoppingCartGiftCouponButton\n" +
            "    {\n" +
            "        width: 28%;\n" +
            "    }\n" +
            "    .ShoppingCartGiftCouponInputCodeTextBox\n" +
            "    {\n" +
            "        width: 72% !important;\n" +
            "    }\n" +
            "    .ShoppingCartGiftCouponButton a\n" +
            "    {\n" +
            "        padding: 0px;\n" +
            "    }\n" +
            "    .ShoppingCartOrderTotal\n" +
            "    {\n" +
            "        padding: 25px 13% 30px 0;\n" +
            "        float: left;\n" +
            "        width: 100%;\n" +
            "        margin-top: 20px;\n" +
            "    }\n" +
            "    .ShoppingCartGiftCouponTable\n" +
            "    {\n" +
            "        margin-bottom: 0px;\n" +
            "    }\n" +
            "    .ShoppingCartTableColumn1\n" +
            "    {\n" +
            "        padding-right: 5%;\n" +
            "        width: 60%;\n" +
            "    }\n" +
            "    .ShoppingCartTableColumn2\n" +
            "    {\n" +
            "        width: 40%;\n" +
            "    }\n" +
            "    .ShoppingCartTotalAmountLabel\n" +
            "    {\n" +
            "        font-size: 160%;\n" +
            "    }\n" +
            "    .ShoppingCartTotalAmount\n" +
            "    {\n" +
            "        font-size: 170%;\n" +
            "    }\n" +
            "    .CountryAndStateListDropDown\n" +
            "    {\n" +
            "        float: left;\n" +
            "        width: 54%;\n" +
            "        clear: right;\n" +
            "    }\n" +
            "    .GiftCouponDetailValidatorText\n" +
            "    {\n" +
            "        margin-left: 11%;\n" +
            "        width: 70%;\n" +
            "    }\n" +
            "    .ShoppingCartGiftCoupon .GiftCouponDetailValidatorText\n" +
            "    {\n" +
            "        margin-left: 11%;\n" +
            "        width: 70%;\n" +
            "    }\n" +
            "    .ShoppingCartButton a\n" +
            "    {\n" +
            "        width: 34%;\n" +
            "        margin-right: 3%;\n" +
            "    }\n" +
            "    .ShoppingCartButton a.ShoppingCartUpdateQuantity\n" +
            "    {\n" +
            "        margin-right: 0;\n" +
            "    }\n" +
            "    .ShoppingCartButton a.ShoppingCartCheckoutLink, .ShoppingCartButton a.ShoppingCartGiftRegistryLink\n" +
            "    {\n" +
            "        margin-top: 15px;\n" +
            "        margin-right: 0;\n" +
            "        width: 100% !important;\n" +
            "        clear: right;\n" +
            "    }\n" +
            "    .ShoppingCartGiftCouponInputCenter\n" +
            "    {\n" +
            "        margin: 40px 8%;\n" +
            "    }\n" +
            "    .ShoppingCartButton .ShoppingCartClearCart, .ShoppingCartButton .ShoppingCartUpdateQuantity\n" +
            "    {\n" +
            "        width: 30%;\n" +
            "    }\n" +
            "    .ShoppingCartGridView .NameItem\n" +
            "    {\n" +
            "        text-align: left;\n" +
            "        padding-left: 3px;\n" +
            "    }\n" +
            "\n" +
            "    /*ForgotPassword Begin*/\n" +
            "    .ForgotPasswordPanel\n" +
            "    {\n" +
            "        width: 70%;\n" +
            "    }\n" +
            "\n" +
            "    /*News List */\n" +
            "    .NewsListImage\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .NewsPagingBox\n" +
            "    {\n" +
            "        display: table;\n" +
            "        margin: auto;\n" +
            "        width: auto;\n" +
            "        float: none;\n" +
            "    }\n" +
            "    .NewsLinkToTopDiv\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "\n" +
            "\n" +
            "    /*CustomerReview*/\n" +
            "    .CustomerReviewContent\n" +
            "    {\n" +
            "        float: none;\n" +
            "        width: 100%;\n" +
            "        padding-top: 10px;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .CustomerReviewProductDetail\n" +
            "    {\n" +
            "        float: none;\n" +
            "        width: 100%;\n" +
            "        padding: 10px 0;\n" +
            "    }\n" +
            "    .CustomerReviewProductDetail .ProductInfo\n" +
            "    {\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "\n" +
            "    /*News Detail*/\n" +
            "    .NewsDetails .CommonPage\n" +
            "    {\n" +
            "        margin-top: 10px;\n" +
            "    }\n" +
            "\n" +
            "    /*AffiliateDetails Begin*/\n" +
            "    .AffiliateDetailsAgreementPanel\n" +
            "    {\n" +
            "        margin-left: 11.5%;\n" +
            "        width: 80%;\n" +
            "    }\n" +
            "\n" +
            "    /* Promotion List */\n" +
            "    .PromotionListDefault tr\n" +
            "    {\n" +
            "        display: block;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .PromotionGroupListItemImageColumn\n" +
            "    {\n" +
            "        width: 40%;\n" +
            "    }\n" +
            "    .PromotionGroupListItemImageDiv\n" +
            "    {\n" +
            "        width: 180px;\n" +
            "    }\n" +
            "    .PromotionGroupListItemImageDiv img\n" +
            "    {\n" +
            "        max-height: 180px;\n" +
            "        height: auto !important;\n" +
            "        height: 180px;\n" +
            "        max-width: 180px;\n" +
            "        width: auto !important;\n" +
            "        width: 180px;\n" +
            "    }\n" +
            "\n" +
            "    /* Promotion Product Item List */\n" +
            "    .PromotionItem .ProductDetailsDefaultLikeButtonDiv\n" +
            "    {\n" +
            "        width: 50%;\n" +
            "    }\n" +
            "    .PromotionProductGroup\n" +
            "    {\n" +
            "        padding: 15px 5px;\n" +
            "    }\n" +
            "    .PromotionProductItem .ProductImage\n" +
            "    {\n" +
            "        left: 5%;\n" +
            "    }\n" +
            "    .PromotionProductGroupDataList .ProductGroupCombineItem\n" +
            "    {\n" +
            "        width: 25px;\n" +
            "    }\n" +
            "    .PromotionProductGroupDataList .ProductGroupCombineItem div\n" +
            "    {\n" +
            "        width: 25px;\n" +
            "    }\n" +
            "    .PromotionItem .PromotionDetailsDefaultImageTellFriendImage\n" +
            "    {\n" +
            "        width: 75%;\n" +
            "    }\n" +
            "    .PromotionProductGroupDataList .PromotionProductItem\n" +
            "    {\n" +
            "        width: 90%;\n" +
            "        margin-left: 5%;\n" +
            "        margin-right: 5%;\n" +
            "    }\n" +
            "    .PromotionProductGroupDataList .ProductGroupProductItemStyle\n" +
            "    {\n" +
            "        width: 112px;\n" +
            "    }\n" +
            "\n" +
            "    /* Register - CustomerRegister Address Begin*/\n" +
            "    .CustomerRegister\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .Register .CustomerRegisterLeft, .Register .CustomerRegisterRight\n" +
            "    {\n" +
            "        margin-left: 8%;\n" +
            "        margin-right: 0;\n" +
            "        width: 90%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .Register .CustomerRegisterLeftLabel, .Register .CustomerRegisterRightLabel\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .Register .CustomerRegisterLeftData, .Register .CustomerRegisterRightData\n" +
            "    {\n" +
            "        width: 70%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .Register .CustomerRegisterPanel .ClientCityStatePanel\n" +
            "    {\n" +
            "        margin-left: 8%;\n" +
            "        width: 90%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .Register .CustomerRegisterPanel .ClientCityStatePanel .CustomerRegisterLabel\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .Register .CustomerRegisterPanel .ClientCityStatePanel .CountryAndStateListDropDown\n" +
            "    {\n" +
            "        width: 63%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .Register .CustomerRegisterPanel .CustomerRegisterCheckBox\n" +
            "    {\n" +
            "        margin-left: 30%;\n" +
            "        width: 65%;\n" +
            "    }\n" +
            "    .Register .CustomerRegisterPanel .ClientCityStatePanel .CountryAndStateListCountryTextBox\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        float: left;\n" +
            "        margin-left: 25%;\n" +
            "        width: 63%;\n" +
            "    }\n" +
            "    .Register .CustomerRegisterPanel .ClientCityStatePanel .CountryAndStateListStateTextBox\n" +
            "    {\n" +
            "        clear: none;\n" +
            "        float: right;\n" +
            "        margin-left: 0;\n" +
            "        margin-right: 12%;\n" +
            "        width: 63%;\n" +
            "    }\n" +
            "    .Register .CustomerRegisterShippingInfoPanel .CustomerRegisterCityStatePanel\n" +
            "    {\n" +
            "        margin-left: 8%;\n" +
            "        width: 90%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .Register .CustomerRegisterShippingInfoPanel .CustomerRegisterCityStatePanel .CustomerRegisterLabel\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .Register .CustomerRegisterShippingInfoPanel .CustomerRegisterCityStatePanel .CountryAndStateListDropDown\n" +
            "    {\n" +
            "        width: 63%;\n" +
            "        margin: 0;\n" +
            "        clear: none;\n" +
            "    }\n" +
            "    .Register .CustomerRegisterShippingInfoPanel .CustomerRegisterCheckBox\n" +
            "    {\n" +
            "        margin-left: 30%;\n" +
            "        width: 65%;\n" +
            "    }\n" +
            "    .Register .CustomerRegisterShippingInfoPanel .CustomerRegisterCityStatePanel .CountryAndStateListCountryTextBox\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        float: left;\n" +
            "        margin-left: 25%;\n" +
            "        width: 63%;\n" +
            "    }\n" +
            "    .Register .CustomerRegisterShippingInfoPanel .CustomerRegisterCityStatePanel .CountryAndStateListStateTextBox\n" +
            "    {\n" +
            "        clear: none;\n" +
            "        float: right;\n" +
            "        margin-left: 0;\n" +
            "        margin-right: 12%;\n" +
            "        width: 63%;\n" +
            "    }\n" +
            "    .Register .CustomerRegister .CustomerRegisterLinkButtonDiv\n" +
            "    {\n" +
            "        margin-right: 12%;\n" +
            "    }\n" +
            "\n" +
            "    /* Shipping Address */\n" +
            "    .AccountMainDiv .AccountDetailsCheckBoxDiv\n" +
            "    {\n" +
            "        margin-left: 24%;\n" +
            "        width: 60%;\n" +
            "    }\n" +
            "\n" +
            "    /* GiftCertificate */\n" +
            "    .GiftCertificateTextBox\n" +
            "    {\n" +
            "        width: 40% !important;\n" +
            "    }\n" +
            "\n" +
            "    /*VendorList*/\n" +
            "    .VendorListItemStyle .LogoImage\n" +
            "    {\n" +
            "        width: 35%;\n" +
            "    }\n" +
            "    .VendorListItemStyle .StoreName\n" +
            "    {\n" +
            "        width: 60%;\n" +
            "    }\n" +
            "    .VendorListItemStyle .CompanyDescription\n" +
            "    {\n" +
            "        width: 60%;\n" +
            "    }\n" +
            "\n" +
            "    /* VendorDetail */\n" +
            "    .VendorInfo .LogoImage\n" +
            "    {\n" +
            "        width: 35%;\n" +
            "    }\n" +
            "    .VendorInfo .GeneralInfo\n" +
            "    {\n" +
            "        width: 60%;\n" +
            "    }\n" +
            "    .VendorInfo .InfoContent\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        clear: left;\n" +
            "        float: left;\n" +
            "        margin-bottom: 10px;\n" +
            "    }\n" +
            "    .CustomerRegister .ajax__htmleditor_editor_container\n" +
            "    {\n" +
            "        width: 260px !important;\n" +
            "    }\n" +
            "\n" +
            "}\n" +
            "@media only screen and (max-width: 479px) /*Screen width lower than 480 px -------------- For step 1 ------------ */\n" +
            "{\n" +
            "    .HeaderLoginWishlist .WishlistLink {\n" +
            "        color: black !important; /*armando*/\n" +
            "    }\n" +
            "    .ProductDetailsResponsiveAddToCart .BtnStyle1\n" +
            "    {\n" +
            "        padding: 7px 15px 7px 15px;\n" +
            "    }\n" +
            "    .GiftRegistryDetailDiv input[type=\"text\"]\n" +
            "    {\n" +
            "        width: 90%;\n" +
            "    }\n" +
            "    /* Header */\n" +
            "    .MyAccountSection\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        float: left;\n" +
            "        width: 35%;\n" +
            "        margin: 5px 0;\n" +
            "        height: 0;\n" +
            "    }\n" +
            "    .ShoppingCartSection\n" +
            "    {\n" +
            "        display: table-row-group;\n" +
            "    }\n" +
            "    .LanguageSection\n" +
            "    {\n" +
            "        float: left;\n" +
            "        height: 24px;\n" +
            "    }\n" +
            "    /*-- header logo --*/\n" +
            "    .HeaderLogo\n" +
            "    {\n" +
            "        display: table;\n" +
            "        margin: 0 auto;\n" +
            "        float: none;\n" +
            "    }\n" +
            "    .HeaderLogo a\n" +
            "    {\n" +
            "        display: block;\n" +
            "        height: auto;\n" +
            "        margin: 10px 0;\n" +
            "    }\n" +
            "    /*-- header login --*/\n" +
            "    .HeaderLogin\n" +
            "    {\n" +
            "        float: none;\n" +
            "        display: table;\n" +
            "        margin: 12px auto;\n" +
            "    }\n" +
            "    /* Currency, Language */\n" +
            "    .SwitchLanguage, .CurrencyControl\n" +
            "    {\n" +
            "        display: block;\n" +
            "        float: right;\n" +
            "        margin: 0 15px 0 0;\n" +
            "    }\n" +
            "    /*-- mini cart --*/\n" +
            "    .HeaderShoppingCart\n" +
            "    {\n" +
            "        clear: none;\n" +
            "        height: auto;\n" +
            "    }\n" +
            "    .HeaderShoppingCart .HeaderShoppingCartDiv\n" +
            "    {\n" +
            "        float: left;\n" +
            "        padding: 0 7px;\n" +
            "    }\n" +
            "    .HeaderShoppingCart .HeaderShoppingCartCheckout\n" +
            "    {\n" +
            "        clear: none;\n" +
            "        margin-top: 7px;\n" +
            "        padding: 0 25px 0 7px;\n" +
            "        height: 24px;\n" +
            "        line-height: 22px;\n" +
            "        position: absolute;\n" +
            "        top: 0;\n" +
            "        right: 0;\n" +
            "    }\n" +
            "    .HeaderShoppingCart .DiscountDiv\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    /*--- quick search ---*/\n" +
            "    .Search\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        margin: 10px 0;\n" +
            "    }\n" +
            "\n" +
            "    /*--- Header Menu ---*/\n" +
            "    .headerMenuNormal\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .headerMenuResponsive\n" +
            "    {\n" +
            "        display: block;\n" +
            "    }\n" +
            "    /* --- Myaccount Link ---*/\n" +
            "    .HeaderLoginWishlist\n" +
            "    {\n" +
            "        margin: 0;\n" +
            "        display: table-footer-group;\n" +
            "        clear: none;\n" +
            "        float: none;\n" +
            "    }\n" +
            "    .HeaderLoginAccount\n" +
            "    {\n" +
            "        margin: 0;\n" +
            "        display: table-header-group;\n" +
            "        clear: none;\n" +
            "        float: none;\n" +
            "    }\n" +
            "    .HeaderLoginWishlist a\n" +
            "    {\n" +
            "        margin: 5px 0 0;\n" +
            "    }\n" +
            "    .HeaderLoginAccount a\n" +
            "    {\n" +
            "        margin: 15px 0 0;\n" +
            "    }\n" +
            "    /* Default product item style */\n" +
            "    .RandomProductDataList, .ProductBestSellingDataList, .PromotionGroupDataList, .NewsEventList\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .PromotionGroupDataList .CommonProductItemStyle\n" +
            "    {\n" +
            "        border-right: 0;\n" +
            "    }\n" +
            "    .NewArrival .jcarousel-skin-tango .jcarousel-clip-horizontal\n" +
            "    {\n" +
            "        width: 80%;\n" +
            "        margin-left: auto;\n" +
            "        margin-right: auto;\n" +
            "    }\n" +
            "\n" +
            "\n" +
            "    /* Product list & Category list */\n" +
            "    .ProductListDefaultSortString\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .CommonProductItemStyle, .PromotionGroupDataList .CommonProductItemStyle, .ProductListDefaultDataList .CommonProductItemStyle, .catalog-productlist-col .CommonProductItemStyle, .NewsEventItemStyle\n" +
            "    {\n" +
            "        width: 80%;\n" +
            "        margin: 10px 10%;\n" +
            "        display: inline-block;\n" +
            "    }\n" +
            "    .CommonCategoryItemStyle\n" +
            "    {\n" +
            "        width: 28.96%;\n" +
            "        margin: 10px 3.5% 10px 0;\n" +
            "    }\n" +
            "    .CommonCategoryImage img\n" +
            "    {\n" +
            "        max-width: 80px;\n" +
            "        max-height: 80px;\n" +
            "    }\n" +
            "    .ProductItemCountItemCount\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ProductLinkToTopDiv\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n";
    static String res2 =
            "    .ProductListGridListSortUpDown\n" +
            "    {\n" +
            "        margin-left: 10px;\n" +
            "    }\n" +
            "    .ProductListGridListItemPerPage\n" +
            "    {\n" +
            "        margin-right: 5px;\n" +
            "    }\n" +
            "    .ProductItemPaging\n" +
            "    {\n" +
            "        display: table;\n" +
            "        margin: 0 auto;\n" +
            "        float: none;\n" +
            "    }\n" +
            "    .CategoryListDefaultItemPerPageDiv, .DepartmentListDefaultItemPerPageDiv, .ManufacturerListDefaultItemPerPageDiv\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ProductColumn1DataList\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .ProductColumn2DataList\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .ProductColumn1DataList .CommonProductItemStyle, .ProductColumn2DataList .CommonProductItemStyle, .ProductColumn3DataList .CommonProductItemStyle\n" +
            "    {\n" +
            "        width: 80%;\n" +
            "        margin: 25px 10%;\n" +
            "        display: inline-block;\n" +
            "    }\n" +
            "    .TableViewTellFriendPanel, .TableViewAddtoWishListPanel, .TableViewAddtoCompareListPanel\n" +
            "    {\n" +
            "        width: 125%;\n" +
            "        margin-left: 3px;\n" +
            "    }\n" +
            "    /*--- New Arivval Category ---*/\n" +
            "    .NewArrivalCategoryList\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .NewArrivalCategoryList .CommonProductItemStyle\n" +
            "    {\n" +
            "        width: 80% !important;\n" +
            "        margin: 10px 10%;\n" +
            "        display: inline-block;\n" +
            "    }\n" +
            "\n" +
            "    /*--- ProductList : Row style ---*/\n" +
            "    .ProductListItem\n" +
            "    {\n" +
            "        width: 90%;\n" +
            "        padding: 0px 0 10px;\n" +
            "        margin: 8px auto;\n" +
            "        text-align: center;\n" +
            "    }\n" +
            "    .ProductListItem .PriceDiscountLabel\n" +
            "    {\n" +
            "        left: 15%;\n" +
            "        top: 30px;\n" +
            "    }\n" +
            "    .ProductListItem div.CommonProductImage\n" +
            "    {\n" +
            "        width: 80%;\n" +
            "        float: none;\n" +
            "        text-align: center;\n" +
            "        margin: 0 auto 20px;\n" +
            "    }\n" +
            "    .ProductListItem .CommonProductImage\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .ProductListItem .ProductListItemDetailsColumn\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        padding: 10px 0;\n" +
            "        float: none;\n" +
            "        text-align: center;\n" +
            "    }\n" +
            "    .ProductListItem .CommonProductImage img\n" +
            "    {\n" +
            "        max-width: 190px;\n" +
            "    }\n" +
            "    .ProductListItem .CommonProductDescription\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ProductListItem .CommonProductRating\n" +
            "    {\n" +
            "        float: none;\n" +
            "    }\n" +
            "    .ProductListItem .CommonProductName\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .ProductListItem .ProductListItemDetailsPriceDiv\n" +
            "    {\n" +
            "        display: table;\n" +
            "        clear: left;\n" +
            "        float: none;\n" +
            "        margin: 10px auto;\n" +
            "    }\n" +
            "    .ProductListItem .ProductListItemRmaPanel\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ProductListItem .ProductListItemButtonDiv\n" +
            "    {\n" +
            "        background: url(Images/Background/dot-line.jpg) repeat-x left top;\n" +
            "        padding: 15px 0;\n" +
            "    }\n" +
            "    .ProductListItem .ProductListItemButtonDiv .BtnStyle1\n" +
            "    {\n" +
            "        display: table;\n" +
            "        float: none;\n" +
            "        margin: 0 auto 10px;\n" +
            "    }\n" +
            "    .ProductListItemTellFriendPanel, .ProductListItemAddtoWishListPanel, .ProductListItemAddtoCompareListPanel\n" +
            "    {\n" +
            "        width: 30%;\n" +
            "    }\n" +
            "    .AdvancedSearchResult .ProductListItem .ProductListItemDetailsColumn\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        padding: 30px 5%;\n" +
            "    }\n" +
            "\n" +
            "    /*--- ProductList : Tabular style ---*/\n" +
            "    .ProductListTableViewTopItem\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    table.ProductListTableViewItem\n" +
            "    {\n" +
            "        width: 80%;\n" +
            "        padding: 20px 0;\n" +
            "        margin: 5px auto;\n" +
            "        text-align: center;\n" +
            "    }\n" +
            "    .ProductListTableViewItem td\n" +
            "    {\n" +
            "        border: 0;\n" +
            "        display: block;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .PriceDiscountLabel\n" +
            "    {\n" +
            "        display: block;\n" +
            "        left: 10px;\n" +
            "        top: 10px;\n" +
            "        position: absolute;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .Image, .AdvancedSearchResult .ProductListTableViewItem .Image\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        float: none;\n" +
            "        text-align: center;\n" +
            "        margin: 0 auto;\n" +
            "        position: relative;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .ImagePanel\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .ImagePanel img\n" +
            "    {\n" +
            "        height: auto !important;\n" +
            "        max-height: 190px;\n" +
            "        max-width: 190px;\n" +
            "        width: auto !important;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .ImagePanel .ProductLink\n" +
            "    {\n" +
            "        display: block;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .Sku\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .Button, .AdvancedSearchResult .ProductListTableViewItem .Button\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        padding: 0;\n" +
            "        border: 0;\n" +
            "        margin: 0 auto;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .Price\n" +
            "    {\n" +
            "        width: auto;\n" +
            "        display: table;\n" +
            "        margin: 0 auto;\n" +
            "        padding: 0;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .RetailPricePanel, .AdvancedSearchResult .ProductListTableViewItem .RetailPricePanel\n" +
            "    {\n" +
            "        float: left;\n" +
            "        margin-right: 2px;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .OurPricePanel, .AdvancedSearchResult .ProductListTableViewItem .OurPricePanel\n" +
            "    {\n" +
            "        clear: none;\n" +
            "        float: left;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .Name\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        text-align: center;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .CommonProductName\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        padding-bottom: 10px;\n" +
            "        background: url(Images/Background/dot-line.jpg) repeat-x left bottom;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .CommonProductRating\n" +
            "    {\n" +
            "        margin-bottom: 0;\n" +
            "    }\n" +
            "    .ProductListTableViewItem .BtnStyle1, .AdvancedSearchResult .ProductListTableViewItem .BtnStyle1\n" +
            "    {\n" +
            "        padding: 2px 10px;\n" +
            "        width: 44%;\n" +
            "        margin: 5px 28%;\n" +
            "    }\n" +
            "    .TableViewTellFriendPanel, .TableViewAddtoWishListPanel, .TableViewAddtoCompareListPanel\n" +
            "    {\n" +
            "        float: none;\n" +
            "        width: auto;\n" +
            "        margin: 5px 10px;\n" +
            "    }\n" +
            "    .AdvancedSearchResult .TableViewTellFriendPanel, .AdvancedSearchResult .TableViewAddtoWishListPanel, .AdvancedSearchResult .TableViewAddtoCompareListPanel\n" +
            "    {\n" +
            "        float: none;\n" +
            "        width: auto;\n" +
            "        margin: 5px 10px;\n" +
            "    }\n" +
            "    .TableViewTellFriendPanel, .AdvancedSearchResult .TableViewTellFriendPanel\n" +
            "    {\n" +
            "        clear: left;\n" +
            "    }\n" +
            "\n" +
            "\n" +
            "    /* ----- ProductDetailsResponsive : Image management ----- */\n" +
            "    .Product .CommonPageTop\n" +
            "    {\n" +
            "        display: table;\n" +
            "        margin: 0 auto;\n" +
            "        width: auto;\n" +
            "    }\n" +
            "    .Product .CommonPageLeft\n" +
            "    {\n" +
            "        display: block;\n" +
            "    }\n" +
            "    .pdetail-sec-two columns\n" +
            "    {\n" +
            "        width: 90px;\n" +
            "    }\n" +
            "\n" +
            "    .ProductDetailsResponsive .ProductDetailsResponsiveOptionDiv\n" +
            "    {\n" +
            "        margin-top: 20px;\n" +
            "        margin-bottom: 20px;\n" +
            "        float: none;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .ProductQuickInfoPrice\n" +
            "    {\n" +
            "        clear: both;\n" +
            "        display: table;\n" +
            "        float: none;\n" +
            "        margin: 10px 0 20px;\n" +
            "        width: 90%;\n" +
            "    }\n" +
            "    .ProductQuickInfoShortDescription\n" +
            "    {\n" +
            "        margin-top: 20px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .FreeShippingLabel\n" +
            "    {\n" +
            "        background: #F9FBFD url(\"Images/Icon/icon-free-shipping.gif\") no-repeat scroll 10px center;\n" +
            "        display: table;\n" +
            "        float: none;\n" +
            "        margin: 20px auto 0;\n" +
            "        padding: 0px 30px 0px 53px;\n" +
            "    }\n" +
            "\n" +
            "    .RelatedProductsDatalistItemStyle\n" +
            "    {\n" +
            "        border-bottom: 1px dotted #DDDDDD;\n" +
            "    }\n" +
            "    .RelatedProductsDatalist tr, .RelatedProductsItemTable\n" +
            "    {\n" +
            "        display: table;\n" +
            "        display: table;\n" +
            "        margin: 0 auto;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "\n" +
            "    .RelatedProductsDatalist tr\n" +
            "    {\n" +
            "        float: none;\n" +
            "    }\n" +
            "    .RelatedProductsDetailsColumn, .RelatedProductsImageColumn\n" +
            "    {\n" +
            "        padding-top: 20px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .QuantityDiscountPanel\n" +
            "    {\n" +
            "        margin: auto;\n" +
            "        display: table;\n" +
            "        margin-top: 20px;\n" +
            "        float: none;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .OptionRadioItemRadioButtonList tr\n" +
            "    {\n" +
            "        display: table-row;\n" +
            "        float: none;\n" +
            "    }\n" +
            "    .Product .AddToWishListButtonLinkButton, .Product .AddToCompareListButtonLinkButton, .Product .TellFriendLinkButton\n" +
            "    {\n" +
            "        clear: right;\n" +
            "        float: left;\n" +
            "        margin: 0;\n" +
            "        font-size: 11px;\n" +
            "        color: #1e1e1e;\n" +
            "        border: 0;\n" +
            "        border-right: solid 1px #eee;\n" +
            "        letter-spacing: 0px;\n" +
            "        display: block;\n" +
            "        width: 50%;\n" +
            "        height: 37px;\n" +
            "        line-height: 30px;\n" +
            "        background-position: 8% center;\n" +
            "        padding: 2px 0 2px 12%;\n" +
            "        text-decoration: none;\n" +
            "    }\n" +
            "    .Product .AddToWishListButtonLinkButton\n" +
            "    {\n" +
            "        border-bottom: solid 1px #ddd;\n" +
            "    }\n" +
            "    .Product .AddToCompareListButtonLinkButton\n" +
            "    {\n" +
            "        border-bottom: solid 1px #ddd;\n" +
            "        border-right: 0px;\n" +
            "    }\n" +
            "    .Product .TellFriendLinkButton\n" +
            "    {\n" +
            "        border-right: 0px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .ButtonDiv\n" +
            "    {\n" +
            "        padding: 0;\n" +
            "        margin-top: 20px !important;\n" +
            "    }\n" +
            "    .ajax__tab_header .ajax__tab_active .ajax__tab_outer\n" +
            "    {\n" +
            "        width: 126px;\n" +
            "    }\n" +
            "    .ajax__tab_header .ajax__tab_outer\n" +
            "    {\n" +
            "        width: 126px;\n" +
            "    }\n" +
            "    .ajax__tab_header .ajax__tab_outer .ajax__tab_inner .ajax__tab_tab div\n" +
            "    {\n" +
            "        width: 129px;\n" +
            "    }\n" +
            "    .ajax__tab_body\n" +
            "    {\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .StarRatingSummaryTable tr\n" +
            "    {\n" +
            "        display: table-row;\n" +
            "    }\n" +
            "    .StarRatingSummaryTableInner td\n" +
            "    {\n" +
            "        display: table-row;\n" +
            "    }\n" +
            "    .RatingControlTable td\n" +
            "    {\n" +
            "        display: table-cell;\n" +
            "    }\n" +
            "    .StarRatingSummaryTableInnerOurStarColumn\n" +
            "    {\n" +
            "        display: table-cell !important;\n" +
            "        width: auto;\n" +
            "        height: 40px;\n" +
            "    }\n" +
            "    .StarRatingSummaryTableInnerOurLabelColumn\n" +
            "    {\n" +
            "        display: table-cell !important;\n" +
            "        height: 40px;\n" +
            "        padding-top: 10px;\n" +
            "    }\n" +
            "    .StarRatingSummaryTableInnerCustomerStarColumn\n" +
            "    {\n" +
            "        display: table-cell !important;\n" +
            "        vertical-align: top;\n" +
            "        padding-top: 5px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .pdetail-sec-four .StarRatingSummaryButtonColumn\n" +
            "    {\n" +
            "        float: left;\n" +
            "    }\n" +
            "    .RatingCustomerBaseOnAmountLabel\n" +
            "    {\n" +
            "        display: table-row !important;\n" +
            "    }\n" +
            "    .CustomerReviewsItemDateColumn\n" +
            "    {\n" +
            "        max-width: 230px !important;\n" +
            "    }\n" +
            "    .StarRatingSummaryButtonColumn\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .WriteReviewDiv .CommonHyperLink\n" +
            "    {\n" +
            "        display: block;\n" +
            "        color: #333333;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .RelatedProductsTitleRight\n" +
            "    {\n" +
            "        margin-top: 30px;\n" +
            "        padding-bottom: 5px;\n" +
            "        text-align: center;\n" +
            "        border-bottom: 2px dotted #DDDDDD;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .ProductDetailsButtom\n" +
            "    {\n" +
            "        margin-top: 30px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .OptionInputListItemDataListItemStyle\n" +
            "    {\n" +
            "        display: table-row;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .OptionRadioItemRadioButtonList label\n" +
            "    {\n" +
            "        width: auto;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .QuantityDiscountRight\n" +
            "    {\n" +
            "        margin: 10px -35%;\n" +
            "        width: auto;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .ProductDetailsDefaulSpecificationDetailsDiv\n" +
            "    {\n" +
            "        margin-bottom: 20px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .RelatedProductsDetailsPriceDiv\n" +
            "    {\n" +
            "        color: rgb(155, 10 ,222);\n" +
            "    }\n" +
            "    .ProductQuickInfoSku, .ProductQuickInfoStock\n" +
            "    {\n" +
            "        width: 50%;\n" +
            "        margin-right: 0;\n" +
            "        margin-bottom: 0;\n" +
            "    }\n" +
            "    .ProductQuickInfoRating\n" +
            "    {\n" +
            "        display: table;\n" +
            "        margin: 10px 0;\n" +
            "        float: left;\n" +
            "        width: auto;\n" +
            "    }\n" +
            "    .CustomerReviewMessageTextBox\n" +
            "    {\n" +
            "        float: right;\n" +
            "        margin-right: 2%;\n" +
            "        width: 50% !important;\n" +
            "    }\n" +
            "    .OptionInputListItemDataListItemDiv\n" +
            "    {\n" +
            "        width: 130px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .ProductDetailsResponsiveQuantityDiv\n" +
            "    {\n" +
            "        margin-left: 0;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .QuantityDiscountGridView\n" +
            "    {\n" +
            "        position: inherit;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .ProductQuickInfoName\n" +
            "    {\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .RatingCustomerMessageDiv .RatingCustomerBaseOnAmountLabel\n" +
            "    {\n" +
            "        float: left;\n" +
            "        margin: 0 5px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .RatingCustomerBaseOnAmountLabel\n" +
            "    {\n" +
            "        float: right;\n" +
            "        margin: 0 5px;\n" +
            "    }\n" +
            "    .StarRatingSummaryTableInnerOurLabelColumn\n" +
            "    {\n" +
            "        float: left;\n" +
            "        padding: 10px 0px 0px 3px;\n" +
            "    }\n" +
            "    .ProductQuickInfoRmaPanel\n" +
            "    {\n" +
            "        margin: 15px 0;\n" +
            "        width: 90%;\n" +
            "        font-size: 13px;\n" +
            "    }\n" +
            "\n" +
            "    /* ----- ProductDetailsResponsive : Image management ----- */\n" +
            "    .ProductDetailsResponsive div.ProductDetailsResponsiveImage\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        min-height: 280px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive table.ProductDetailsResponsiveImage\n" +
            "    {\n" +
            "        height: 280px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .ProductDetailsResponsiveImage img\n" +
            "    {\n" +
            "    }\n" +
            "    .ProductDetailsResponsive .ProductDetailsResponsiveImagePanel\n" +
            "    {\n" +
            "        height: 280px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsiveImageThumbnail\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .ProductDetailsResponsiveImageThumbnail .ImageThumbnailItemStyle\n" +
            "    {\n" +
            "        margin: 0 1%;\n" +
            "        width: 21%;\n" +
            "        min-height: 65px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsiveImageThumbnail table.CommonCategoryImage\n" +
            "    {\n" +
            "        height: 65px;\n" +
            "    }\n" +
            "    .ProductDetailsResponsiveImageThumbnail .CommonCategoryImage img\n" +
            "    {\n" +
            "        max-width: 65px;\n" +
            "        max-height: 65px;\n" +
            "    }\n" +
            "\n" +
            "    /*--- Footer Menu ---*/\n" +
            "    .LayoutFooter .MenuItemTitleOuter, .LayoutFooter a.MenuItemTitleOuter, .LayoutFooter .MenuItemTitle, .four.MenuFooter.CustomerMenu, .four.MenuFooter\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .LayoutFooter, .Newsletter .SidebarTop\n" +
            "    {\n" +
            "        text-align: center;\n" +
            "    }\n" +
            "    .Newsletter .SidebarTopTitle\n" +
            "    {\n" +
            "        float: none;\n" +
            "    }\n" +
            "    .Newsletter .SidebarRight\n" +
            "    {\n" +
            "        display: table;\n" +
            "        margin: auto;\n" +
            "    }\n" +
            "    .LayoutFooter ul.MenuItem\n" +
            "    {\n" +
            "        float: left;\n" +
            "        margin-bottom: 10px;\n" +
            "    }\n" +
            "    .LayoutFooter ul.MenuItem li\n" +
            "    {\n" +
            "        float: left;\n" +
            "        margin-right: 25px;\n" +
            "    }\n" +
            "    .LayoutFooter ul.MenuItem li:last-child\n" +
            "    {\n" +
            "        margin-right: 0;\n" +
            "    }\n" +
            "    .SocialLink\n" +
            "    {\n" +
            "        float: none;\n" +
            "        display: table;\n" +
            "        margin: 10px auto;\n" +
            "    }\n" +
            "    .LayoutFooterLicense\n" +
            "    {\n" +
            "        padding: 5px 0;\n" +
            "    }\n" +
            "    .LayoutFooterLicense a\n" +
            "    {\n" +
            "        clear: left;\n" +
            "    }\n" +
            "\n" +
            "    .NewsletterForm\n" +
            "    {\n" +
            "        text-align: left;\n" +
            "    }\n" +
            "    .SocialLink\n" +
            "    {\n" +
            "        padding-top: 15px;\n" +
            "    }\n" +
            "\n" +
            "    /* MyAccount Menu list */\n" +
            "    .MyAccountMenuList\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        float: none;\n" +
            "        margin: auto;\n" +
            "    }\n" +
            "    .MyAccountMenuTableList\n" +
            "    {\n" +
            "        border-top: solid 1px #f1f1f1;\n" +
            "        border-left: 0;\n" +
            "    }\n" +
            "    .MyAccountMenuTableList tr\n" +
            "    {\n" +
            "        display: table-row;\n" +
            "        width: 100%;\n" +
            "        float: none;\n" +
            "        border: 0;\n" +
            "    }\n" +
            "    .MyAccountMenuTableList td\n" +
            "    {\n" +
            "        padding: 10px 15%;\n" +
            "        border-bottom: solid 1px #f1f1f1;\n" +
            "        border-right: 0;\n" +
            "    }\n" +
            "    .MyAccountMenuList .SidebarTop\n" +
            "    {\n" +
            "        margin: 0 15%;\n" +
            "    }\n" +
            "    .MyAccountInfoPanel .MyAccountInfoSubmitButton\n" +
            "    {\n" +
            "        width: 35%;\n" +
            "    }\n" +
            "    .MyAccountInfoPanel .MyAccountInfoSubmitButton a.BtnStyle4\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        text-align: right;\n" +
            "    }\n" +
            "\n" +
            "    /*CustomerRegister Address Begin*/\n" +
            "    .CustomerRegister\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .CustomerRegisterLeft, .CustomerRegisterRight\n" +
            "    {\n" +
            "        margin-left: 5%;\n" +
            "        width: 93%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .CustomerRegisterLeftLabel, .CustomerRegisterRightLabel\n" +
            "    {\n" +
            "        width: 26%;\n" +
            "        margin: 0 2% 0 0;\n" +
            "    }\n" +
            "    .CustomerRegisterLeftData, .CustomerRegisterRightData\n" +
            "    {\n" +
            "        width: 70%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .CustomerRegisterLinkButtonDiv\n" +
            "    {\n" +
            "        margin-right: 10%;\n" +
            "    }\n" +
            "    .CustomerRegisterPanel .ClientCityStatePanel\n" +
            "    {\n" +
            "        margin-left: 5%;\n" +
            "        width: 90%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .CustomerRegisterPanel .ClientCityStatePanel .CustomerRegisterLabel\n" +
            "    {\n" +
            "        width: 27%;\n" +
            "        margin: 0 2% 0 0;\n" +
            "    }\n" +
            "    .CustomerRegisterPanel .ClientCityStatePanel .CountryAndStateListDropDown\n" +
            "    {\n" +
            "        width: 65%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .CustomerRegisterPanel .CustomerRegisterCheckBox\n" +
            "    {\n" +
            "        margin-left: 30%;\n" +
            "        width: 65%;\n" +
            "    }\n" +
            "    .CustomerRegisterPanel .ClientCityStatePanel .CountryAndStateListCountryTextBox\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        float: left;\n" +
            "        margin-left: 29%;\n" +
            "        width: 65%;\n" +
            "    }\n" +
            "    .CustomerRegisterPanel .ClientCityStatePanel .CountryAndStateListStateTextBox\n" +
            "    {\n" +
            "        clear: none;\n" +
            "        float: right;\n" +
            "        margin-left: 0;\n" +
            "        margin-right: 6%;\n" +
            "        width: 65%;\n" +
            "    }\n" +
            "    .CustomerRegisterShippingInfoPanel .CustomerRegisterCityStatePanel\n" +
            "    {\n" +
            "        margin-left: 5%;\n" +
            "        width: 93%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .CustomerRegisterShippingInfoPanel .CustomerRegisterCityStatePanel .CustomerRegisterLabel\n" +
            "    {\n" +
            "        width: 26%;\n" +
            "        margin: 0 2% 0 0;\n" +
            "    }\n" +
            "    .CustomerRegisterShippingInfoPanel .CustomerRegisterCityStatePanel .CountryAndStateListDropDown\n" +
            "    {\n" +
            "        width: 63%;\n" +
            "        margin: 0;\n" +
            "        clear: none;\n" +
            "    }\n" +
            "    .CustomerRegisterShippingInfoPanel .CustomerRegisterCityStatePanel .CountryAndStateListCountryTextBox\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        float: left;\n" +
            "        margin-left: 28%;\n" +
            "        width: 63%;\n" +
            "    }\n" +
            "    .CustomerRegisterShippingInfoPanel .CustomerRegisterCityStatePanel .CountryAndStateListStateTextBox\n" +
            "    {\n" +
            "        clear: none;\n" +
            "        float: right;\n" +
            "        margin-left: 0;\n" +
            "        margin-right: 9%;\n" +
            "        width: 63%;\n" +
            "    }\n" +
            "\n" +
            "    /* Account Detail */\n" +
            "    .AccountDetailsButtonDiv\n" +
            "    {\n" +
            "        margin-right: 8%;\n" +
            "    }\n" +
            "    .AccountDetailsPanel .ClientCityStatePanel\n" +
            "    {\n" +
            "        margin-left: 5%;\n" +
            "        width: 90%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .AccountDetailsPanel .ClientCityStatePanel .CustomerRegisterLabel\n" +
            "    {\n" +
            "        width: 27%;\n" +
            "        margin: 0 2% 0 0;\n" +
            "    }\n" +
            "    .AccountDetailsPanel .ClientCityStatePanel .CountryAndStateListDropDown\n" +
            "    {\n" +
            "        width: 65%;\n" +
            "        margin: 0;\n" +
            "        clear: none;\n" +
            "    }\n" +
            "    untryAndStateListStateTextBox\n" +
            "    {\n" +
            "        clear: none;\n" +
            "        float: right;\n" +
            "        margin-left: 0;\n" +
            "        margin-right: 9%;\n" +
            "        width: 63%;\n" +
            "    }\n" +
            "    .AccountDetailsPanel .ClientCityStatePanel .CountryAndStateListCountryTextBox\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        float: left;\n" +
            "        margin-left: 29%;\n" +
            "        width: 65%;\n" +
            "    }\n" +
            "    .AccountDetailsPanel .ClientCityStatePanel .CountryAndStateListStateTextBox\n" +
            "    {\n" +
            "        clear: none;\n" +
            "        float: right;\n" +
            "        margin-left: 0;\n" +
            "        margin-right: 6%;\n" +
            "        width: 65%;\n" +
            "    }\n" +
            "    .AccountDetailsPanel .CustomerRegisterCheckBox\n" +
            "    {\n" +
            "        margin: 0 0 15px 30%;\n" +
            "    }\n" +
            "    .AccountDetailsPanel .CountryAndStateListValidationPanel\n" +
            "    {\n" +
            "        float: none;\n" +
            "    }\n" +
            "    .AccountDetailsPanel .ClientCityStatePanel .CommonAsterisk\n" +
            "    {\n" +
            "        margin-left: 5px;\n" +
            "    }\n" +
            "    .AccountMainDiv .AccountDetailsCheckBoxDiv\n" +
            "    {\n" +
            "        margin-left: 0;\n" +
            "        width: 90%;\n" +
            "    }\n" +
            "\n" +
            "    /*CompareList Begin*/\n" +
            "    .CompareListGridView .ImageHeader\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .CompareListGridView .NameHeader\n" +
            "    {\n" +
            "    }\n" +
            "    .CompareListGridView .DeleteHeader\n" +
            "    {\n" +
            "        width: 10%;\n" +
            "    }\n" +
            "    .CompareListGridView .PriceHeader\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "    }\n" +
            "    .CompareListGridView .AddToCartHeader\n" +
            "    {\n" +
            "        width: 30%;\n" +
            "    }\n" +
            "    .CompareListGridView .AddToCartItem a\n" +
            "    {\n" +
            "        display: table;\n" +
            "        margin: 5px auto;\n" +
            "        float: none;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .CompareListGridView .ImageItem\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "\n" +
            "    /*WishListGridView Begin*/\n" +
            "    .WishListGridView .ImageHeader\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .WishListGridView .NameHeader\n" +
            "    {\n" +
            "    }\n" +
            "    .WishListGridView .DeleteHeader\n" +
            "    {\n" +
            "        width: 10%;\n" +
            "    }\n" +
            "    .WishListGridView .PriceHeader\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "    }\n" +
            "    .WishListGridView .AddToCartHeader\n" +
            "    {\n" +
            "        width: 30%;\n" +
            "    }\n" +
            "    .WishListGridView .AddToCartItem a\n" +
            "    {\n" +
            "        display: table;\n" +
            "        margin: 5px auto;\n" +
            "        float: none;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .WishListGridView .ImageItem\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "\n" +
            "    /*OrderHistory Begin*/\n" +
            "    .OrderHistory .CommonGridViewItemsPerPageDiv\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .OrderHistory .CommonGridViewPagingDiv, .OrderHistory .SearchFilter\n" +
            "    {\n" +
            "        float: none;\n" +
            "        display: table;\n" +
            "        margin: auto;\n" +
            "    }\n" +
            "    .OrderHistoryGridView th, .OrderHistoryGridView td\n" +
            "    {\n" +
            "        padding: 3px 1%;\n" +
            "    }\n" +
            "    .OrderHistoryGridReOrderItemStyle, .OrderHistoryGridRmaItemStyle\n" +
            "    {\n" +
            "        display: table-row;\n" +
            "        border: 0 !important;\n" +
            "        text-align: left;\n" +
            "    }\n" +
            "    .OrderHistoryGridRmaHeaderStyle\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "\n" +
            "    /*PasswordDetails Begin*/\n" +
            "    .PasswordDetailsLabelColumn\n" +
            "    {\n" +
            "        width: 45%;\n" +
            "    }\n" +
            "    .PasswordDetailsInputColumn\n" +
            "    {\n" +
            "        width: 55%;\n" +
            "    }\n" +
            "    .PasswordDetailsButtonDiv\n" +
            "    {\n" +
            "        margin-right: 4%;\n" +
            "    }\n" +
            "\n" +
            "    /*ShippingAddressBook Begin*/\n" +
            "    .ShippingAddressBookList tr\n" +
            "    {\n" +
            "        display: table-row;\n" +
            "        width: 100%;\n" +
            "        float: none;\n" +
            "    }\n" +
            "    .ShippingAddressBookButtonDiv\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .ShippingAddressLinkPanel .BtnStyle2, .ShippingAddressBookButtonDiv .BtnStyle1\n" +
            "    {\n" +
            "        width: 70%;\n" +
            "        margin: 15px 15% 0;\n" +
            "    }\n" +
            "\n" +
            "    /*Advanced Search Begin*/\n" +
            "    .AdvancedSearchResult .OurPricePanel\n" +
            "    {\n" +
            "        font-size: 80%;\n" +
            "    }\n" +
            "    .AdvancedSearchResult .TableViewTellFriendPanel\n" +
            "    {\n" +
            "        width: 150%;\n" +
            "    }\n" +
            "    .AdvancedSearchLabel\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "    }\n" +
            "    .AdvancedSearchDrop\n" +
            "    {\n" +
            "        width: 75%;\n" +
            "    }\n" +
            "    .SearchTextByKeyword\n" +
            "    {\n" +
            "        width: 75%;\n" +
            "        margin: 15px 0 15px 25%;\n" +
            "    }\n" +
            "    .SearchByCategory\n" +
            "    {\n" +
            "        margin-top: 0;\n" +
            "    }\n" +
            "    .SearchByCategory .AdvancedSearchDrop\n" +
            "    {\n" +
            "        width: 75%;\n" +
            "    }\n" +
            "    .AdvancedSearchTypeCheckList\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        margin: 10px 0 0;\n" +
            "    }\n" +
            "    .SearchByPrice .AdvancedSearchLabel\n" +
            "    {\n" +
            "        width: 15%;\n" +
            "    }\n" +
            "    .SearchTextByPrice\n" +
            "    {\n" +
            "        width: 37.5%;\n" +
            "    }\n" +
            "    .AdvancedSearchManufacturerLabel, .AdvancedSearchDepartmentLabel, .AdvancedSearchVendorLabel\n" +
            "    {\n" +
            "        width: 35%;\n" +
            "    }\n" +
            "    .SearchByManufacturer .AdvancedSearchDrop, .SearchByDepartment .AdvancedSearchDrop .SearchByVendor\n" +
            "    {\n" +
            "        width: 65%;\n" +
            "    }\n" +
            "\n" +
            "    /* checkout right menu*/\n" +
            "    .OrderSummaryRightMenu\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        margin: 10px 0;\n" +
            "    }\n" +
            "    .GiftCouponDetailRightMenu\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        clear: left;\n" +
            "        margin: 10px 0;\n" +
            "    }\n" +
            "\n" +
            "    /* userlogin */\n" +
            "    .CommonUserLoginLoginPanel\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        background: none;\n" +
            "    }\n" +
            "    .CommonUserLoginRegisterPanel\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .CommonUserLoginPanelUserName input, .CommonUserLoginPanelPassword input\n" +
            "    {\n" +
            "        width: 60% !important;\n" +
            "    }\n" +
            "    .CommonUserLoginValidatorText\n" +
            "    {\n" +
            "        width: 60%;\n" +
            "    }\n" +
            "    .CommonUserLoginPanelRemember label\n" +
            "    {\n" +
            "        width: 80%;\n" +
            "    }\n" +
            "    .CommonUserLoginPanelButton\n" +
            "    {\n" +
            "        width: 30%;\n" +
            "    }\n" +
            "    .CommonUserLoginForgotPasswordDiv\n" +
            "    {\n" +
            "        width: 60%;\n" +
            "    }\n" +
            "    .CommonUserLoginRegisterLink\n" +
            "    {\n" +
            "        display: table;\n" +
            "        width: auto;\n" +
            "        margin: auto;\n" +
            "        float: none;\n" +
            "    }\n" +
            "\n" +
            "    /*Contact us*/\n" +
            "    .ContactUsCommentBox\n" +
            "    {\n" +
            "        width: 250px;\n" +
            "    }\n" +
            "    .ContactUsCaptcha\n" +
            "    {\n" +
            "        width: 230px;\n" +
            "    }\n" +
            "    .ContactUsCaptchaStyle div input\n" +
            "    {\n" +
            "        width: 250px;\n" +
            "    }\n" +
            "    .ContactUsButtonDiv\n" +
            "    {\n" +
            "        margin-right: 14.8%;\n" +
            "    }\n" +
            "    .ContactUsLabel\n" +
            "    {\n" +
            "        width: 100px;\n" +
            "    }\n" +
            "    .ContactUsData\n" +
            "    {\n" +
            "        width: 145px;\n" +
            "    }\n" +
            "    .ContactMap\n" +
            "    {\n" +
            "        width: 90%;\n" +
            "        height: 200px;\n" +
            "    }\n" +
            "    .ContactUsBlock .CommonValidateDiv\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "\n" +
            "    /*Checkout - Payment Begin*/\n" +
            "    .PaymentItemDiv\n" +
            "    {\n" +
            "    }\n" +
            "    .PaymentItemImageDiv\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .PaymentFrame\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .PaymentButtonDiv\n" +
            "    {\n" +
            "        width: 30%;\n" +
            "    }\n" +
            "    .checkout-center-col .PaymentDiv .SidebarTop .CheckoutAddressTitle\n" +
            "    {\n" +
            "        width: 70%;\n" +
            "        margin-left: 0;\n" +
            "    }\n" +
            "\n" +
            "    /*Checkout - Shipping */\n" +
            "    .checkout-center-col .CheckoutShippingInfoPanel .SidebarTop .CheckoutAddressTitle\n" +
            "    {\n" +
            "        padding-right: 10px;\n" +
            "    }\n" +
            "    .CheckoutAddressLeft\n" +
            "    {\n" +
            "        width: 95%;\n" +
            "        margin-left: 4%;\n" +
            "        margin-right: 0;\n" +
            "    }\n" +
            "    .CheckoutAddressRight\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        width: 95%;\n" +
            "        margin-left: 4%;\n" +
            "        margin-right: 0;\n" +
            "    }\n" +
            "    .CheckoutAddressLong\n" +
            "    {\n" +
            "        margin-left: 30%;\n" +
            "        width: 68%;\n" +
            "    }\n" +
            "    .CheckoutAddressLeftDataSelectAddress\n" +
            "    {\n" +
            "        margin-left: 0;\n" +
            "    }\n" +
            "    .CheckoutSpecialRequestPanel .CheckoutAddressLong\n" +
            "    {\n" +
            "        margin-left: 37.5%;\n" +
            "        width: 60%;\n" +
            "    }\n" +
            "    .CheckoutAddressLeftDataCheckbox label\n" +
            "    {\n" +
            "        width: 80%;\n" +
            "    }\n" +
            "    .ClientCityStatePanel\n" +
            "    {\n" +
            "        width: 95%;\n" +
            "        margin-left: 4%;\n" +
            "    }\n" +
            "    .CheckoutButtonDiv\n" +
            "    {\n" +
            "        width: 18%;\n" +
            "    }\n" +
            "    .Checkout .ShippingButtonDiv\n" +
            "    {\n" +
            "        width: 70%;\n" +
            "        margin-left: 16%;\n" +
            "        float: none;\n" +
            "    }\n" +
            "\n" +
            "    /* Order summery */\n" +
            "    .OrderSummarySubtotalHeaderStyle\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "    }\n" +
            "    .OrderSummarySummaryLabel\n" +
            "    {\n" +
            "        width: 75%;\n" +
            "    }\n" +
            "    .OrderSummarySummaryValue\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "    }\n" +
            "    .OrderSummaryShippingDetailsLabelColumn\n" +
            "    {\n" +
            "        width: 40%;\n" +
            "    }\n" +
            "\n" +
            "    /* Checkout Complete */\n" +
            "    td.CheckoutCompleteCustomerInfo, td.CheckoutCompleteCustomerShippingInfo\n" +
            "    {\n" +
            "        display: table-row;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .CheckoutCompletePrintLinkDiv\n" +
            "    {\n" +
            "        width: 48%;\n" +
            "        float: left;\n" +
            "        margin-left: 0;\n" +
            "    }\n" +
            "    .CheckoutCompleteBackLinkDiv\n" +
            "    {\n" +
            "        width: 48%;\n" +
            "        float: right;\n" +
            "        margin-top: 20px;\n" +
            "        margin-left: 0;\n" +
            "    }\n" +
            "    .CheckoutCompleteCustomerInfo .CheckoutCompleteGridView\n" +
            "    {\n" +
            "        width: 153%;\n" +
            "    }\n" +
            "    .CheckoutCompleteOrderCommentTable .CheckoutCompleteDetailsLabelColumn\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "    }\n" +
            "    .CheckoutCompleteCustomerShippingInfo .CheckoutCompleteGridView\n" +
            "    {\n" +
            "        width: 153%;\n" +
            "    }\n" +
            "\n" +
            "    /*Shopping Cart*/\n" +
            "    .CommonPageRight, .CommonLoginPageRight, .ContentLayoutRight\n" +
            "    {\n" +
            "        padding: 15px 0 0;\n" +
            "    }\n" +
            "    .ShoppingCartContinueShopping\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .ShoppingCartUpdateQuantity\n" +
            "    {\n" +
            "        width: 44%;\n" +
            "        margin-right: 5%;\n" +
            "    }\n" +
            "    .ShoppingCartClearCart\n" +
            "    {\n" +
            "        width: 44%;\n" +
            "        margin-right: 5%;\n" +
            "        margin-top: 3.5%;\n" +
            "    }\n" +
            "    .ShoppingCartNoteDiv\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        padding-bottom: 20px;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .ShoppingCartNoteDiv .NoteDetail\n" +
            "    {\n" +
            "        margin-left: 10%;\n" +
            "        margin-right: 10%;\n" +
            "    }\n" +
            "    .ShoppingCartShippingEstimator\n" +
            "    {\n" +
            "        margin-left: 10%;\n" +
            "        margin-right: 10%;\n" +
            "    }\n" +
            "    .ShoppingCartCouponDiv\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        margin: 0;\n" +
            "    }\n" +
            "    .ShoppingCartOrderTotal\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        padding: 25px 5% 25px 5%;\n" +
            "        margin: 10px 0;\n" +
            "    }\n" +
            "    .ShoppingCartGiftCouponInputCenter\n" +
            "    {\n" +
            "        margin-left: 20%;\n" +
            "        margin-right: 15%;\n" +
            "    }\n" +
            "    .ShoppingCartGiftCouponButton a\n" +
            "    {\n" +
            "    }\n" +
            "    .ShoppingCartTotalAmountLabel\n" +
            "    {\n" +
            "        font-size: 135%;\n" +
            "    }\n" +
            "    .ShoppingCartTotalAmount\n" +
            "    {\n" +
            "        font-size: 145%;\n" +
            "    }\n" +
            "    .ShoppingCartCheckoutLink, .ShoppingCartGiftRegistryLink\n" +
            "    {\n" +
            "        width: 85%;\n" +
            "        margin-right: 9%;\n" +
            "        padding-top: 1%;\n" +
            "        padding-bottom: 1%;\n" +
            "    }\n" +
            "    .GiftCouponDetailValidatorText\n" +
            "    {\n" +
            "        margin-left: 20%;\n" +
            "        width: 52%;\n" +
            "    }\n" +
            "    .ShoppingCartGiftCoupon .GiftCouponDetailValidatorText\n" +
            "    {\n" +
            "        margin-left: 20%;\n" +
            "        width: 52%;\n" +
            "    }\n" +
            "    .ShoppingCartGridView .ImageHeader\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ShoppingCartGridView .ImageItem\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ShoppingCartGridView .NameHeader\n" +
            "    {\n" +
            "        width: 20%;\n" +
            "    }\n" +
            "    .ShoppingCartGridView .NameItem\n" +
            "    {\n" +
            "    }\n" +
            "    .ShoppingCartGridView .PriceHeader\n" +
            "    {\n" +
            "        width: 20%;\n" +
            "    }\n" +
            "    .ShoppingCartGridView .QuantityHeader\n" +
            "    {\n" +
            "        width: 10%;\n" +
            "    }\n" +
            "    .ShoppingCartGridView .SubtotalHeader\n" +
            "    {\n" +
            "        width: 25%;\n" +
            "    }\n" +
            "    .ShoppingCartGridView .DeleteHeader\n" +
            "    {\n" +
            "        width: 10%;\n" +
            "    }\n" +
            "    .ShoppingCartButton a\n" +
            "    {\n" +
            "        width: 52%;\n" +
            "        margin: 5px 2%;\n" +
            "    }\n" +
            "    .ShoppingCartButton .ShoppingCartClearCart, .ShoppingCartButton .ShoppingCartUpdateQuantity\n" +
            "    {\n" +
            "        width: 40%;\n" +
            "    }\n" +
            "    .ShoppingCartButton a.ShoppingCartUpdateQuantity\n" +
            "    {\n" +
            "        margin: 5px 2%;\n" +
            "    }\n" +
            "    .ShoppingCartButton .ShoppingCartContinueShopping:hover\n" +
            "    {\n" +
            "        padding: 0px;\n" +
            "    }\n" +
            "    .ShoppingCartButton .ShoppingCartContinueShopping\n" +
            "    {\n" +
            "        padding: 0px;\n" +
            "    }\n" +
            "    .ShoppingCartCheckoutDiv\n" +
            "    {\n" +
            "        padding: 10px 0;\n" +
            "        width: 100%;\n" +
            "        clear: left;\n" +
            "        float: left;\n" +
            "    }\n" +
            "    .ShoppingCartGridView .CommonGridViewRowStyle .ImageItem\n" +
            "    {\n" +
            "        border-right: solid 1px #f0f0f0;\n" +
            "    }\n" +
            "    .ShoppingCart .CommonPageTop\n" +
            "    {\n" +
            "        margin-left: 0px;\n" +
            "    }\n" +
            "    .ShoppingCartGridView .NameItem\n" +
            "    {\n" +
            "        text-align: center;\n" +
            "        padding-left: 10px;\n" +
            "    }\n" +
            "    .ShoppingCartGridView .NameHeader\n" +
            "    {\n" +
            "        text-align: center;\n" +
            "        background-color: #fbfcfe;\n" +
            "        text-transform: uppercase;\n" +
            "    }\n" +
            "\n" +
            "    /*ForgotPassword Begin*/\n" +
            "    .ForgotPasswordPanel\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        margin-bottom: 10px;\n" +
            "    }\n" +
            "    .ForgotPasswordLoginImageButton\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        margin-left: 40%;\n" +
            "    }\n" +
            "\n" +
            "    /*Customer Review */\n" +
            "    .CustomerReviewContent .InfoTitleLabel\n" +
            "    {\n" +
            "        clear: left;\n" +
            "        width: 100%;\n" +
            "        margin: 10px 0;\n" +
            "    }\n" +
            "    .CustomerReviewMessageTextBox\n" +
            "    {\n" +
            "        width: 100% !important;\n" +
            "        margin: 0;\n" +
            "        float: none;\n" +
            "    }\n" +
            "    .CustomerReviewValidatorText\n" +
            "    {\n" +
            "        float: none;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "\n" +
            "    /* Promotion List */\n" +
            "    .PromotionGroupListItemTable td\n" +
            "    {\n" +
            "        display: block;\n" +
            "        width: 80%;\n" +
            "        margin: 10px auto;\n" +
            "        text-align: center;\n" +
            "    }\n" +
            "    .PromotionGroupListItemImageColumn\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .PromotionGroupListItemPriceLabel\n" +
            "    {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .PromotionGroupListItemPriceValue\n" +
            "    {\n" +
            "        float: none;\n" +
            "        margin: 5px auto;\n" +
            "    }\n" +
            "    .PromotionGroupListItemPriceDiv\n" +
            "    {\n" +
            "        float: none;\n" +
            "    }\n" +
            "    .PromotionGroupListItemButtonDiv\n" +
            "    {\n" +
            "        float: none;\n" +
            "        display: table;\n" +
            "        margin: auto;\n" +
            "        margin: 10px auto;\n" +
            "    }\n" +
            "\n" +
            "    /* Promotion Product Item List */\n" +
            "    .PromotionItem .ProductDetailsDefaultLikeButtonDiv\n" +
            "    {\n" +
            "        width: 80%;\n" +
            "    }\n" +
            "    .PromotionProductGroup\n" +
            "    {\n" +
            "        padding: 15px 5px;\n" +
            "    }\n" +
            "    .PromotionProductItem .ProductImage\n" +
            "    {\n" +
            "        left: 0%;\n" +
            "    }\n" +
            "    .PromotionProductGroupDataList .ProductGroupCombineItem\n" +
            "    {\n" +
            "        width: 25px;\n" +
            "    }\n" +
            "    .PromotionProductGroupDataList .ProductGroupCombineItem div\n" +
            "    {\n" +
            "        width: 25px;\n" +
            "    }\n" +
            "    .PromotionItem .PromotionDetailsDefaultImageTellFriendImage, .PromotionItem .PromotionDetailsDefaultImageAddtoCart\n" +
            "    {\n" +
            "        width: 48%;\n" +
            "    }\n" +
            "    .PromotionProductGroupDataList .PromotionProductItem\n" +
            "    {\n" +
            "        width: 90%;\n" +
            "        margin-left: 5%;\n" +
            "        margin-right: 5%;\n" +
            "    }\n" +
            "    .PromotionProductGroupDataList .ProductGroupProductItemStyle\n" +
            "    {\n" +
            "        width: 112px;\n" +
            "    }\n" +
            "\n" +
            "    /* Tell a friend */\n" +
            "    .TellFriendFormLabel\n" +
            "    {\n" +
            "        width: 90%;\n" +
            "        margin-left: 0;\n" +
            "    }\n" +
            "    .TellFriendFormData\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "    .TellFriendFormTextEditorDiv\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        margin-left: 0;\n" +
            "    }\n" +
            "    .TellFriendCapchaDiv\n" +
            "    {\n" +
            "        width: 90%;\n" +
            "        margin-left: 0;\n" +
            "    }\n" +
            "\n" +
            "    /* StoreSitemap */\n" +
            "    .StoreSiteMapProductDataListItemStyle, .StoreSiteMapDepartmentDataListItemStyle\n" +
            "    {\n" +
            "        display: inline-block;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "\n" +
            "    /*Affiliate*/\n" +
            "    .AffiliateCommissionSearchLabel\n" +
            "    {\n" +
            "        width: 80px;\n" +
            "    }\n" +
            "    .AffiliateCommissionSearchValidateDiv\n" +
            "    {\n" +
            "        width: 80px;\n" +
            "    }\n" +
            "    .AffiliateCommissionSearchData .CommonTextBox\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .AffiliateCommissionSearchValidateDiv .CommonTextBox\n" +
            "    {\n" +
            "        width: 100% !important;\n" +
            "    }\n" +
            "    .MyAccountRecentOrderDiv .SubmitButton\n" +
            "    {\n" +
            "        width: 110%;\n" +
            "    }\n" +
            "    .AffiliateDashboard .ShoppingCartUpdateQuantity\n" +
            "    {\n" +
            "        margin-right: 0px;\n" +
            "    }\n" +
            "\n" +
            "    /* OnePageCheckout */\n" +
            "    .OnePageCheckout .ShippingButtonDiv\n" +
            "    {\n" +
            "        width: 20%;\n" +
            "    }\n" +
            "\n" +
            "    /* GiftCertificate */\n" +
            "    .GiftCertificateTextBox\n" +
            "    {\n" +
            "        width: 50% !important;\n" +
            "    }\n" +
            "\n" +
            "    /*VendorList*/\n" +
            "    .VendorListItemStyle .LogoImage\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .VendorListItemStyle .StoreName, .VendorListItemStyle .CompanyDescription\n" +
            "    {\n" +
            "        clear: both;\n" +
            "        display: inline-block;\n" +
            "        width: 100%;\n" +
            "        margin: 15px 0 0;\n" +
            "        text-align: center;\n" +
            "    }\n" +
            "\n" +
            "    /* VendorDetail */\n" +
            "    .VendorInfo .LogoImage\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .VendorInfo .GeneralInfo\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        margin-left: 0;\n" +
            "        margin-top: 10px;\n" +
            "    }\n" +
            "    .VendorInfo .InfoContent\n" +
            "    {\n" +
            "        width: 100%;\n" +
            "        clear: left;\n" +
            "        float: left;\n" +
            "        margin-bottom: 10px;\n" +
            "    }\n" +
            "    .CustomerRegister .ajax__htmleditor_editor_container\n" +
            "    {\n" +
            "        width: 170px !important;\n" +
            "        clear: left;\n" +
            "    }\n" +
            "\n" +
            "}\n" +
            "\n" +
            "@media only screen and (orientation: portrait)\n" +
            "{\n" +
            "}\n" +
            "\n";
}