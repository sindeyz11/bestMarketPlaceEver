export interface IProduct {
	id: number
	title: string
	price: number
	discountPrice: number
	description: string
	unit: string
	availableQuantity: number
	image: string
}

export interface IPickupPoint {
	code: string
	address: string
	manager: IUser
	income: number
}

export interface IUser {
	code: string
	name: string
	role: IUserRole
	redemptionSum: number
	redemptionPercentage: number
	discount: number
}

export type IPositionItem = IProduct

export type IBannerProduct = Omit<IProduct, "unit" | "availableQuantity">

export type IUserRole = "user" | "manager" | "admin" | "not-authorized"
