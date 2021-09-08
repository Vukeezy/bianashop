export interface Product {
    id: number,
    itemCode: String,
    name: String,
    height: number,
    price: number,
    sale: Sale,
    inStock: number
    description: String,
    pictures: String[],
    mainPicture?: String
}   

export interface Sale {
    id: number,
    percent: number
}

export interface CartItem {
    id: number,
    amount: number
    product?: Product
}

export interface Cart {
    fullName: string,
    address: String,
    delievery: boolean,
    email: string,
    phoneNumber: string,
    items: CartItem[],
    finalPrice: number
}

export interface SortParams{
    type: String,
    param: String,
    items: Product[]
}   

export interface SearchParams{
    input: String;
}

export interface FilterParams{
    items: Product[],
    heightFrom: number,
    heightTo: number,
    priceFrom: number,
    priceTo:number
}