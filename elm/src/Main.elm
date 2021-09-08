module Main exposing (..)

import Browser
import Browser.Navigation as Nav
import Html exposing (..)
import Html.Attributes exposing (..)
import Url
import Route exposing (toListHref)
import Route exposing (Route(..))
import Pages.Home exposing (..)
import Route exposing (fromUrl)
import Bootstrap.Navbar as Navbar




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




type alias Model =
  { key : Nav.Key
  , url : Url.Url
  , navbarState: Navbar.State
  }


init : () -> Url.Url -> Nav.Key -> ( Model, Cmd Msg )
init _ url key =
    let
        ( navbarState, navbarCmd ) =
            Navbar.initialState NavbarMsg
    in
        ( Model key url navbarState, navbarCmd )



-- UPDATE


type Msg
  = LinkClicked Browser.UrlRequest
  | UrlChanged Url.Url
  | NavbarMsg Navbar.State


update : Msg -> Model -> ( Model, Cmd Msg )
update msg model =
  case msg of
    LinkClicked urlRequest ->
      case urlRequest of
        Browser.Internal url ->
          ( model, Nav.pushUrl model.key (Url.toString url) )

        Browser.External href ->
          ( model, Nav.load href )

    UrlChanged url ->
      ( { model | url = url }
      , Cmd.none
      )

    NavbarMsg state ->
            ( { model | navbarState = state }, Cmd.none )



-- SUBSCRIPTIONS


subscriptions : Model -> Sub Msg
subscriptions _ =
  Sub.none



-- VIEW
getPageContent : Maybe Route -> Html msg
getPageContent route =
    case route of
      Just Home -> 
        Pages.Home.view.content

      Just Other ->
        div [] []

      Nothing -> 
        div [] []


view : Model -> Browser.Document Msg
view model =
  { title = "URL Interceptor"
  , body = 
      [ 
        Navbar.config NavbarMsg
        |> Navbar.withAnimation
        |> Navbar.success
        |> Navbar.brand [ href "#" ] [ text "Brand" ]
        |> Navbar.items
            [ Navbar.itemLink [ href "#" ] [ text "Item 1" ]
            , Navbar.itemLink [ href "#" ] [ text "Item 2" ]
            ]
        |> Navbar.view model.navbarState,
        getPageContent (fromUrl model.url)
      , ul []
          [ toListHref Home
          , toListHref Other
          ]
      ]
  }

