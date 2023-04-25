package com.wishbook.catalog.TestCases;

import java.util.ArrayList;

public class Product {
    public enum ProductType {
        Catalog,
        NonCatalog,
        SetMatch
    }

/*
    public enum TopCategory {
        Menswear,
        Womenswear
    }
*/
    public enum PhotoShootType {
        LiveModelPhotoShoot,
        WhiteBackGroundOrFaceCut,
        PhotosWithoutModel
    }

    public enum Category {
        BlazersAndSuits("Blazers & Suites"),
        Blouse("Blouse"),
        DressMaterialsDressUnstitched("Dress Material - Unstitched"),
        Ghagra("Ghagra"),
        GownSemiStitched("Gown - Semi-Stitched"),
        GownStitched("Gown - Stitched"),
        Jeans("Jeans"),
        Kurtis("Kurtis"),
        Lehengas("Lehengas"),
        Dupatta("Dupatta"),
        Palazzo("Palazzo"),
        Leggins("Leggins"),
        Sarees("Sarees"),
        Shirts("Shirts"),
        SuitReadyMade("Suits - Readymade"),
        Tshirts("T-Shirts"),
        TrousersAndChino("Trousers & Chino"),
        WinterWear("Winter Wear"),
        IndoWesternSherwanis("Indo Western Sherwanis"),
        Jackets("Jackets"),
        Kurta("Kurta"),
        KurtaPyjamas("Kurta Pyjamas"),

        BlazersAndSuitsSizeSet("Blazers & Suites (size set)"),
        BlouseSizeSet("Blouse (size set)"),
        DressMaterialsUnstitchedColorSet("Dress Material - Unstitched (color set)"),
        GhagraColorSet("Ghagra (color set)"),
        GownSemiStitchedSizeSet("Gown - Semi-Stitched (size set)"),
        GownStitchedSizeSet("Gown - Stitched (size set)"),
        JeansSizeSet("Jeans (size set)"),
        DupattaSet("Dupatta (color set)"),
        PalazzoSet("Palazzo (color set"),
        LegginsSet("Leggings (color set)"),
        KurtisSizeSet("Kurtis (size set)"),
        LehengasSizeSet("Lehengas (size set)"),
        SareesColorSet("Sarees (color set)"),
        ShirtsSizeSet("Shirts (size set)"),
        SuitReadyMadeSizeSet("Suits - Readymade (size set)"),
        TshirtsSizeSet("T-Shirts (size set)"),
        TrousersAndChinoSizeSet("Trousers & Chino (size set)"),
        WinterWearSizeSet("Winter Wear (size set)"),
        IndoWesternSherwanisSizeSet("Indo Western Sherwanis (size set)"),
        JacketsSizeSet("Jackets (size set)"),
        KurtaSizeSet("Kurta (size set)"),
        KurtaPyjamasSizeSet("Kurta Pyjamas (size set)");

        private String uiName;
        Category(String uiName)
        {
            this.uiName=uiName;
        }

        public String getUiName()
        {
            return uiName;
        }

    }

    public enum SellingProductAs {
        FullCatalog,
        SinglePiecesAndFullSetBoth

    }

    public enum WinterWearType {
        Jackets("Jackets"), Sweatshirts("Sweatshirts"), Sweaters("Sweaters"), Thermals("Sweaters");
        private String uiName;
        WinterWearType(String uiName)
        {
            this.uiName=uiName;
        }

        public String getUiName()
        {
            return uiName;
        }
    }

    public enum Stretch {
        Stretchable("Stretchable"), NonStretchable("Non Stretchable");

        private String uiName;
        Stretch(String uiName)
        {
            this.uiName=uiName;
        }

        public String getUiName()
        {
            return uiName;
        }
    }

    public enum Rise {
        HighRise("High Rise"), LowRise("Low Rise"), MidRise("Mid Rise");

        private String uiName;
        Rise(String uiName)
        {
            this.uiName=uiName;
        }

        public String getUiName()
        {
            return uiName;
        }
    }

    public enum NeckType {
        Hooded("Hooded"), Collar("Collar"), HalfZip("Half Zip"), Round("Round"),
        VNeck("V Neck"), UNeck("U Neck"), FullZip("Full Zip"), RoundNeck("Round Neck"),
        CollarNeck("Collar Neck"), Chinesecollar("Chinese collar");

