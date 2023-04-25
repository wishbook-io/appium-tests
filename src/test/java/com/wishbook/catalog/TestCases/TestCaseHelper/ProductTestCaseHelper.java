package com.wishbook.catalog.TestCases.TestCaseHelper;

import com.wishbook.catalog.PageObject.CatalogToolBar.CatalogToolBarFactory;
import com.wishbook.catalog.PageObject.CatalogToolBar.CatalogToolBarStrategy;
import com.wishbook.catalog.PageObject.ProductSpinner.ProductSpinnerFactory;
import com.wishbook.catalog.PageObject.ProductSpinner.ProductSpinnerStrategy;
import com.wishbook.catalog.TestCases.TestCase;

public abstract class ProductTestCaseHelper extends BaseTestCaseHelper {
    public enum SetType{
        SingleColorSet,
        MultiSet
    }
    public enum PhotoshootType{
        Catalog,
        WhiteBackgroundOrFaceCut
    }
    protected SetType setType;
    protected PhotoshootType photoshootType;
    public ProductTestCaseHelper(TestCase testCase,SetType setType,PhotoshootType photoshootType) {
        super(testCase);
        this.setType=setType;
        this.photoshootType=photoshootType;
    }
    protected abstract void executeCatalogRelatedSteps();
    protected abstract void executeNonCatalogRelatedSteps();
    protected abstract void executeScreensRelatedSteps();

    protected boolean isCatalog(SetType setType, PhotoshootType photoshootType){
        return setType==SetType.SingleColorSet && photoshootType==PhotoshootType.Catalog;
    }
    protected boolean isNonCatalog(SetType setType, PhotoshootType photoshootType){
        return setType==SetType.SingleColorSet && photoshootType==PhotoshootType.WhiteBackgroundOrFaceCut;
    }
    protected boolean isScreens(SetType setType, PhotoshootType photoshootType){
        return setType==SetType.MultiSet && photoshootType==PhotoshootType.WhiteBackgroundOrFaceCut;
    }
    protected boolean isCatalog(){
        return isCatalog(setType,photoshootType);
    }
    protected boolean isNonCatalog(){
        return isNonCatalog(setType,photoshootType);
    }
    protected boolean isScreens(){
        return isScreens(setType,photoshootType);
    }
    public void execute(){
        if(isCatalog()){
            executeCatalogRelatedSteps();
        }else if(isNonCatalog()){
            executeNonCatalogRelatedSteps();
        }else if(isScreens()){
            executeScreensRelatedSteps();
        }
    }

    public void selectProductTypeInUploadPage(){
        selectProductTypeInUploadPage(setType,photoshootType);
    }
    public void selectProductTypeInUploadPage(SetType setType, PhotoshootType photoshootType){
        int index = -1;
        if(isCatalog(setType,photoshootType)){
            index=0;
        }else if(isNonCatalog(setType,photoshootType)){
            index=1;
        }else if(isScreens(setType,photoshootType)){
            index=2;
        }
        if(index>-1) {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ProductSpinnerStrategy productSpinnerStrategy = ProductSpinnerFactory.getStrategy(testCase);
            productSpinnerStrategy.selectProductTypeSpinner(index);
        }
    }

    public void selectProductTypeInProductsTab(){
        selectProductTypeInProductsTab(setType,photoshootType);
    }
    public void selectProductTypeInProductsTab(SetType setType, PhotoshootType photoshootType){
        int index = -1;
        if(isCatalog(setType,photoshootType)){
            index=0;
        }else if(isNonCatalog(setType,photoshootType)){
            index=1;
        }else if(isScreens(setType,photoshootType)){
            index=2;
        }
        if(index>-1) {
            CatalogToolBarStrategy catalogToolBarStrategy = CatalogToolBarFactory.getStrategy(testCase);
            catalogToolBarStrategy.clickProductTypeSpinner();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ProductSpinnerStrategy productSpinnerStrategy = ProductSpinnerFactory.getStrategy(testCase);
            productSpinnerStrategy.selectProductTypeSpinnerAtProductTab(index);
        }
    }
}
