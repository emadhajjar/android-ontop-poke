package ontop.poke.data.model

import com.google.gson.annotations.SerializedName

data class PokemonDetailsResponse(
    val abilities: List<Ability>,

    @SerializedName("base_experience")
    val baseExperience: Int,

    val forms: List<Species>,

    @SerializedName("game_indices")
    val gameIndices: List<GameIndex>,

    val height: Int,

    @SerializedName("held_items")
    val heldItems: List<Any>,

    val id: Int,

    @SerializedName("is_default")
    val isDefault: Boolean,

    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String,

    val moves: List<Move>,
    val name: String,
    val order: Int,

    @SerializedName("past_types")
    val pastTypes: List<Any>,

    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int,
)

data class Ability(
    val ability: Species,

    @SerializedName("is_hidden")
    val isHidden: Boolean,

    val slot: Int,
)

data class Species(
    val name: String,
    val url: String,
)

data class GameIndex(
    @SerializedName("game_index")
    val gameIndex: Int,

    val version: Species,
)

data class Move(
    val move: Species,

    @SerializedName("version_group_details")
    val versionGroupDetails: List<VersionGroupDetail>,
)

data class VersionGroupDetail(
    @SerializedName("level_learned_at")
    val levelLearnedAt: Int,

    @SerializedName("move_learn_method")
    val moveLearnMethod: Species,

    @SerializedName("version_group")
    val versionGroup: Species,
)

data class GenerationV(
    @SerializedName("black-white")
    val blackWhite: Sprites,
)

data class GenerationIv(
    @SerializedName("diamond-pearl")
    val diamondPearl: Sprites,

    @SerializedName("heartgold-soulsilver")
    val heartgoldSoulsilver: Sprites,

    val platinum: Sprites,
)

data class Versions(
    @SerializedName("generation-i")
    val generationI: GenerationI,

    @SerializedName("generation-ii")
    val generationIi: GenerationIi,

    @SerializedName("generation-iii")
    val generationIii: GenerationIii,

    @SerializedName("generation-iv")
    val generationIv: GenerationIv,

    @SerializedName("generation-v")
    val generationV: GenerationV,

    @SerializedName("generation-vi")
    val generationVi: Any,

    @SerializedName("generation-vii")
    val generationVii: GenerationVii,

    @SerializedName("generation-viii")
    val generationViii: GenerationViii,
)

data class Sprites(
    @SerializedName("back_default")
    val backDefault: String,

    @SerializedName("back_female")
    val backFemale: String? = null,

    @SerializedName("back_shiny")
    val backShiny: String,

    @SerializedName("back_shiny_female")
    val backShinyFemale: String? = null,

    @SerializedName("front_default")
    val frontDefault: String,

    @SerializedName("front_female")
    val frontFemale: String? = null,

    @SerializedName("front_shiny")
    val frontShiny: String,

    @SerializedName("front_shiny_female")
    val frontShinyFemale: String? = null,

    val other: Other? = null,
    val versions: Versions? = null,
    val animated: Sprites? = null,
)

data class GenerationI(
    @SerializedName("red-blue")
    val redBlue: RedBlue,

    val yellow: RedBlue,
)

data class RedBlue(
    @SerializedName("back_default")
    val back_default: String,

    @SerializedName("back_gray")
    val backGray: String,

    @SerializedName("back_transparent")
    val backTransparent: String,

    @SerializedName("front_default")
    val frontDefault: String,

    @SerializedName("front_gray")
    val frontGray: String,

    @SerializedName("front_transparent")
    val frontTransparent: String,
)

data class GenerationIi(
    val crystal: Crystal,
    val gold: Gold,
    val silver: Gold,
)


data class Crystal(
    @SerializedName("back_default")
    val backDefault: String,

    @SerializedName("back_shiny")
    val backShiny: String,

    @SerializedName("back_shiny_transparent")
    val backShinyTransparent: String,

    @SerializedName("back_transparent")
    val backTransparent: String,

    @SerializedName("front_default")
    val frontDefault: String,

    @SerializedName("front_shiny")
    val frontShiny: String,

    @SerializedName("front_shiny_transparent")
    val frontShinyTransparent: String,

    @SerializedName("front_transparent")
    val frontTransparent: String,
)

data class Gold(
    @SerializedName("back_default")
    val backDefault: String,

    @SerializedName("back_shiny")
    val backShiny: String,

    @SerializedName("front_default")
    val frontDefault: String,

    @SerializedName("front_shiny")
    val frontShiny: String,

    @SerializedName("front_transparent")
    val frontTransparent: String? = null,
)

data class GenerationIii(
    val emerald: OfficialArtwork,

    @SerializedName("firered-leafgreen")
    val fireredLeafgreen: Gold,

    @SerializedName("ruby-sapphire")
    val rubySapphire: Gold
)

data class OfficialArtwork(
    @SerializedName("front_default")
    val frontDefault: String,

    @SerializedName("front_shiny")
    val frontShiny: String,
)

data class Home(
    @SerializedName("front_default")
    val frontDefault: String,

    @SerializedName("front_female")
    val frontFemale: String? = null,

    @SerializedName("front_shiny")
    val frontShiny: String,

    @SerializedName("front_shiny_female")
    val frontShinyFemale: String? = null,
)

data class GenerationVii(
    val icons: DreamWorld,

    @SerializedName("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: Home,
)

data class DreamWorld(
    @SerializedName("front_default")
    val frontDefault: String,
)

data class GenerationViii(
    val icons: DreamWorld,
)


data class Other(
    @SerializedName("dream_world")
    val dreamWorld: DreamWorld,

    val home: Home,

    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtwork,
)

data class Stat(
    @SerializedName("base_stat")
    val baseStat: Int,

    val effort: Int,
    val stat: Species,
)

data class Type(
    val slot: Int,
    val type: Species,
)

