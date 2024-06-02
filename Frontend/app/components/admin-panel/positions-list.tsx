import { IPositionItem } from "@/types"
import { Button } from "../ui/button"
import { PositionItem } from "./position-item"

interface PositionsListProps {
	positions: IPositionItem[]
}

export const PositionsList = ({ positions }: PositionsListProps) => {
	return (
		<div className="bg-white shadow-lg rounded-xl p-6 ">
			<h2 className="text-black font-semibold text-lg mb-2">Позиции</h2>
			{positions.length ? (
				<div className="flex flex-col gap-4">
					<div className="flex flex-col h-[500px] overflow-y-auto rounded-xl gap-3">
						{positions.map(position => (
							<PositionItem
								key={position.id}
								id={position.id}
								title={position.title}
								price={position.price}
								discountPrice={position.discountPrice}
								unit={position.unit}
								availableQuantity={position.availableQuantity}
								description={position.description}
								image={position.image}
							/>
						))}
					</div>
					<Button>Добавить</Button>
				</div>
			) : (
				<div className="flex flex-col  min-h-[calc(100%-30px)]">
					<div className="grow flex items-center justify-center">
						<p className="text-black/40">Позиции отсутствуют</p>
					</div>
					<Button>Добавить</Button>
				</div>
			)}
		</div>
	)
}
