import { IBannerProduct } from "@/types"
import { formatNumber } from "@/utils"
import { observer } from "mobx-react-lite"
import Link from "next/link"
import { Button } from '../ui/button'

export const Banner = observer(
	({ id, title, description, price, discountPrice, image }: IBannerProduct) => {
		return (
			<div className="absolute top-10 left-20 bottom-10 right-20 z-90 bg-white rounded-xl flex items-center justify-between px-20">
				<div className="flex items-start gap-10">
					<div className="flex flex-col gap-2">
						<h1 className="text-black font-bold uppercase text-5xl">{title}</h1>
						<p className="text-secondary-text w-80 overflow-hidden text-ellipsis line-clamp-3">
							{description}
						</p>
						<span className="w-[12em]">
							<Link href="/#products">
								<Button>Перейти к товарам</Button>
							</Link>
						</span>
					</div>
					<div className="1.5xl:flex flex-col gap-2 hidden mr-[10em]">
						<div className="relative">
							<h3 className="text-3xl text-green-600 font-bold text-end">
								₽{formatNumber(price)}
							</h3>
							<s className="absolute text-xl font-semibold text-secondary-text -top-4 -right-16">
								₽{formatNumber(discountPrice)}
							</s>
						</div>
						<span className="text-base text-end font-bold text-secondary-text w-[10em] uppercase leading-none">
							Ограниченное предложение
						</span>
					</div>
				</div>
				<img src={image} className="h-[20em]" alt="Product" />
			</div>
		)
	}
)