        private String uiName;
        NeckType(String uiName)
        {
            this.uiName=uiName;
        }

        public String getUiName()
        {
            return uiName;
        }

        }

    public enum Sleeve {
        FullSleeve("Full Sleeve"), HalfSleeve("Half Sleeve"), Sleeveless("Sleeveless");

        private String uiName;
        Sleeve(String uiName)
        {
            this.uiName=uiName;
        }

        public String getUiName()
        {
            return uiName;
        }
    }

    public enum Fit {
        ClassicFit("Classic Fit"),
        ModernContemporaryFit("Modern Contemporary Fit"),
        SkinnyFit("Skinny Fit"),
        RegularFit("Regular Fit"),
        SlimFit("Slim Fit"),
        PencilFit("Pencil Fit"),
        StraightFit("Straight Fit"),
        NarrowFit("Narrow Fit"),
        TaperedFit("Tapered Fit");


        private String uiName;
        Fit(String uiName)
        {
            this.uiName=uiName;
        }

        public String getUiName()
        {
            return uiName;
        }


    }

    public enum StitchingType {
        UnStitched("Un Stitched"),
        SemiStitched("Semi Stitched"),
        Stitched("Stitched");

        private String uiName;
        StitchingType(String uiName)
        {
            this.uiName=uiName;
        }

        public String getUiName()
        {
            return uiName;
        }

    }

    public enum Size {
        XS("XS"), S("S"), M("M"), L("L"), XL("XL"), UnStitched("UnStitched"), TwoXL("2XL"),
        ThreeXL("3XL"), FourXL("4XL"), TwentyFour("24"), TwentySix("26"), TwentyEight("28"),
        Thirty("30"), ThirtyTwo("32"), ThirtyFour("34"), ThirtySix("36"),
        ThirtyEight("38"), Forty("40"), FortyTwo("42"), FortyFour("44"), FortySix("46");


        private String uiName;
        Size(String uiName)
        {
            this.uiName=uiName;
        }

        public String getUiName()
        {
            return uiName;
        }


    }

    public enum Style {
        Denim("Denim"), Plain("Plain"), Lucknowi("Lucknowi"), Banarasi("Banarasi"),
        Bangalori("Bangalori"), Bhagalpuri("Bhagalpuri"), Karachi("Karachi"), Uniform("Uniform"),
        Pakistani("Pakistani"), Patiyala("Patiyala"), TailCut("Tail Cut"), KaftanStyle("Kaftan Style"),
        FrontSlit("Front Slit"), Flared("Flared"), ShirtStyle("Shirt Style"), Angrakha("Angrakha"),
        OverlayStyle("Overlay Style"), LongStraightCut("Long Straight Cut"), Anarkali("Anarkali"),
        DhotiStyle("Dhoti Style"), Asymmetrical("Asymmetrical"), ShortKurti("Short Kurti"),
        FloorLength("Floor Length"), ACut("A-Cut"), CasualTrousers("Casual Trousers"),
        FormalTrousers("Formal Trousers"), Chinos("Chinos"), Checkered("Checkered"),
        Cargos("Cargos"), SherwaniKurtaPayjama("Sherwani Kurta Payjama"),
        PunjabiKurtaPayjama("Punjabi Kurta Payjama"), PathaniKurtaPayjama("Pathani Kurta Payjama"),
        LucknowiKurtaPayjama("Lucknowi Kurta Payjama"), BasicJeans("Basic Jeans"), FadedJeans("Faded Jeans"),
        TornJeans("Torn Jeans"), LaceJeans("Lace Jeans"), JoggerJeans("Jogger Jeans"), JeansWithDetachable("Jeans With Detachable"),
        CargoJeans("CargoJeans"), Hooded("Hooded"), HoodedWithZip("Hooded With Zip"),
        HoodieWithoutZip("HoodieWithoutZip"), Striped("CorduroyBlazer"), CorduroyBlazer("CorduroyBlazer"),
        PlaidBlazer("PlaidBlazer"), RegularBlazer("RegularBlazer"), SeerSuckerBlazer(""),
        TweedBlazer("TweedBlazer"), VelvetBlazer("VelvetBlazer"), Casual("Casual"),
        Formal("Formal"), PartyWear(""), Beachwear("Beachwear"), BigCheck("BigCheck"),
        Dotted(""), Cargo(""), Shaded(""), FadedDenim(""),
        FloralPrint(""), CheckeredShirts(""), HorizontalLining(""),
        Kurta(""), PlainShirts(""), SmallChecked(""), Printed(""),
        Polo("Polo"), Hoodie(""), OdourFree(""), HalfZipped("");


