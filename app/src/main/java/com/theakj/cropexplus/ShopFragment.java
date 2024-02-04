package com.theakj.cropexplus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ShopFragment extends Fragment {


 /*   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    } */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_shop, container, false);

        Button shop_1 = view.findViewById(R.id.shop_1);
        Button shop_2 = view.findViewById(R.id.shop_2);
        Button shop_3 = view.findViewById(R.id.shop_3);
        Button shop_4 = view.findViewById(R.id.shop_4);
        Button shop_5 = view.findViewById(R.id.shop_5);
        Button shop_6=  view.findViewById(R.id.shop_6);
        Button shop_7 = view.findViewById(R.id.shop_7);
        Button shop_8 = view.findViewById(R.id.shop_8);
        Button shop_9 = view.findViewById(R.id.shop_9);
        Button shop_10 = view.findViewById(R.id.shop_10);

        shop_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.bigbasket.com/pd/40008671/natures-plus-organic-fertiliser-1-kg/?z=MzE0OTkyNTYwMA&utm_source=google&utm_medium=cpc&utm_campaign=Kolkata-PLA/&gclid=Cj0KCQjw9rSoBhCiARIsAFOiplksGAQ9wsqKI22Prj6fggWbAaD4pOhGHDO_YZdQLwglKJ0UG8aN7BUaArW8EALw_wcB");
            }
        });

        shop_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.ugaoo.com/products/plant-fertilizer-pellets-1-kg?variant=40857959628932&currency=INR&utm_medium=product_sync&utm_source=google&utm_content=sag_organic&utm_campaign=sag_organic&gclid=Cj0KCQjw9rSoBhCiARIsAFOiplm4RISGxmu-O8rIWnlzfG0XgEPBh-05p_aVe1tfkkYBM9Mc58o9aMMaArfHEALw_wcB");

            }
        });

        shop_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.flipkart.com/ecogreen-vermicompost-fertilizer-fertilizer-manure-potting-mixture-husk/p/itme39c5b579789e?pid=SMNFZG93UCSDCPGW&lid=LSTSMNFZG93UCSDCPGWSPJF5S&marketplace=FLIPKART&cmpid=content_soil-manure_8965229628_gmc");

            }
        });
        shop_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.iffcobazar.in/en/product/n-p-k-19-19-19#wsf-19-19-19-imported-1-kg");

            }
        });
        shop_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.krisikart.com/product/buy-yara-calcium-nitrate-fertilizer-online/?srsltid=AfmBOoqveOTgeHLoDICaVg9HjmkllKwGwTFqVRsMqhKqm1NfX9kTA4E7_3w");

            }
        });
        shop_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.amazon.in/Trust-basket-Cow-Manure-Plant/dp/B07Q3VYJYB/ref=sr_1_2_sspa?crid=DXVUPUOGL776&keywords=fertilizer%2Bfor%2Bplants&qid=1695442739&sprefix=Fertili%2Caps%2C620&sr=8-2-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&th=1");
            }
        });
        shop_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.flipkart.com/radix-magic-hydrogel-potassium-polyacrylate-based-super-absorbent-polymer-agriculture-home-plants-garden-manure-fertilizer-potting-mixture-soil/p/itmb2493da8ddaec?pid=SMNFTGJNWYGZNCK2&lid=LSTSMNFTGJNWYGZNCK2N9C0ZS&marketplace=FLIPKART&q=fertilizer+for+plants&store=h1m%2Fum7%2Fsd1%2Fiqo&srno=s_1_12&otracker=AS_QueryStore_OrganicAutoSuggest_1_10_na_na_na&otracker1=AS_QueryStore_OrganicAutoSuggest_1_10_na_na_na&fm=search-autosuggest&iid=en_bxN1NNyLtIXqT43jAcBfPNWAIKmVQ_lReSmHlclkKeeeGYr7czZohFadRriAn8jHKbimGb_PbX3Hg16p5ROW8w%3D%3D&ppt=sp&ppn=sp&qH=d01ecfa39b30ea6d");
            }
        });
        shop_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.ugaoo.com/products/gardenia-organic-manure-1-kg?variant=40855754768516&currency=INR&utm_medium=product_sync&utm_source=google&utm_content=sag_organic&utm_campaign=sag_organic&gclid=Cj0KCQjw9rSoBhCiARIsAFOiplnZ1_tvzPCWFmTMCvBtCHYCitz4VkchpNV5rqGYe-IXWRw4QLHZpDgaAnX9EALw_wcB");
            }
        });
        shop_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.amazon.in/Trust-Enriched-Organic-Potting-Fertilizer/dp/B07L68TK8D/ref=sr_1_21_sspa?crid=DXVUPUOGL776&keywords=fertilizer+for+plants&qid=1695442739&sprefix=Fertili%2Caps%2C620&sr=8-21-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9tdGY&psc=1");
            }
        });

        shop_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.amazon.in/Go-Garden-Growth-Liquid-Fertilizer/dp/B0CCYY9GHJ/ref=sr_1_35?crid=DXVUPUOGL776&keywords=fertilizer+for+plants&qid=1695442739&sprefix=Fertili%2Caps%2C620&sr=8-35");
            }
        });
        return view;
    }
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}