import { IProduct } from "@/types"
import { makeAutoObservable } from "mobx"

interface IProductWithQuantity extends IProduct {
	quantity: number
}

class Product {
	allProducts: IProduct[] = [
		{
			id: 1,
			title: "Помидоры",
			price: 200,
			discountPrice: 300,
			description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras et magna ut lectus condimentum pharetra non at lectus. Donec consequat arcu justo, vitae facilisis eros bibendum ac. Nulla blandit, lacus euismod gravida ullamcorper, justo diam tristique magna, sit amet laoreet mauris nunc in leo. Nam mi mi, congue sed aliquam eu, feugiat et leo. Suspendisse potenti. Aenean faucibus egestas purus, at vehicula nisi. Donec nec mattis purus. Quisque arcu metus, congue id venenatis in, congue id lorem. Vivamus hendrerit justo facilisis lacus pretium, vitae fringilla sem fermentum. Ut lobortis erat vel ligula viverra, pretium ultricies eros facilisis. Ut consectetur nisl eget erat pharetra, in viverra nibh convallis.",
			unit: "кг",
			availableQuantity: 10,
			image: "./products/tomatoes.png",
		},
		{
			id: 2,
			title: "Огурцы",
			price: 150,
			discountPrice: 200,
			description:
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras et magna ut lectus condimentum pharetra non at lectus. Donec consequat arcu justo, vitae facilisis eros bibendum ac. Nulla blandit, lacus euismod gravida ullamcorper, justo diam tristique magna, sit amet laoreet mauris nunc in leo. Nam mi mi, congue sed aliquam eu, feugiat et leo. Suspendisse potenti. Aenean faucibus egestas purus, at vehicula nisi. Donec nec mattis purus. Quisque arcu metus, congue id venenatis in, congue id lorem. Vivamus hendrerit justo facilisis lacus pretium, vitae fringilla sem fermentum. Ut lobortis erat vel ligula viverra, pretium ultricies eros facilisis. Ut consectetur nisl eget erat pharetra, in viverra nibh convallis.",
			unit: "кг",
			availableQuantity: 30,
			image: "./products/cucumbers.png",
		},
	]
	constructor() {
		makeAutoObservable(this)
	}
}

export default new Product()