        private String uiName;
        Style(String uiName)
        {
            this.uiName=uiName;
        }

        public String getUiName()
        {
            return uiName;
        }

    }

    public enum Work {
        BandhejBandhani("Bandhej Bandhani"), Chikankari("Chikankari"), Crochet("Crochet"),
        DigitalPrint("Digital Print"), Embossed("Embossed"), Embroidery("Embroidery"),
        Glitter("Glitter"), HandWork("Hand Work"), Kalamkari("Kalamkari"), Lace("Lace"),
        MadhubaniPrint(""), Mirror("Mirror"), PatchWork("Patch Work"), PearlWork("Pearl Work"),
        Print("Print"), Sequin("Sequin"), SifliEmbroidery("Sifli Embroidery"), Stone("Stone"),
        Woven("Woven"), Zardosi("Zardosi"), Zari("Zari"), Plain("Plain"), Gotapatti("Gotapatti"),
        Chicken("Chicken"), Swarovski("Swarovski"), KhatliWork("Khatli Work");


        private String uiName;
        Work(String uiName)
        {
            this.uiName=uiName;
        }

        public String getUiName()
        {
            return uiName;
        }



        }


    public enum Fabric {
        ArtSilk("Art Silk"), Brasso("Brasso"), Brocade("Brocade"), Chanderi("Chanderi"), Chiffon("Chiffon"),
        Cotton("Cotton"),Crepe("Crepe"), Dhupian("Dhupian"), FauxGeorgette("Faux Georgette"),
        Jacquard("Jacquard"), Jute("Jute"), Net("Net"), PolyBlend("Poly Blend"), PolyCotton("Poly Cotton"),
        Polyester("Polyester"), PureGeorgette("PureGeorgette"), RawSilk("Raw Silk"),
        Santoon("Santoon"), Satin("Satin"), Shimmer("Shimmer"), Supernet("Supernet"), Velvet(" Velvet"),
        Viscose("Viscose"), Rayon("Rayon"), Pashmina("Pashmina"), Silk("Silk"), BhagalpuriSilk(" Bhagalpuri Silk"),
        Weightless("Weightless"), Denim("Denim"), Khadi("Khadi"), Linen("Linen"), Marble("Marble"),
        Renial("Renial"), Lycra("Lycra"), Cambric("Cambric"),Dani("Dani"), Muslin("Muslin"), Rangoli("Rangoli"),
        lawn("lawn"), Bridal("Bridal"), SemiLawn("Semi Lawn"), Nylon("Nylon"), Leon("Leon"), Vanilla("Vanilla"),
        Kora("Kora"), LizziBizzi("Lizzi Bizzi"), ChikuMagicSilk("Chiku Magic Silk"), TafetaSilk("Tafeta Silk"),
        Weaving("Weaving"), Poplin("Poplin"), Yarn("Yarn"), Woolen("Woolen"), Melange("Melange"),
        HundredPercentCotton("100% Cotton"), BhagalpuriJute("Bhagalpuri Jute"), BrokenTwill("Broken Twill"),
        ChanderiCotton("Chanderi Cotton"), Corduroy("Corduroy"), Dobby("Dobby"), Georgette("Georgette"),
        GlazeCotton("Glaze Cotton"), Hosiery("Hosiery"), Matty("Matty"), Blended(" Blended"),
        Drift("Drift"), Jersey("Jersey"), Knit("Knit"), MicroPolyester("MicroPolyester"), Codra("Codra"),
        Dupion("Dupion"), Lamalam("Lamalam"), Synthetic("Synthetic"), Wool("Wool"), CottonBlended("Cotton Blended"),
        AcroWool("Acro Wool"), Acrylic("Acrylic"), Daffodil("Daffodil"), Fleece("Fleece"),
        Scuba("Scuba"), Slub("Slub"), Spandex("Spandex"), CamrilCotton("Camril Cotton"), CottonSlub("Cotton Slub"),
        KhadiCotton("Khadi Cotton"), BlendedSilk("Blended Silk"), remiLinen("remi Linen"), Terracotta("Terracotta"),
        Twill("Twill"), codroid("codroid"), RibKnit("RibKnit"), Sinket("Sinket"), Spun("Spun"),
        Waffle("Waffle"), PcSinker("Pc Sinker"), Pique("Pique"), Milanch("Milanch"), Microfiber("Microfiber"),
        Maleshiya("Maleshiya"), FauxLeather("Faux Leather"), Hute("Hute"), Leather("Leather"),
        PU("PU"), Rexien("Rexien"), CottonBlend("Cotton Blend"), Flannel("Flannel"), Tweed("Tweed");



