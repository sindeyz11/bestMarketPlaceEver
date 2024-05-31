import { BankCardIcon } from "@/components/icons/bank-card-icon"
import { CalendarIcon } from "@/components/icons/calendar-icon"
import { Field } from "@/components/ui/field"
import { useState } from "react"

interface paymentDataProps {
	cardNumberData: string
	cardDateData: string
	CVCData: string
}

export const PaymentData = ({
	cardNumberData,
	cardDateData,
	CVCData,
}: paymentDataProps) => {
	const hideCardNumber = (cardNumber: string) => {
		let string = cardNumber
		let sliced = cardNumber.slice(-4)
		let mask = String(sliced).padStart(string.length, "*")
		return mask
	}

	// TODO: переписать функцию скрытия <CVC></CVC>
	const hideCVC = (CVC: string) => {
		let string = CVC
		let mask = string.replace(new RegExp("\\d"), "*")
		return mask
	}

	const [cardNumber, setCardNumber] = useState<string>(
		hideCardNumber(cardNumberData) || ""
	)
	const [cardDate, setCardDate] = useState<string>(cardDateData || "")
	const [CVC, setCVC] = useState<string>(hideCVC(CVCData) || "")
	return (
		<div className="bg-white rounded-xl shadow-lg p-6 flex flex-col items-center justify-center gap-4">
			<h2 className="text-black font-semibold text-lg text-center">
				Платежное средство
			</h2>
			<form className="flex flex-col gap-2">
				<Field
					icon={<BankCardIcon />}
					placeholder="Номер банковской карты"
					value={cardNumber}
					onChange={e => setCardNumber(e.target.value)}
				/>
				<div className="grid grid-cols-2 gap-2">
					<Field
						icon={<CalendarIcon />}
						placeholder="Дата"
						value={cardDate}
						onChange={e => setCardDate(e.target.value)}
					/>
					<Field
						startContent="CVC"
						placeholder="Код безопасности"
						value={CVC}
						onChange={e => setCVC(e.target.value)}
					/>
				</div>
			</form>
		</div>
	)
}
