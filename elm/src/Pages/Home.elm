module Pages.Home exposing (..)
import Html exposing (..)

type alias Model = {}

view: { title : String, content : Html msg }
view = 
    { title = "WebShop",
    content = 
        div [] [text "hello"] }