        private String uiName;
        Fabric(String uiName)
        {
            this.uiName=uiName;
        }

        public String getUiName()
        {
            return uiName;
        }


        }



    public enum PriceForSinglePieces{
        EnterMarginWithPercentage,
        EnterMarginWithRupees
    }

    public class Set{
        private String designName = "";
        private int numberOfImages = 1;
        private int keepLiveDuration = 30;
        private String colors = "";
        private String itemName="";
        private  int numberOfPcsPerSet= 4;
        private int pricePerPiece=500;

        public int getNumberOfPcsPerSet() {
            return numberOfPcsPerSet;
        }

        public void setNumberOfPcsPerSet(int numberOfPcsPerSet) {
            this.numberOfPcsPerSet = numberOfPcsPerSet;
        }

        public int getPricePerPiece() {
            return pricePerPiece;
        }

        public void setPricePerPiece(int pricePerPiece) {
            this.pricePerPiece = pricePerPiece;
        }

        public String getDesignName() {
            return designName;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public void setDesignName(String designName) {
            this.designName = designName;
        }

        public int getNumberOfImages() {
            return numberOfImages;
        }

        public void setNumberOfImages(int numberOfImages) {
            this.numberOfImages = numberOfImages;
        }

        public int getKeepLiveDuration() {
            return keepLiveDuration;
        }

        public void setKeepLiveDuration(int keepLiveDuration) {
            this.keepLiveDuration = keepLiveDuration;
        }

        public String getColors() {
            return colors;
        }

        public void setColors(String colors) {
            this.colors = colors;
        }

        private void print() {
            System.out.println("Price Per Piece : "+pricePerPiece);
            System.out.println("Number Of Pcs Per Set : "+numberOfPcsPerSet);
            System.out.println("Design Name : " + designName);
            System.out.println("Number Of Images: " + numberOfImages);
            System.out.println("Keep alive Duration : " + keepLiveDuration);
            System.out.println("Set Color : " + colors);
            System.out.println("Set Item Name: " + itemName);

        }
    }

    private static final String DASHES = new String(new char[80]).replace("\0", "-");
    private ProductType productType = ProductType.Catalog;
//    private TopCategory topCategory = TopCategory.Menswear;
    private PhotoShootType photoShootType = PhotoShootType.LiveModelPhotoShoot;
    private Category category = Category.Jeans;
    private SellingProductAs sellingProductAs = SellingProductAs.FullCatalog;
    private WinterWearType winterWearType = WinterWearType.Sweatshirts;
    private Stretch stretch = Stretch.Stretchable;
    private Rise rise = Rise.HighRise;
    private NeckType neckType = NeckType.CollarNeck;
    private Sleeve sleeve = Sleeve.FullSleeve;
    private Fit fit = Fit.ClassicFit;
    private StitchingType stitchingType = StitchingType.SemiStitched;
    private Style style = Style.DhotiStyle;
    private ArrayList<Fabric> fabrics= new ArrayList<Fabric>();
    private ArrayList<Work> works = new ArrayList<Work>();
    private ArrayList<Size> sizes= new ArrayList<Size>();
    private int numberOfDesigns =2;
    private int productPrice=1000;
    private boolean samePriceForAllDesigns= true;
    private String productName="";
    private String brandName="";

