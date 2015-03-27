package print
class SprintPrintImpl{
	String content =''' He was an old man who fished alone in a skiff in the Gulf Stream and he had gone eighty-four days now without taking a fish. In the first forty days a boy had been with him. But after forty days without a fish the boy's parents had told him that the old man was now definitely and finally salao, which is the worst form of unlucky, and the boy had gone at their orders in another boat which caught three good fish the first week. It made the boy sad to see the old man come in each day with his skiff empty and he always went down to help him carry either the coiled lines or the gaff and harpoon and the sail that was furled around the mast. The sail was patched with flour sacks and, furled, it looked like the flag of permanent defeat.

The old man was thin and gaunt with deep wrinkles in the back of his neck. The brown blotches of the benevolent skin cancer the sun brings from its reflection on the tropic sea were on his cheeks. The blotches ran well down the sides of his face and his hands had the deep-creased scars from handling heavy fish on the cords. But none of these scars were fresh. They were as old as erosions in a fishless desert.

Everything about him was old except his eyes and they were the same color as the sea and were cheerful and undefeated.

"Santiago," the boy said to him as they climbed the bank from where the skiff was hauled up. "I could go with you again. We've made some money."

The old man had taught the boy to fish and the boy loved him.

"No," the old man said. "You're with a lucky boat. Stay with them."

"But remember how you went eighty-seven days without fish and then we caught big ones every day for three weeks."

"I remember," the old man said. "I know you did not leave me because you doubted."

"It was papa made me leave. I am a boy and I must obey him."

"I know," the old man said. "It is quite normal."

"He hasn't much faith."

"No," the old man said. "But we have. Haven't we?"

"Yes," the boy said. "Can I offer you a beer on the Terrace and then we'll take the stuff home."

"Why not?" the old man said. "Between fishermen."

They sat on the Terrace and many of the fishermen made fun of the old man and he was not angry. Others, of the older fishermen, looked at him and were sad. But they did not show it and they spoke politely about the current and the depths they had drifted their lines at and the steady good weather and of what they had seen. The successful fishermen of that day were already in and had butchered their marlin out and carried them laid full length across two planks, with two men staggering at the end of each plank, to the fish house where they waited for the ice truck to carry them to the market in Havana. Those who had caught sharks had taken them to the shark factory on the other side of the cove where they were hoisted on a block and tackle, their livers removed, their fins cut off and their hides skinned out and their flesh cut into strips for salting.

When the wind was in the east a smell came across the harbour from the shark factory; but today there was only the faint edge of the odour because the wind had backed into the north and then dropped off and it was pleasant and sunny on the Terrace.

"Santiago," the boy said.

"Yes," the old man said. He was holding his glass and thinking of many years ago.

"Can I go out to get sardines for you for tomorrow?"

"No. Go and play baseball. I can still row and Rogelio will throw the net."

"I would like to go. If I cannot fish with you, I would like to serve in some way."

"You bought me a beer," the old man said. "You are already a man."

"How old was I when you first took me in a boat?"

"Five and you nearly were killed when I brought the fish in too green and he nearly tore the boat to pieces. Can you remember?"

"I can remember the tail slapping and banging and the thwart breaking and the noise of the clubbing. I can remember you throwing me into the bow where the wet coiled lines were and feeling the whole boat shiver and the noise of you clubbing him like chopping a tree down and the sweet blood smell all over me."

"Can you really remember that or did I just tell it to you?"

"I remember everything from when we first went together."

The old man looked at him with his sun-burned, confident loving eyes.

"If you were my boy I'd take you out and gamble," he said. "But you are your father's and your mother's and you are in a lucky boat."

"May I get the sardines? I know where I can get four baits too."

"I have mine left from today. I put them in salt in the box."

"Let me get four fresh ones."

"One," the old man said. His hope and his confidence had never gone. But now they were freshening as when the breeze rises.

"Two," the boy said.

"Two," the old man agreed. "You didn't steal them?"

"I would," the boy said. "But I bought these."

"Thank you," the old man said. He was too simple to wonder when he had attained humility. But he knew he had attained it and he knew it was not disgraceful and it carried no loss of true pride.

"Tomorrow is going to be a good day with this current," he said.

"Where are you going?" the boy asked.

"Far out to come in when the wind shifts. I want to be out before it is light."

"I'll try to get him to work far out," the boy said. "Then if you hook something truly big we can come to your aid."

"He does not like to work too far out."

"No," the boy said. "But I will see something that he cannot see such as a bird working and get him to come out after dolphin."

"Are his eyes that bad?"

"He is almost blind."

"It is strange," the old man said. "He never went turtle-ing. That is what kills the eyes."

"But you went turtle-ing for years off the Mosquito Coast and your eyes are good."

"I am a strange old man."

"But are you strong enough now for a truly big fish?"

"I think so. And there are many tricks."

"Let us take the stuff home," the boy said. "So I can get the cast net and go after the sardines."

They picked up the gear from the boat. The old man carried the mast on his shoulder and the boy carried the wooden box with the coiled, hard-braided brown lines, the gaff and the harpoon with its shaft. The box with the baits was under the stern of the skiff along with the club that was used to subdue the big fish when they were brought alongside. No one would steal from the old man but it was better to take the sail and the heavy lines home as the dew was bad for them and, though he was quite sure no local people would steal from him, the old man thought that a gaff and a harpoon were needless temptations to leave in a boat.

They walked up the road together to the old man's shack and went in through its open door. The old man leaned the mast with its wrapped sail against the wall and the boy put the box and the other gear beside it. The mast was nearly as long as the one room of the shack. The shack was made of the tough bud-shields of the royal palm which are called guano and in it there was a bed, a table, one chair, and a place on the dirt floor to cook with charcoal. On the brown walls of the flattened, overlapping leaves of the sturdy fibered guano there was a picture in color of the Sacred Heart of Jesus and another of the Virgin of Cobre. These were relics of his wife. Once there had been a tinted photograph of his wife on the wall but he had taken it down because it made him too lonely to see it and it was on the shelf in the corner under his clean shirt.'''

	HashSet exclusive=["the", "a", "an", "and"]

	public void sp(){
		String[] a = content.split(" ")

		a.each{String str->
			/*	int previousSize=0
			 int size=str.size()
			 if (size < previousSize){
			 print print "\b"* str.size()
			 }*/
			print str
			Thread.sleep(calculateDelay(str))
			print "\b \b"* str.size()
		}
	}

	int calculateDelay(String str){
		double weight =1
		if (exclusive.contains(str)){
			weight=0.8
		}
		return weight*320
	}
}

println "------"
SprintPrintImpl p = new SprintPrintImpl();
p.sp()
