package com.edu.escuelaing;

import static spark.Spark.*;

public class SparkWebServer {
    
    public static void main(String... args){
        staticFiles.location("/public");
        port(getPort());
        get("sin", (req,res) -> {
            return "" + Math.sin(Double.parseDouble(req.queryParams("number")));
        });
        get("cos", (req,res) -> {
            return "" + Math.cos(Double.parseDouble(req.queryParams("number")));
        });
        get("pal", (req,res) -> {
            String[] lst = req.queryParams("word").split(""); 
            String ans = "";
            for(int i = (lst.length - 1); i >= 0; i--){
                ans += lst[i];
            }
            if(ans.equals(req.queryParams("word"))){
                return "Is palindrome";
            }
            return "Is not palindrome";
        });
        get("vector", (req,res) -> {
            Double xPow = Math.pow(Double.parseDouble(req.queryParams("x")), 2);
            Double yPow = Math.pow(Double.parseDouble(req.queryParams("y")), 2);
            Double sqrt = Math.sqrt(xPow + yPow);
            return "" + sqrt; 
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
    
}
