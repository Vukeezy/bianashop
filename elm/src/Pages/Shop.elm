module Pages.Shop exposing (..)
import Html exposing (..)
import Json.Decode exposing (Decoder, field, int, string)
import Debug exposing (toString)
import Http exposing (..)
import Models.Product as Product

type alias Model = 
  {
    products: List Product.Product
  }

type Msg = 
      GetProduct (Result Http.Error (List Product.Product))
    | GetShop

init: Model
init = 
    ({products = []})


update : Model -> List Product.Product -> Model
update model msg =
    {model | products = msg}
          

view: Model -> Html msg 
view _ = 
    div [][]


getAllProducts : Cmd Msg
getAllProducts = 
    Http.get {
        url = "",
        expect = Http.expectJson GetProduct productDecoder
    }

productDecoder : Decoder (List Product.Product)
productDecoder =
     Json.Decode.map8 Product.Product
    (Json.Decode.field "id" Json.Decode.int)
    (Json.Decode.field "itemCode" Json.Decode.string)
    (Json.Decode.field "name" Json.Decode.string)
    (Json.Decode.field "height" Json.Decode.int)
    (Json.Decode.field "price" Json.Decode.int)
    (Json.Decode.field "inStock" Json.Decode.int)
    (Json.Decode.field "pictures" (Json.Decode.list string))
    (Json.Decode.field "mainPicture" Json.Decode.string)
    |> Json.Decode.list
