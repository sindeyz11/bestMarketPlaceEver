"use client"

import cartStore from "@/store/cart"
import { observer } from "mobx-react-lite"

interface CartItemCounterProps {
	id: number
	quantity?: number
	availableQuantity: number
}

export const CartItemCounter = observer(
	({ id, quantity = 1, availableQuantity }: CartItemCounterProps) => {
		return (
			<div className="flex items-center p-0.5 w-[5.5em] justify-center border border-black rounded-lg outline-none h-full">
				<button
					onClick={() =>
						quantity > 1
							? cartStore.decreaseQuantity(id)
							: cartStore.removeItem(id)
					}
					className="font-semibold text-secondary-text text-xl px-1"
				>
					-
				</button>
				<span className="px-2">{quantity}</span>
				<button
					onClick={() =>
						quantity <= availableQuantity && cartStore.increaseQuantity(id)
					}
					className="font-semibold text-secondary-text text-xl px-1"
				>
					+
				</button>
			</div>
		)
	}
)
