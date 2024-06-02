import { IProduct } from "@/types"
import { makeAutoObservable } from "mobx"
import authStore from "./auth"

class Product {
	allProducts: IProduct[] = authStore.productsAdmin

	constructor() {
		makeAutoObservable(this)
	}
	getProductById(id: number): IProduct | null {
		const product = this.allProducts.find(product => product.id === id)
		console.log("getProductById:", id, product)
		return product || null
	}
}

const productStore = new Product()
export default productStore
