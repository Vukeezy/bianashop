module Main exposing (..)

import Browser
import Browser.Navigation as Nav
import Html exposing (..)
import Html.Attributes exposing (..)
import Url
import Route exposing (toListHref)
import Route exposing (Route(..))
import Route exposing (fromUrl)
import Bootstrap.Navbar as Navbar
import Bootstrap.Card as Card
import Bootstrap.Card.Block as Block
import Bootstrap.Utilities.Spacing as Spacing
import Bootstrap.Button as Button
import Color
import Pages.Home as Home
import Models.Product as Product
import Http
import Json.Decode exposing (Decoder, string)


-- MAIN


main : Program () Model Msg
main =
  Browser.application
    { init = init
    , view = view
    , update = update
    , subscriptions = subscriptions
    , onUrlChange = UrlChanged
    , onUrlRequest = LinkClicked
    }

type alias ShopModel = 
  {
    products: List Product.Product
  }

type PageModel = 
      Home Home.Model
    | Shop ShopModel

type alias Model =
  { key : Nav.Key
  , url : Url.Url
  , navbarState: Navbar.State
  , page: PageModel
  }

init : () -> Url.Url -> Nav.Key -> ( Model, Cmd Msg )
init _ url key =
    let
        ( navbarState, navbarCmd ) =
            Navbar.initialState NavbarMsg

    in
        ( Model key url navbarState (Home {}), navbarCmd )
        
shopInit: ShopModel
shopInit = 
    ({products = []})

getProductView: Product.Product -> Card.Config msg
getProductView product = 
    Card.config [ Card.attrs [ style "width" "20rem" ] ]
    |> Card.header [ class "text-center" ]
        [ img [ src product.mainPicture,style "width" "280px" ] [ ]
        , h3 [ Spacing.mt2 ] [ text product.name ]
        ]
    |> Card.block []
        [ Block.titleH4 [] [ text "Zavesa"]
        , Block.text [] [ text ("Cena: " ++ String.fromInt product.price ++ ",00rsd") ]
        , Block.custom <|
            Button.button [ Button.primary ] [ text "Kupi" ]
        ]
    
    


type Msg
  = LinkClicked Browser.UrlRequest
  | UrlChanged Url.Url
  | NavbarMsg Navbar.State
  | GetProduct (Result Http.Error (List Product.Product))
  | GetShop
  
type PageMsg
  = GotHomePage Home.Msg
  | GotShopPage Msg
  | Other

getShopModel: List Product.Product -> ShopModel
getShopModel list =
    {products = list}

update : Msg -> Model -> ( Model, Cmd Msg )
update msg model =
  case msg of
    LinkClicked urlRequest ->
      case urlRequest of
        Browser.Internal url ->
          let
            _ = sendPageMsg (fromUrl url)
          in
          
          ( model, Nav.pushUrl model.key (Url.toString url) )

        Browser.External href ->
          ( model, Nav.load href )

    UrlChanged url ->
      let

        (page, callback) = case sendPageMsg (fromUrl url) of 
          GotHomePage _ ->
              (Home {}, Cmd.none)

          GotShopPage content ->
              (Shop (shopInit), getAllProducts)

          Other ->
              (Home {}, Cmd.none)        
      in
        ( { model | url = url, page = page }
        , callback
        )

    NavbarMsg state ->
            ( { model | navbarState = state }, Cmd.none )

    GetProduct result ->
          case result of 
            Ok list ->
              ({model | page = Shop (getShopModel list)}, Cmd.none)
            Err _ ->
              (model, Cmd.none)


    GetShop ->
      (model, Cmd.none)

-- SUBSCRIPTIONS


subscriptions : Model -> Sub Msg
subscriptions _ =
  Sub.none



-- VIEW
sendPageMsg : Maybe Route -> PageMsg
sendPageMsg route =
    case route of
      Just HomeRoute -> 
        GotHomePage Home.LoadHome

      Just ShopRoute ->
        GotShopPage GetShop

      Just ContactRoute ->
        Other
    
      Just AboutUsRoute ->
        Other

      Nothing -> 
        Other


view : Model -> Browser.Document Msg
view model =
  { title = "URL Interceptor"
  , body = 
      [ 
        Navbar.config NavbarMsg
        |> Navbar.withAnimation
        |> Navbar.darkCustom (Color.rgb255 24 28 36)
        |> Navbar.brand [ href "#", style "padding-left" "10%", style "padding-right" "50%" ] 
                        [ img
                        [ src "../assets/LogoBiana.png"
                        , class "d-inline-block align-top"
                        , style "height" "90px" 
                        ]
                        []
            ]
        |> Navbar.items
            [ toListHref HomeRoute
            , toListHref AboutUsRoute
            , toListHref ShopRoute
            , toListHref ContactRoute
            ]
        |> Navbar.view model.navbarState,
          case model.page of 
            Home home ->
              Home.view home
            Shop shop ->
              div [style "padding-left" "30%", style "padding-top" "2%"] [ 
                 div [] [h2 [style "font-weight" "bold", style "text-decoration" "underline"] [text "Zavese"]],
                 Card.columns (List.map getProductView shop.products)]

      ]
  }

getAllProducts : Cmd Msg
getAllProducts = 
    Http.get {
        url = "http://localhost:8080/api/items",
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
