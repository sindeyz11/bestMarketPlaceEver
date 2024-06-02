import authStore from '@/store/auth'
import { PickupPointItem } from './pickup-point-item'

export const PickupPointsList = () => {
	return (
		<div className="bg-white shadow-lg rounded-xl p-6 ">
			<h2 className="text-black font-semibold text-lg mb-2">Пункты выдачи</h2>
			{authStore.pickupPoints.map(pickupPoint => (
				<PickupPointItem code={pickupPoint.code} address={pickupPoint.address} manager={pickupPoint.manager}  income={pickupPoint.income}/>
			))}
		</div>
	)
}
