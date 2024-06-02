import { Button } from "@/components/ui/button"
import { IBannerProduct } from "@/types"

export const Banner = ({
	title,
	description,
	price,
	discountPrice,
	image,
}: IBannerProduct) => {
	return (
		<>
			<div className="absolute top-10 left-20 bottom-10 right-20 z-90 bg-white rounded-xl flex items-center justify-between px-20">
				<div className="flex items-start gap-10">
					<div className="flex flex-col gap-2">
						<h1 className="text-black font-bold uppercase text-5xl">{title}</h1>
						<p className="text-secondary-text w-1/2">{description}</p>
						<span className="w-[10em]">
							<Button>Купить</Button>
						</span>
					</div>
					<div className="2xl:flex flex-col gap-2 hidden mr-[10em]">
						<div className="relative">
							<h3 className="text-3xl text-green-600 font-bold">₽{price}</h3>
							<s className="absolute text-xl font-semibold text-secondary-text -top-4 -right-16">
								₽{discountPrice}
							</s>
						</div>
						<span className="text-base font-bold text-secondary-text w-[10em] uppercase leading-none">
							Ограниченное предложение
						</span>
					</div>
				</div>
				<img src={image} className="h-[20em]" alt="Product" />
			</div>
		</>
	)
}
