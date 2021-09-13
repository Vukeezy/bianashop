module Pages.Home exposing (..)
import Html exposing (..)
import Html.Attributes exposing (class)
import Html.Attributes exposing (style)

view: Model -> Html msg
view _ = 
        div [ class "bg"] [ 
            div [ class "row", style "padding-top" "10%"] [
                div [ class "col-4 m-3"] [],
                    div [ class "col-7"][
                        h1 [ style "color" "white"] [text "Savršen izbor za Vaš dom!"]
                    ]
            ]
        ]
        

type Msg = 
    LoadHome

type alias Model = 
  {

  } 

