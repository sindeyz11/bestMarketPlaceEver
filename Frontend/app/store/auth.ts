import { IPickupPoint, IPositionItem, IUserRole } from "@/types"
import { makeAutoObservable } from "mobx"

class Auth {
	role: IUserRole = "user"

	productsAdmin: IPositionItem[] = [
		{
			id: 1,
			title: "Помидоры",
			price: 100,
			discountPrice: 120,
			description:
				"Свежие сочные помидоры, выращенные в Краснодарском крае. Идеально подходят для салатов и приготовления различных блюд.",
			unit: "кг",
			availableQuantity: 10,
			image: "./products/tomatoes.png",
			category: "Овощи"
		},
		{
			id: 2,
			title: "Огурцы",
			price: 80,
			discountPrice: 100,
			description:
				"Хрустящие и ароматные огурцы, собранные с местных ферм. Отличный выбор для салатов и закусок.",
			unit: "кг",
			availableQuantity: 30,
			image: "./products/cucumbers.png",
			category: "Овощи"
		},
		{
			id: 3,
			title: "Груши",
			price: 150,
			discountPrice: 180,
			description:
				"Сладкие и сочные груши, идеально подходящие для десертов и перекусов. Произведены в Краснодарском крае.",
			unit: "кг",
			availableQuantity: 30,
			image: "./products/pears.png",
			category: "Фрукты"
		},
		{
			id: 4,
			title: "Яблоки",
			price: 120,
			discountPrice: 140,
			description:
				"Свежие и хрустящие яблоки различных сортов, выращенные в садах Краснодарского края. Полезный и вкусный перекус.",
			unit: "кг",
			availableQuantity: 30,
			image: "./products/apples.png",
			category: "Фрукты"
		},
		{
			id: 5,
			title: "Апельсины",
			price: 200,
			discountPrice: 230,
			description:
				"Сочные и ароматные апельсины, привезенные из теплых регионов. Отличный источник витамина C.",
			unit: "кг",
			availableQuantity: 30,
			image: "./products/oranges.png",
			category: "Фрукты"
		},
		{
			id: 6,
			title: "Манго",
			price: 250,
			discountPrice: 300,
			description:
				"Экзотические манго с сочной мякотью и неповторимым вкусом. Прекрасно подходят для смузи и фруктовых салатов.",
			unit: "кг",
			availableQuantity: 30,
			image: "./products/mangoes.png",
			category: "Фрукты"
		},
		{
			id: 7,
			title: "Киви",
			price: 180,
			discountPrice: 210,
			description:
				"Освежающие киви с ярким вкусом и высоким содержанием витамина C. Идеально подходят для десертов и перекусов.",
			unit: "кг",
			availableQuantity: 30,
			image: "./products/kiwis.png",
			category: "Фрукты"
		},
	]

	pickupPoints: IPickupPoint[] = [
		{
			code: "000-001",
			address: "г. Краснодар, улица Ставропольская 149",
			income: 50000,
			manager: {
				code: "MG-001",
				name: "Менеджер Имя",
				role: "manager",
				redemptionPercentage: 0,
				redemptionSum: 0,
				discount: 14,
			},
		},
	]

	constructor() {
		makeAutoObservable(this)
	}

	setUserRole(newRole: IUserRole) {
		this.role = newRole
	}

	removePickupPoint(code: string) {
		this.pickupPoints = this.pickupPoints.filter(
			pickupPoint => pickupPoint.code !== code
		)
	}
}

const authStore = new Auth()
export default authStore
