package com.info2soft;

import java.util.Random;

public class Data2 {
    public static String getData(String key, String code, int market) {

        String s1 = "{\"mf\"" +
                ":{\"iAmtOfBuy\":[573029,443659,0,101,100],\n" +
                "\"iVolOfBuy\":[54500,42200,0,0],\n" +
                "\"iAmtOfSell\":[390152,0,525500,0],\n" +
                "\"iVolOfSell\":[37100,0,50000,0],\n" +
                "\"iNumOfSell\":[5,0,1,0],\n" +
                "\"iBuyNum\":[56,8,0,0]},\n" +
                "\"time\":2412251412,\n" +
                "\"code\":\"" + code + "\",\n" +
                "\"market\":" + market + "}";
        if (key == "rtmin") {
            return s1;
        }
        return -1 + "";
    }

    public static String getData(String key, String code, String setCode) {
        Random rand = new Random();

        String s2 = "{\"afterDealAmount\" : 10.0,\n" +
                "\"afterDealVol\" : 0.0,\n" +
                "\"amp\" : 0.0807,\n" +
                "\"avgPrice\" : 447.954,\n" +
                "\"bizTime\" : 20241225141240738,\n" +
                "\"boardDays\" : 0,\n" +
                "\"buy\" : 7154.0,\n" +
                "\"buyPrice1\" : 458.0,\n" +
                "\"buyPrice2\" : 457.13,\n" +
                "\"buyPrice3\" : 457.0,\n" +
                "\"buyPrice4\" : 456.81,\n" +
                "\"buyPrice5\" : 456.15,\n" +
                "\"buyVolumes1\" : "+rand.nextInt(10000)+",\n" +
                "\"buyVolumes2\" : 2.0,\n" +
                "\"buyVolumes3\" : 4.0,\n" +
                "\"buyVolumes4\" : 5.0,\n" +
                "\"buyVolumes5\" : 2.2,\n" +
                "\"category\" : 27,\n" +
                "\"changeRatio\" : 0.0269,\n" +
                "\"changeValue\" : 12.0,\n" +
                "\"changeValueBp\" : 0.0,\n" +
                "\"circulationMarketValue\" : 6.542554274E9,\n" +
                "\"circulationStocks\" : 1.4285053E7,\n" +
                "\"code\" : \"" + code + "\",\n" +
                "\"comparison\" : 0.4369,\n" +
                "\"contractPosition\" : 0.0,\n" +
                "\"conversionPremiumRate\" : 0.0,\n" +
                "\"conversionValue\" : 0.0,\n" +
                "\"currYearchangeRatio\" : 4.3343,\n" +
                "\"day10changeRatio\" : 0.4869,\n" +
                "\"day5changeRatio\" : 0.3921,\n" +
                "\"dealAmount\" : 6.37277492E8,\n" +
                "\"dealNum\" : 0,\n" +
                "\"dealVol\" : 14226.0,\n" +
                "\"dropNum\" : 0,\n" +
                "\"dropStopNum\" : 0,\n" +
                "\"entrustBuy\" : 74.0,\n" +
                "\"entrustDiff\" : 45.0,\n" +
                "\"entrustSell\" : 29.0,\n" +
                "\"flatNum\" : 0,\n" +
                "\"fundNetWorth\" : 40.49636604,\n" +
                "\"fundRtReferenceNetWorth\" : 0.0,\n" +
                "\"highPrice\" : 464.0,\n" +
                "\"incomePer10w\" : 0.0,\n" +
                "\"incomePer1k\" : 0.0,\n" +
                "\"incomeRatePerYear\" : 0.0,\n" +
                "\"isZT\" : 0,\n" +
                "\"latestChangeValue\" : 1.19,\n" +
                "\"limitDownPrc\" : 356.8,\n" +
                "\"limitUpPrc\" : 535.2,\n" +
                "\"lowPrice\" : 428.0,\n" +
                "\"lowerLimitPrice\" : 0.0,\n" +
                "\"month1changeRatio\" : 0.5374,\n" +
                "\"month3changeRatio\" : 1.1233,\n" +
                "\"name\" : \"达梦数据\",\n" +
                "\"netIn\" : -1.2413485E7,\n" +
                "\"netIn10\" : 4180574.0,\n" +
                "\"netIn20\" : -4.6625146E7,\n" +
                "\"netIn3\" : -3.235385E7,\n" +
                "\"netIn5\" : -1.9579525E7,\n" +
                "\"netRatio\" : -0.0195,\n" +
                "\"netRatio10\" : 8.0E-4,\n" +
                "\"netRatio20\" : -0.0057,\n" +
                "\"netRatio3\" : -0.0171,\n" +
                "\"netRatio5\" : -0.0072,\n" +
                "\"norminalPrice\" : 0.0,\n" +
                "\"nowPrice\" : 458.0,\n" +
                "\"numTrades\" : 0,\n" +
                "\"openPrice\" : 434.26,\n" +
                "\"ordImbDirection\" : 0,\n" +
                "\"ordImbQty\" : 0,\n" +
                "\"ordbPrice\" : 0.0,\n" +
                "\"ordbQty\" : 0,\n" +
                "\"origDealVol\" : 1422640.0,\n" +
                "\"pbRatio\" : 11.31,\n" +
                "\"peRatio\" : 149.72,\n" +
                "\"peRatioStatic\" : 117.56,\n" +
                "\"peRatioTTM\" : 98.82,\n" +
                "\"posLowerLimitAskPrice\" : 0.0,\n" +
                "\"posLowerLimitBidPrice\" : 0.0,\n" +
                "\"posUpperLimitAskPrice\" : 0.0,\n" +
                "\"posUpperLimitBidPrice\" : 0.0,\n" +
                "\"preWeightedPx\" : 0.0,\n" +
                "\"premiumRate\" : 0.0,\n" +
                "\"priceChangeFlag\" : 1,\n" +
                "\"qrr\" : 1.138,\n" +
                "\"redeemPrice\" : 0.0,\n" +
                "\"refPrice\" : 0.0,\n" +
                "\"riseNum\" : 0,\n" +
                "\"riseStopNum\" : 0,\n" +
                "\"sell\" : 7009.0,\n" +
                "\"sellPrice1\" : 458.03,\n" +
                "\"sellPrice2\" : 458.2,\n" +
                "\"sellPrice3\" : 459.94,\n" +
                "\"sellPrice4\" : 459.97,\n" +
                "\"sellPrice5\" : 460.0,\n" +
                "\"sellVolumes1\" : 3.0,\n" +
                "\"sellVolumes2\" : 14.0,\n" +
                "\"sellVolumes3\" : 2.0,\n" +
                "\"sellVolumes4\" : 1.0,\n" +
                "\"sellVolumes5\" : 9.0,\n" +
                "\"setCode\" : \"" + setCode + "\",\n" +
                "\"shareWarrantPremiumRate\" : 0.0,\n" +
                "\"speedUp\" : 0.0044,\n" +
                "\"subCategory\" : 0,\n" +
                "\"summaryBuyPrice\" : 0.0,\n" +
                "\"summarySellPrice\" : 0.0,\n" +
                "\"timestamp4Day\" : 0,\n" +
                "\"totalChangeRatio\" : 0.0269,\n" +
                "\"totalMarketValue\" : 3.4808E10,\n" +
                "\"totalStocks\" : 7.6E7,\n" +
                "\"tradeDate\" : 20241111,\n" +
                "\"tradeStatus\" : 1,\n" +
                "\"tradeTime\" : 153013,\n" +
                "\"turnoverRate\" : 0.0996,\n" +
                "\"upperLimitPrice\" : 0.0,\n" +
                "\"week52HighPrice\" : 464.4,\n" +
                "\"week52LowPrice\" : 188.93,\n" +
                "\"weightedAvgBp\" : 0.0,\n" +
                "\"weightedAvgPx\" : 0.0,\n" +
                "\"yclosePrice\" : 446.0,\n" +
                "\"year1changeRatio\" : 4.3343\n" +
                "  }\n";
        if (key == "realtime") {
            return s2;
        }
        return -1 + "";
    }
}
