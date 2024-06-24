import { IBannerProduct } from "@/types";
import { observer } from "mobx-react-lite";
import { useEffect, useState } from "react";
import { Banner } from "./banner";

interface CarouselProps {
  banners: IBannerProduct[];
}

export const Carousel = observer(({ banners }: CarouselProps) => {
  const [currentIndex, setCurrentIndex] = useState(0);

  useEffect(() => {
    const interval = setInterval(() => {
      setCurrentIndex((prevIndex) => (prevIndex + 1) % banners.length);
    }, 6000);

    return () => clearInterval(interval);
  }, [banners.length]);

  if (banners.length === 0) {
    return <div>No banners available</div>;
  }

  return (
    <div className="relative h-[25em] w-full overflow-hidden">
      <img
        src="/under-banner.png"
        alt="Under Banner"
        className="absolute h-full w-full object-cover"
      />
      {banners.map((banner, index) => {
        return (
          <div
            key={banner.id}
            className={`absolute h-full w-full transition-opacity duration-1000 ${index === currentIndex ? "opacity-100" : "opacity-0"}`}
          >
            <Banner
              id={banner.id}
              title={banner.title}
              description={banner.description}
              price={banner.price}
              discountPrice={banner.discountPrice}
              image={banner.image}
            />
          </div>
        );
      })}
    </div>
  );
});
