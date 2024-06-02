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

export type IBannerProduct = Omit<IProduct, "id" | "unit" | "availableQuantity">
