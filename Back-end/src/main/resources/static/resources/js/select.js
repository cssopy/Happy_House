const sido = document.getElementById('sido');
const gugun = document.getElementById('gugun');
const dong = document.getElementById('dong');

sido.addEventListener('change', () => {
	while(gugun.lastChild) {
		gugun.removeChild(gugun.lastChild);
	}
	let selected = window.document.createElement('option');
	selected.innerText = '구/군을 선택하세요.';
	gugun.append(selected);
	
	if(sido.value === '서울특별시') {
		let newGu1 = window.document.createElement('option');
		newGu1.innerText = '강남구';
		gugun.append(newGu1);
		
		let newGu2 = window.document.createElement('option');
		newGu2.innerText = '송파구';
		gugun.append(newGu2);
	}
});

gugun.addEventListener('change', () => {
	while(dong.lastChild) {
		dong.removeChild(dong.lastChild);
	}
	let selected = window.document.createElement('option');
	selected.innerText = '동을 선택해 주세요.';
	dong.append(selected);
	
	if(gugun.value === '강남구') {
		let newDong1 = window.document.createElement('option');
		newDong1.innerText = '개포동';
		dong.append(newDong1);
		
		let newDong2 = window.document.createElement('option');
		newDong2.innerText = '논현동';
		dong.append(newDong2);
		
		let newDong3 = window.document.createElement('option');
		newDong3.innerText = '대치동';
		dong.append(newDong3);
		
		let newDong4 = window.document.createElement('option');
		newDong4.innerText = '도곡동';
		dong.append(newDong4);
		
		let newDong5 = window.document.createElement('option');
		newDong5.innerText = '마천동';
		dong.append(newDong5);
		
		let newDong6 = window.document.createElement('option');
		newDong6.innerText = '삼성동';
		dong.append(newDong6);
		
		let newDong7 = window.document.createElement('option');
		newDong7.innerText = '수서동';
		dong.append(newDong7);
		
		let newDong8 = window.document.createElement('option');
		newDong8.innerText = '신사동';
		dong.append(newDong8);
		
		let newDong9 = window.document.createElement('option');
		newDong9.innerText = '압구정동';
		dong.append(newDong9);
		
		let newDong10 = window.document.createElement('option');
		newDong10.innerText = '역삼동';
		dong.append(newDong10);
		
		let newDong11 = window.document.createElement('option');
		newDong11.innerText = '일원동';
		dong.append(newDong11);
		
		let newDong12 = window.document.createElement('option');
		newDong12.innerText = '자곡동';
		dong.append(newDong12);
		
		let newDong13 = window.document.createElement('option');
		newDong13.innerText = '청담동';
		dong.append(newDong13);
	} else if(gugun.value === '송파구') {
		let newDong1 = window.document.createElement('option');
		newDong1.innerText = '가락동';
		dong.append(newDong1);

		let newDong2 = window.document.createElement('option');
		newDong2.innerText = '거여동';
		dong.append(newDong2);

		let newDong3 = window.document.createElement('option');
		newDong3.innerText = '문정동';
		dong.append(newDong3);

		let newDong4 = window.document.createElement('option');
		newDong4.innerText = '방이동';
		dong.append(newDong4);

		let newDong5 = window.document.createElement('option');
		newDong5.innerText = '석촌동';
		dong.append(newDong5);

		let newDong6 = window.document.createElement('option');
		newDong6.innerText = '송파동';
		dong.append(newDong6);

		let newDong7 = window.document.createElement('option');
		newDong7.innerText = '신천동';
		dong.append(newDong7);

		let newDong8 = window.document.createElement('option');
		newDong8.innerText = '오금동';
		dong.append(newDong8);

		let newDong9 = window.document.createElement('option');
		newDong9.innerText = '잠실동';
		dong.append(newDong9);

		let newDong10 = window.document.createElement('option');
		newDong10.innerText = '장지동';
		dong.append(newDong10);

		let newDong11 = window.document.createElement('option');
		newDong11.innerText = '풍납동';
		dong.append(newDong11);
	}
});