"use client"

import { IPositionItem } from "@/types"
import { useState } from "react"
import { BoxIcon } from "../icons/box-icon"
import { RubleIcon } from "../icons/ruble-icon"
import { RubleXPercentIcon } from "../icons/ruble-x-percent-icon"
import { TitleIcon } from "../icons/title-icon"
import { TrashIcon } from "../icons/trash-icon"
import { UnitIcon } from "../icons/unit-icon"
import { Button } from "../ui/button"
import { Field } from "../ui/field"

export const PositionItem = ({
	id,
	title,
	price,
	unit,
	discountPrice,
	availableQuantity,
	description,
	image,
}: IPositionItem) => {
	const [titleValue, setTitleValue] = useState(title || "")
	const [priceValue, setPriceValue] = useState(price.toString() || "")
	const [unitValue, setUnitValue] = useState(unit.toString() || "")
	const [discountPriceValue, setDiscountPrice] = useState(
		discountPrice.toString() || ""
	)
	const [availableQuantityValue, setAvailableQuantityValue] = useState(
		availableQuantity.toString() || ""
	)
	const [descriptionValue, setDescriptionValue] = useState(description || "")
	const [imageValue, setImageValue] = useState(image || "")
	return (
		<form className="flex flex-col gap-3 bg-[#F0F0F0] p-4 rounded-lg">
			<div className="grid grid-cols-3 gap-3">
				<div className="col-span-1 bg-field-bg rounded-xl">
					<img
						src={imageValue}
						alt=""
						className="h-full w-full object-contain"
					/>
				</div>
				<div className="col-span-2">
					<div className="flex flex-col gap-2">
						<Field
							color="white"
							icon={<TitleIcon className="h-4 w-4 text-secondary-text" />}
							placeholder="Название товара"
							value={titleValue}
							onChange={e => setTitleValue(e.target.value)}
						/>
						<div className="grid grid-cols-2 gap-2">
							<div className="flex flex-col gap-2">
								<Field
									color="white"
									icon={<RubleIcon className="h-4 w-4 text-secondary-text" />}
									placeholder="Цена"
									value={priceValue}
									onChange={e => setPriceValue(e.target.value)}
								/>
								<Field
									color="white"
									icon={
										<RubleXPercentIcon className="h-4 w-4 text-secondary-text" />
									}
									placeholder="250"
									value={discountPriceValue}
									onChange={e => setDiscountPrice(e.target.value)}
								/>
							</div>
							<div className="flex flex-col gap-2">
								<Field
									color="white"
									icon={<UnitIcon className="h-4 w-4 text-secondary-text" />}
									placeholder="кг"
									value={unitValue}
									onChange={e => setUnitValue(e.target.value)}
								/>
								<Field
									color="white"
									icon={<BoxIcon className="h-4 w-4 text-secondary-text" />}
									placeholder="Кол-во в налчии"
									value={availableQuantityValue}
									onChange={e => setAvailableQuantityValue(e.target.value)}
								/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div className="flex gap-1 w-full">
				<Field
					variant="textarea"
					placeholder="Описание"
					value={descriptionValue}
					onChange={e => setDescriptionValue(e.target.value)}
				/>
				<Button color="dark" variant="icon" icon={<TrashIcon />} />
			</div>
		</form>
	)
}
