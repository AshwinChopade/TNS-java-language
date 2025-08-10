// Dice faces
const diceFaces = ["⚀","⚁","⚂","⚃","⚄","⚅"];

let score1 = 0,
    score2 = 0;

const winScore = 5;

const diceDiv1 = document.getElementById('dice1');
const diceDiv2 = document.getElementById('dice2');
const scoreDiv1 = document.getElementById('score1');
const scoreDiv2 = document.getElementById('score2');
const msgDiv = document.getElementById('message');
const rollBtn = document.getElementById('rollBtn');
const restartBtn = document.getElementById('restartBtn');

function randomDice() {
  return Math.floor(Math.random() * 6);
}

function rollAnimation(diceDiv) {
  diceDiv.classList.remove('roll-anim');
  void diceDiv.offsetWidth; // reset animation
  diceDiv.classList.add('roll-anim');
}

function rollDice() {
  rollBtn.disabled = true;
  msgDiv.textContent = "Rolling...";

  rollAnimation(diceDiv1);
  rollAnimation(diceDiv2);

  setTimeout(() => {
    const val1 = randomDice();
    const val2 = randomDice();

    diceDiv1.textContent = diceFaces[val1];
    diceDiv2.textContent = diceFaces[val2];

    let msg = "";
    if (val1 > val2) {
      score1++;
      msg = `🔥 Player 1 WINS the round!`;
      scoreDiv1.style.color = "#ffe164";
      scoreDiv2.style.color = "#fff";
    } else if (val2 > val1) {
      score2++;
      msg = `🔥 Player 2 WINS the round!`;
      scoreDiv2.style.color = "#ffe164";
      scoreDiv1.style.color = "#fff";
    } else {
      msg = `✌️ It's a draw!`;
      scoreDiv1.style.color = "#ffe164";
      scoreDiv2.style.color = "#ffe164";
    }

    scoreDiv1.textContent = score1;
    scoreDiv2.textContent = score2;
    msgDiv.textContent = msg;

    checkWin();
    rollBtn.disabled = false;
  }, 650);
}

function checkWin() {
  if (score1 >= winScore || score2 >= winScore) {
    rollBtn.style.display = 'none';
    restartBtn.style.display = '';
    let winner = score1 > score2 ? "🏆 Player 1" : "🏆 Player 2";
    msgDiv.innerHTML = `<span class="winner">${winner} WINS the Game!</span>`;
    scoreDiv1.style.color = (score1 > score2 ? "#ffd700" : "#eee");
    scoreDiv2.style.color = (score2 > score1 ? "#ffd700" : "#eee");
  }
}

rollBtn.addEventListener('click', rollDice);
restartBtn.addEventListener('click', () => {
  score1 = score2 = 0;
  scoreDiv1.textContent = '0';
  scoreDiv2.textContent = '0';
  diceDiv1.textContent = diceFaces[0];
  diceDiv2.textContent = diceFaces[0];
  scoreDiv1.style.color = "#fff";
  scoreDiv2.style.color = "#fff";
  msgDiv.innerHTML = `First to <b>${winScore}</b> points wins!`;
  rollBtn.style.display = '';
  restartBtn.style.display = 'none';
});
