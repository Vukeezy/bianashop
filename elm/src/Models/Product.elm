module Models.Product exposing (..)

type alias Product = 
    {   id: Int,
        itemCode: String,
        name: String,
        height: Int,
        price: Int,
        inStock: Int,
        pictures: List String, 
        mainPicture: String
    }   

