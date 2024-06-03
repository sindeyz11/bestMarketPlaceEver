"use client"

import { Button } from "@/components/ui/button"
import { Counter } from "@/components/ui/counter"
import cartStore from "@/store/cart"
import { IProduct } from "@/types"
import { formatNumber } from "@/utils"
import { observer } from "mobx-react-lite"
import { useState } from "react"
import Modal from "./modal"

export const ProductCard = observer(
	({
		id,
		title,
		price,
		discountPrice,
		description,
		unit,
		availableQuantity,
		image = "./products/no-product.png",
		category = "Без категории",
	}: IProduct) => {
		const [quantity, setQuantity] = useState(1)
		const [isModalOpen, setIsModalOpen] = useState(false)

		const handleOpenModal = () => {
			setIsModalOpen(true)
		}

		const handleCloseModal = () => {
			setIsModalOpen(false)
		}

		return (
			<div className="group flex flex-col justify-center transition-all rounded-lg border border-transparent hover:border-black p-4 h-[30em] cursor-pointer">
				<Modal isOpen={isModalOpen} onClose={handleCloseModal}>
					<div className="flex flex-col gap-10">
						<div className="grid grid-cols-5 gap-10 items-start">
							<div className="col-span-2 ">
								<img
									src={image}
									alt={title}
									className="h-full w-full object-contain"
								/>
							</div>
							<div className="flex items-start justify-end col-span-3">
								<div className="flex flex-col gap-3 w-full">
									<h3 className="text-3xl font-semibold">{title}</h3>
									<div className="flex flex-col gap-1 font-medium leading-none">
										<div className="flex items-center gap-3">
											<span className="text-green-600 text-2xl font-bold">
												₽{formatNumber(price)}
											</span>
											<s className="text-secondary-text text-xl">
												₽{formatNumber(discountPrice)}
											</s>
										</div>
										<div className="flex items-center gap-2 text-secondary-text">
											<span>1{unit}</span>| {category}
										</div>
										<span className="text-secondary-text/80">
											{availableQuantity}
											{unit} в наличии
										</span>
									</div>
									{description}
								</div>
							</div>
						</div>
						<div className="grid grid-cols-5 gap-2 w-full">
							<div className="col-span-1">
								<Counter quantity={quantity} setQuantity={setQuantity} />
							</div>
							<div className="col-span-4">
								<Button
									size="small"
									onClick={() => {
										cartStore.addItem(id, quantity)
										handleCloseModal()
										setQuantity(1)
										console.log(quantity)
									}}
								>
									Добавить
								</Button>
							</div>
						</div>
					</div>
				</Modal>
				<div
					className="p-2 mx-auto flex justify-center items-center h-72 w-full"
					onClick={handleOpenModal}
				>
					<img
						src={image}
						alt={title}
						className="h-full w-full object-contain"
					/>
				</div>
				<span className="text-lg font-bold">{title}</span>
				<div className="flex items-center font-semibold gap-1.5">
					<span>1{unit}</span>
					<span className="group-hover:flex hidden">|</span>
					<span className="text-secondary-text group-hover:flex hidden">
						{availableQuantity}
						{unit} в наличии
					</span>
				</div>
				<div className="flex flex-col gap-2">
					<span className="text-xl group-hover:text-3xl transition-all text-green-600 font-bold ">
						₽{formatNumber(price)}
					</span>
					<div className="group-hover:hidden flex">
						<s className="text-xl text-secondary-text/50 font-bold">
							₽{formatNumber(discountPrice)}
						</s>
					</div>
					<div className="hidden group-hover:flex items-center gap-2">
						<Counter quantity={quantity} setQuantity={setQuantity} />
						<Button
							size="small"
							onClick={() => {
								cartStore.addItem(id, quantity)
								setQuantity(1)
							}}
						>
							Добавить
						</Button>
					</div>
				</div>
			</div>
		)
	}
)
