module Route exposing (Route(..), fromUrl, replaceUrl, toListHref)

import Browser.Navigation as Nav
import Url exposing (Url)
import Url.Parser as Parser exposing ((</>), Parser, oneOf, s)
import Html exposing (text)
import Html.Attributes exposing (href)
import Bootstrap.Navbar exposing (Item)
import Bootstrap.Navbar as Navbar
import Html.Attributes exposing (style)




-- ROUTING


type Route = 
    HomeRoute 
    | ShopRoute
    | ContactRoute
    | AboutUsRoute




parser : Parser (Route -> a) a
parser =
    oneOf
        [ Parser.map HomeRoute Parser.top
        , Parser.map HomeRoute (s "home")
        , Parser.map ContactRoute (s "contact")
        , Parser.map ShopRoute (s "shop")
        , Parser.map AboutUsRoute (s "about-us")
        ]



-- PUBLIC HELPERS


toListHref : Route -> Item msg
toListHref targetRoute =
    Navbar.itemLink [ href (routeToString targetRoute), style "line-height" "80px", style "font-size" "large", style "margin-right" "10px" ]
                     [ text (routeToName targetRoute) ]
        


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
        HomeRoute ->
            "Početna"
        
        ShopRoute ->
            "Prodavnica"

        ContactRoute ->
            "Kontakt"

        AboutUsRoute -> 
            "Istorija"

routeToPieces : Route -> List String
routeToPieces page =
    case page of
        HomeRoute ->
            ["home"]

        ShopRoute ->
            ["shop"]

        ContactRoute -> 
            ["contact"]
        

        AboutUsRoute -> 
            ["about-us"]