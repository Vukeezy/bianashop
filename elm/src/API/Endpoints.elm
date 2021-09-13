module API.Endpoints exposing (..)
import Http exposing (..)
import Json.Decode exposing (Decoder, field, int, string)
import Models.Product exposing (Product)

-- fetching whole data needs to be here, not cross module

