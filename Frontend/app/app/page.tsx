"use client"

import { Banner } from "@/components/layout/banner"
import { Carousel } from "@/components/layout/carousel"
import { Filter } from "@/components/layout/filter"
import { ProductCard } from "@/components/layout/product-card"
import { Select } from "@/components/ui/select"
import product from "@/store/product"
import { observer } from "mobx-react-lite"

const HomePage = observer(() => {
	const settings = {
		dots: true,
		infinite: true,
		speed: 500,
		slidesToShow: 1,
		slidesToScroll: 1,
	}
	const banners = [
		{
			title: "Помидоры",
			description: "Просто описание для помидоров",
			price: 200,
			discountPrice: 300,
      image: "./products/tomatoes.png"
		},
		{
			title: "Огурцы",
			description: "Просто описание для огурцоjfhjdhajhdgjkahjghagjhgakjslghdjklв",
			price: 2003,
			discountPrice: 3003,
      image: "./products/cucumbers.png"
		},
	]
	return (
		<div>
			<Carousel banners={banners} />
			<div className="px-20 py-12">
				<div className="flex items-center justify-between mb-6">
					<h3 className="text-2xl">Витрина магазина</h3>
					<span className="flex items-center gap-2 text-sm ">
						Сортировать по:
						<div className="w-48">
							<Select
								options={["Популярности", "Цене", "Алфавиту"]}
								size="small"
							/>
						</div>
					</span>
				</div>
				<div className="flex items-start gap-20">
					<Filter
						minPrice={123}
						maxPrice={6000}
						categories={[
							{ name: "Все категории", count: 500 },
							{ name: "Категория 1", count: 100 },
							{ name: "Помидоры", count: 150 },
							{ name: "Огурцы", count: 50 },
							{ name: "Категория 4", count: 200 },
						]}
					/>
					<div className="grid grid-cols-2 sm:grid-cols-3 xl:grid-cols-4 2xl:grid-cols-5 gap-5 w-full">
						{product.allProducts.map(product => (
							<ProductCard
								key={product.id}
								id={product.id}
								title={product.title}
								image={product.image || "./no-product.png"}
								price={product.price}
								discountPrice={product.discountPrice}
								unit={product.unit}
								availableQuantity={product.availableQuantity}
								description={product.description}
							/>
						))}
					</div>
				</div>
			</div>
		</div>
	)
})
export default HomePage
