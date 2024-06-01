import { IProduct } from "@/types"
import { makeAutoObservable } from "mobx"

class Cart {
	items: (IProduct & { quantity: number })[] = []

	constructor() {
		makeAutoObservable(this)
	}

	addItem(item: IProduct, quantity: number = 1) {
		const existingItem = this.items.find(existing => existing.id === item.id)
		if (existingItem) {
			existingItem.quantity + quantity
		} else {
			this.items.push({ ...item, quantity  })
		}
	}

	removeItem(id: number) {
		this.items = this.items.filter(item => item.id !== id)
	}

	clearCart() {
		this.items = []
	}

	increaseQuantity(id: number) {
		const item = this.items.find(item => item.id === id)
		if (item && item.quantity < item.availableQuantity) {
			item.quantity++
		}
	}

	decreaseQuantity(id: number) {
		const item = this.items.find(item => item.id === id)
		if (item && item.quantity > 1) {
			item.quantity--
		} else {
			this.removeItem(id)
		}
	}

	getTotalItems() {
		return this.items.reduce((acc, item) => acc + item.quantity, 0)
	}

	getTotalPrice() {
		return this.items.reduce((acc, item) => acc + item.price * item.quantity, 0)
	}
}

const cartStore = new Cart()
export default cartStore
