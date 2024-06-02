import { IBannerProduct } from "@/types"
import { useEffect, useState } from "react"
import { Banner } from "./banner"

interface CarouselProps {
	banners: IBannerProduct[]
}

export const Carousel = ({ banners }: CarouselProps) => {
	const [currentIndex, setCurrentIndex] = useState(0)

	useEffect(() => {
		const interval = setInterval(() => {
			setCurrentIndex(prevIndex => (prevIndex + 1) % banners.length)
		}, 10000)

		return () => clearInterval(interval)
	}, [banners.length])

	return (
		<div className="relative w-full h-[25em] overflow-hidden">
			<img
				src="/under-banner.png"
				alt="Under Banner"
				className="h-full w-full absolute"
			/>
			{banners.map((banner, index) => (
				<div
					key={index}
					className={`absolute w-full h-full transition-opacity duration-1000 ${index === currentIndex ? "opacity-100" : "opacity-0"}`}
				>
					<Banner
						title={banner.title}
						description={banner.description}
						price={banner.price}
						discountPrice={banner.discountPrice}
						image={banner.image}
					/>
				</div>
			))}
		</div>
	)
}
