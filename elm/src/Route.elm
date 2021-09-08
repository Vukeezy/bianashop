module Route exposing (Route(..), fromUrl, replaceUrl, toListHref)

import Browser.Navigation as Nav
import Url exposing (Url)
import Url.Parser as Parser exposing ((</>), Parser, oneOf, s)
import Html exposing (Html)
import Html exposing (li)
import Html exposing (a)
import Html exposing (text)
import Html.Attributes exposing (href)



-- ROUTING


type Route
    = Home | Other



parser : Parser (Route -> a) a
parser =
    oneOf
        [ Parser.map Other Parser.top
        , Parser.map Home (s "home")
        ]



-- PUBLIC HELPERS


toListHref : Route -> Html msg
toListHref targetRoute =
    li [] [ a [ href (routeToString targetRoute) ] [ text (routeToName targetRoute) ] ]



replaceUrl : Nav.Key -> Route -> Cmd msg
replaceUrl key route =
    Nav.replaceUrl key (routeToString route)


fromUrl : Url -> Maybe Route
fromUrl url =
    -- The RealWorld spec treats the fragment like a path.
    -- This makes it *literally* the path, so we can proceed
    -- with parsing as if it had been a normal path all along.
    { url | path = Maybe.withDefault "" url.fragment, fragment = Nothing }
        |> Parser.parse parser



-- INTERNAL


routeToString : Route -> String
routeToString page =
    "#/" ++ String.join "/" (routeToPieces page)


routeToName : Route -> String
routeToName route =
    case route of 
        Home ->
            "Home"
        
        Other ->
            "Nothing"

routeToPieces : Route -> List String
routeToPieces page =
    case page of
        Home ->
            ["home"]

        Other ->
            []