    public PriceForSinglePieces getPriceForSinglePieces() {
        return priceForSinglePieces;
    }

    public void setPriceForSinglePieces(PriceForSinglePieces priceForSinglePieces) {
        this.priceForSinglePieces = priceForSinglePieces;
    }

    private PriceForSinglePieces priceForSinglePieces=PriceForSinglePieces.EnterMarginWithPercentage;




    private ArrayList<Set> sets = new ArrayList<Set>();

    public int getNumberOfDesigns() {        return numberOfDesigns;
    }

    public void setNumberOfDesigns(int numberOfDesigns) {
        this.numberOfDesigns = numberOfDesigns;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isSamePriceForAllDesigns() {
        return samePriceForAllDesigns;
    }

    public void setSamePriceForAllDesigns(boolean samePriceForAllDesigns) {
        this.samePriceForAllDesigns = samePriceForAllDesigns;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public PhotoShootType getPhotoShootType() {
        return photoShootType;
    }

    public void setPhotoShootType(PhotoShootType photoShootType) {
        this.photoShootType = photoShootType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SellingProductAs getSellingProductAs() {
        return sellingProductAs;
    }

    public void setSellingProductAs(SellingProductAs sellingProductAs) {
        this.sellingProductAs = sellingProductAs;
    }

    public WinterWearType getWinterWearType() {
        return winterWearType;
    }

    public void setWinterWearType(WinterWearType winterWearType) {
        this.winterWearType = winterWearType;
    }

    public Stretch getStretch() {
        return stretch;
    }

    public void setStretch(Stretch stretch) {
        this.stretch = stretch;
    }

    public Rise getRise() {
        return rise;
    }

    public void setRise(Rise rise) {
        this.rise = rise;
    }

    public NeckType getNeckType() {
        return neckType;
    }

    public void setNeckType(NeckType neckType) {
        this.neckType = neckType;
    }

    public Sleeve getSleeve() {
        return sleeve;
    }

    public void setSleeve(Sleeve sleeve) {
        this.sleeve = sleeve;
    }

    public Fit getFit() {
        return fit;
    }

    public void setFit(Fit fit) {
        this.fit = fit;
    }

    public StitchingType getStitchingType() {
        return stitchingType;
    }

    public void setStitchingType(StitchingType stitchingType) {
        this.stitchingType = stitchingType;
    }


    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public ArrayList<Fabric> getFabrics() {
        return fabrics;
    }

    public void setFabrics(ArrayList<Fabric> fabrics) {
        this.fabrics = fabrics;
    }

    public ArrayList<Work> getWorks() {
        return works;
    }

    public void setWorks(ArrayList<Work> works) {
        this.works = works;
    }

    public ArrayList<Size> getSizes() {
        return sizes;
    }

    public void setSizes(ArrayList<Size> sizes) {
        this.sizes = sizes;
    }

    public ArrayList<Set> getSets() {
        return sets;
    }

    public void setSets(ArrayList<Set> sets) {
        this.sets = sets;
    }

    private void print() {
        System.out.println(DASHES);
        System.out.println("Product Type : " + productType.toString());
        System.out.println("PhotoShoot Type : " + photoShootType.toString());
        System.out.println("Category : " + category.toString());
        System.out.println("Selling Product As  : " + sellingProductAs.toString());
        System.out.println("Winter Wear : " + winterWearType.toString());
        System.out.println("Stretch : " + stretch.toString());
        System.out.println("Rise : " + rise.toString());
        System.out.println("Sleeve : " + category.toString());
        System.out.println("Fit : " + fit.toString());
        System.out.println("Stitching Type : " + stitchingType.toString());
        System.out.println("Fabric : " + fabrics.toString());
        System.out.println("Work : " + works.toString());
        System.out.println("Sizes : " + sizes.toString());
        System.out.println("Style : " + style.toString());
        if(productType==ProductType.SetMatch) {
            int count = 0;
            for(Set set:sets){
                count++;
                System.out.println("Set "+count);
                set.print();
            }
        }
        System.out.println(DASHES);


    }


}
